package com.zp.controller;

import com.zp.entity.Book;
import com.zp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/index")
    public ModelAndView index1(ModelAndView mv,
                              HttpServletRequest request){

        Integer pageNumber=1;
        Integer pageSize=8;

        List<Book> list = new ArrayList<>();

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

            request.getServletContext().setAttribute("bookTypes",list);
        if (true){
           // return null;
        }
        mv.setViewName("forward:/index.jsp");
        return mv;
    }
}
