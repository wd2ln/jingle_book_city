package com.zp.controller;

import com.zp.entity.Book;
import com.zp.entity.Order;
import com.zp.service.BookService;
import com.zp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class OrderController {
    @Autowired
    public BookService bookService;
    @Autowired
    public OrderService orderService;

    @RequestMapping("books_buy")
    public void AddBookToCart(@RequestParam("bId") String bId,
                              HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
            Order order=null;

            if (request.getSession().getAttribute("order")!=null){
                order= (Order) request.getSession().getAttribute("order");
            }else {
                order=new Order();
                order.setoAmount(0);
                order.setoTotal(0.0F);
                request.getSession().setAttribute("order",order);
            }


             Book book = bookService.selBookId(bId);

            if (book.getbStock()>0){
                    order.addbooks(book);
                    response.getWriter().println("ok");
            }else{
                response.getWriter().print("fail");
            }

    }
}
