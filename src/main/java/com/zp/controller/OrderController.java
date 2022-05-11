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
import java.util.Date;
import java.util.List;

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
        public ModelAndView AddBookToCart(ModelAndView mv,
                                        @RequestParam("bId") Integer bId,
                                  HttpServletRequest request,
                                  HttpServletResponse response) throws IOException {
                Order order;

                if (request.getSession().getAttribute("order")!=null){
                    order= (Order) request.getSession().getAttribute("order");
                }else {
                    order=new Order();
                    order.setoAmount(0);
                    order.setoTotal(0.0F);
                    request.getSession().setAttribute("order",order);
                }


                 Book book = bookService.queryBookByID(bId);

                if (book.getbStock()>0){
                        order.addbooks(book);

                        response.getWriter().println("ok");
                }else{
                    response.getWriter().print("fail");
                }
                return mv;
        }
    @RequestMapping("books_lessen")
    public ModelAndView LessenBookToCart(ModelAndView mv,
                                      @RequestParam("bId") Integer bId,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws IOException {
            Order order= (Order) request.getSession().getAttribute("order");
            order.lessen(bId);
            response.getWriter().println("ok");
        return mv;
    }

    @RequestMapping("books_delete")
    public ModelAndView DeleteBooks(ModelAndView mv,@RequestParam("bId") Integer bId,
                                                 HttpServletRequest request,
                                                HttpServletResponse response) throws IOException {
        Order order= (Order) request.getSession().getAttribute("order");
        order.delete(bId);
        response.getWriter().println("ok");


        return mv;
    }
        @RequestMapping("order_submit")
        public ModelAndView OrderSubmit(HttpServletRequest request,
                                        ModelAndView mv){
            if (request.getSession().getAttribute("user")!=null){
                mv.setViewName("/order_submit");
            }else {
                request.setAttribute("fail","Please SubmitOrder After Login!");
                mv.setViewName("redirect:/user_login.jsp");
            }


            return mv;
        }


        @RequestMapping("order_confirm")
        public ModelAndView ConfirmOrder(ModelAndView mv,
                                         int oPaytype,
                                         HttpServletRequest request){

        //获取订单信息，order属性
        Order order= (Order) request.getSession().getAttribute("order");

       //设置订单状态，支付方式
        if (oPaytype==3){
            order.setoStatus(1);
            }else {
            order.setoStatus(2);
        }
       order.setoPaytype(oPaytype);

       //获取user信息,user属性
       User user= (User) request.getSession().getAttribute("user");
       order.setuId(user.getuId());
       order.setoRealname(user.getuRealname());
       order.setoDatetime(new Date());
       order.setoPhone(user.getuPhone());
       order.setoAddress(user.getuAddress());
       boolean result=orderService.addOrder(order);
       if (result){
           //清除order属性
           request.getSession().removeAttribute("order");
           request.setAttribute("msg","订单支付成功！");
           mv.setViewName("forward:/order_result.jsp");
       }else {
           request.setAttribute("failmsg","订单支付失败！");
           mv.setViewName("forward:/order_result.jsp");
       }
        return mv;
        }

}
