package com.zp.controller;

import com.zp.service.AdminOrderService;
import com.zp.vo.Page1Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("admin")
public class AdminOrderController {
    @Autowired
    private AdminOrderService adminOrderService;
    @RequestMapping("order_list")
    public ModelAndView orderlist(
            HttpServletRequest request, Integer pageNumber, Integer oStatus	){
        request.setAttribute("ostatus",oStatus);
        ModelAndView modelAndView = new ModelAndView();
        Page1Vo page1Vo = adminOrderService.orderLists(pageNumber, oStatus);
        request.setAttribute("p", page1Vo);
        if (false){
            return null;
        }
        modelAndView.setViewName("forward:/admin/order_list.jsp");
        //跳转操作order_list
        return modelAndView;
    }
    @RequestMapping("order_status_change")
    public ModelAndView orderStatus(
            String oId, Integer oStatus	){

        ModelAndView modelAndView = new ModelAndView();
        adminOrderService.updateStatus(oId,oStatus);
        modelAndView.setViewName("forward:order_list?pageNumber=1&ostatus="+oStatus);
        //跳转操作order_list
        return modelAndView;
    }
    @RequestMapping("order_delete")
    public ModelAndView orderDelete(
            String oId	){

        ModelAndView modelAndView = new ModelAndView();
        adminOrderService.del(oId);
        modelAndView.setViewName("forward:order_list?pageNumber=1&oStatus=1");
        //跳转操作order_list
        return modelAndView;
    }
}
