package com.zp.controller;

import com.zp.entity.Book;
import com.zp.entity.Order;
import com.zp.entity.User;
import com.zp.service.BookService;
import com.zp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class OrderController {
    @Autowired
    public BookService bookService;
    @Autowired
    public OrderService orderService;

    @RequestMapping("order_list")
    public ModelAndView QueryorderByuId(ModelAndView mv,
                                        HttpServletRequest request,
                                        HttpSession session){
        User user;
        if (request.getSession().getAttribute("user")!=null){
            user= (User) request.getSession().getAttribute("user");

               List<Order> orderList = orderService.queryOrdersByuId(user.getuId());

               request.setAttribute("orderList",orderList);

            mv.setViewName("/order_list");
        }else {
            mv.setViewName("redirect:/index");
        }
        return mv;
    }


    @RequestMapping("books_buy")
    public void AddBookToCart(@RequestParam("bId") Integer bId,
                              HttpServletRequest request,
                              HttpServletResponse response) throws IOException {
            Order order=null;

            if (request.getSession(false).getAttribute("order")!=null){
                order= (Order) request.getSession().getAttribute("order");
            }else {
                order=new Order();
                order.setoAmount(0);
                order.setoTotal(0.0F);
                order.setoId(new SimpleDateFormat("YYYYMMDDHHmmss").format(new Date()));
                order.setoPaytype(1);
                order.setoStatus(2);
                //获取用户信息
                User user=bookService.getUserInfo(((User)(request.getSession(false).getAttribute("user"))).getuId());
                order.setuId(user.getuId());
                order.setoRealname(user.getuRealname());
                order.setoPhone(user.getuPhone());
                order.setoAddress(user.getuAddress());
                order.setoDatetime(new Date());
                request.getSession().setAttribute("order",order);
            }


             Book book = bookService.selBookId(bId,order);

            if (book.getbStock()>0){
                    order.addbooks(book);
                    response.getWriter().println("ok");
            }else{
                response.getWriter().print("fail");
            }

    }
}