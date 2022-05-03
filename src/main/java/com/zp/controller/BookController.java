package com.zp.controller;

import com.zp.entity.Book;
import com.zp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("admin")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("book_edit_show")
    public String book_edit_show(Integer bId,
                                 HttpServletRequest request){
        request.setAttribute("g",bookService.byId(bId));

        return "admin/book_edit";
    }
}
