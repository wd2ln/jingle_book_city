package com.zp.controller;

import com.zp.dao.BookMapper;
import com.zp.entity.Book;
import com.zp.entity.Booktype;
import com.zp.service.BookService;
import com.zp.service.BookTypeService;
//<<<<<<< HEAD
//<<<<<<< HEAD
import com.zp.vo.PageVO;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//=======
//=======
import com.zp.service.FBookService;
import com.zp.vo.PageInfoVO;
//>>>>>>> zsj
import com.zp.vo.PageVo;
//>>>>>>> zsj
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
//<<<<<<< HEAD

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin")
//=======
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@RestController
//>>>>>>> zsj
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookTypeService bookTypeService;
    @Autowired
    private FBookService fBookService;
//<<<<<<< HEAD
    @RequestMapping("book_edit_show")
    public String book_edit_show (Integer bid,
                                  HttpServletRequest request){
        request.setAttribute("g", bookService.byId(bid));
//=======
//
//>>>>>>> zsj

        return "admin/book_edit";
    }

    @RequestMapping("book_add")
    public String book_add (HttpServletRequest request) throws Exception {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> list = upload.parseRequest(request);
            Book b = new Book();

            for (FileItem item : list) {
                if (item.isFormField()) {
                    switch (item.getFieldName()) {
                        case "bname":
                            b.setBtName(item.getString("utf-8"));
//                            System.out.println(b.getBtName());
                            break;
                        case "bIsbn":
                            b.setbIsbn(item.getString("utf-8"));
                            break;
                        case "bauthor":
                            b.setbAuthor(item.getString("utf_8"));
                            break;
                        case "bpublisher":
                            b.setbPublisher(item.getString("utf-8"));
                        case "bprice":
                            b.setbPrice(Float.parseFloat(item.getString("utf-8")));
                            break;
                        case "btid":
                            b.setBtId(Integer.parseInt(item.getString("utf-8")));
                            break;
                        case "bstock":
                            b.setbStock(Integer.parseInt(item.getString("utf-8")));
                        case "bmark":
                            b.setbMark(item.getString("utf-8"));
                            break;
                    }
                } else {
                    if (item.getInputStream().available() <= 0) continue;
                    String fileName = item.getName();
                    fileName = fileName.substring(fileName.lastIndexOf("."));
                    fileName = "/" + new Date().getTime() + fileName;
                    String path = request.getServletContext().getRealPath("/images") + fileName;
                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(path);
                    byte[] buffer = new byte[1024];
                    int len = 0;
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer);
                    }
                    in.close();
                    out.close();
                    item.delete();
                    switch (item.getFieldName()) {
                        case "bcover":
                            b.setbCover("images" + fileName);
                            break;
                        case "bimage1":
                            b.setbImage1("images" + fileName);
                            break;
                        case "bimage2":
                            b.setbImage2("images" + fileName);
                            break;
                    }
                }
            }
            bookService.addBook(b);
        } catch (FileUploadException e) {
            System.out.println(e.getMessage());
        }

        return "redirect:book_list?pageNumber=1&rtype=0";
    }

    @RequestMapping("book_list")
    public String book_list (Integer pageNumber,
                             Integer rtype,
                             HttpServletRequest request) {
        if (pageNumber <= 0)
            pageNumber = 1;
        PageVO p = bookService.queryBook(pageNumber, rtype);
        if (p.getTotalPage() == 0) {
            p.setTotalPage(1);
            p.setPageNumber(1);
        } else {
            if (pageNumber >= p.getTotalPage() + 1) {
                p = bookService.queryBook(rtype, p.getTotalPage());
            }
        }
        request.setAttribute("p", p);
        request.setAttribute("rtype", rtype);

        List<Booktype> booktypes = bookTypeService.select();

        request.getServletContext().setAttribute("bookTypes", booktypes);


        return "/admin/book_list";
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
    public ModelAndView findBook(int bId, HttpServletRequest request){
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
