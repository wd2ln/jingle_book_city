package com.zp.controller;

import com.zp.dao.BookMapper;
import com.zp.entity.Book;
import com.zp.entity.Booktype;
import com.zp.service.BookService;
import com.zp.service.BookTypeService;
import com.zp.service.FBookService;
import com.zp.vo.PageInfoVO;
import com.zp.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookTypeService bookTypeService;
    @Autowired
    private FBookService fBookService;

    @RequestMapping("/index")
    public ModelAndView index1(ModelAndView mv,
                              HttpServletRequest request){


        Integer pageNumber=1;
        Integer pageSize=8;

        List<Book> list ;

        for (int rtype=1;rtype<4;rtype++){


            list= bookService.sel(rtype,pageNumber,pageSize);

            if(rtype==1){
                request.setAttribute("scrollBook",list.get(0));
            }
            if(rtype==2){
                request.setAttribute("hotList",list);
            }
            if(rtype==3){
                request.setAttribute("newList",list);
            }
            System.out.println("=====================");
        }

            List<Booktype> booktypes= bookTypeService.select();

            request.getServletContext().setAttribute("bookTypes",booktypes);

            mv.setViewName("/index");
        return mv;
    }
    @RequestMapping("recommend_books")
    public ModelAndView recommend(Integer rType,int pageNumber,HttpServletRequest request){
        if (pageNumber<=0){
            pageNumber=1;
        }
        PageVo p=bookService.recommendBook(rType,pageNumber);
        if (p.getTotalPage()==0){
            p.setTotalPage(1);
            p.setPageNumber(1);
        }else {
            if(pageNumber>=p.getTotalPage()+1)
            {
                p = bookService.recommendBook(rType,p.getTotalPage());
            }
        }
        request.setAttribute("p",p);
        request.setAttribute("t",rType);
        return new ModelAndView("forward:booktypes_list.jsp");
    }
    @RequestMapping("booktypes_list")
    public ModelAndView BookType(int pageNumber,Integer btId,HttpServletRequest request){
        System.out.println(btId+"ppp"+pageNumber);
        String btname=null;
        if (btId!=0){
            btname= fBookService.findBookTypeById(btId);
        }
        request.setAttribute("btname",btname);
        if (pageNumber<=0){
            pageNumber=1;
        }
        PageInfoVO p=fBookService.findBookTypeId(btId,pageNumber);
        System.out.println(p.getList().size());
        if (p.getTotalPage()==0){
            p.setTotalPage(1);
            p.setPageNumber(1);
        }else {
            if(pageNumber>=p.getTotalPage()+1) {
                p=fBookService.findBookTypeId(btId,p.getTotalPage());
                System.out.println(p.getList().size());

            }
        }
        request.setAttribute("p",p);
        request.setAttribute("btId",btId);
        request.setAttribute("t",btname);
        return new ModelAndView("forward:book_detail.jsp");
    }
    @RequestMapping("book_detail")
    public ModelAndView findBook(int bId,HttpServletRequest request){
            Book f = bookService.find(bId);
            request.setAttribute("f",f);
            return new ModelAndView("forward:book_detail.jsp");
    }
    @RequestMapping("search_books")
    public ModelAndView searchBook(int pageNumber,String keyword,HttpServletRequest request){
        if (pageNumber<=0){
                pageNumber=1;
        }
        PageVo p=bookService.searchBook(pageNumber,keyword);
        if (p.getTotalPage()==0){
            p.setTotalPage(1);
            p.setPageNumber(1);
        }else {
            if (pageNumber>=p.getTotalPage()+1){
                p=bookService.searchBook(p.getTotalPage(),keyword);
            }
        }
        request.setAttribute("p",p);
        request.setAttribute("keyword",keyword);
        return new ModelAndView("forward:book_search.jsp");
    }
}
