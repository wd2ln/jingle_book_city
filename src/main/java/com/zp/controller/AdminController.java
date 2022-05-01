package com.zp.controller;

import com.zp.entity.User;
import com.zp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("admin")
//@ResponseBody
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("user_add")
    public ModelAndView add1( User user,
                            HttpServletResponse response,
                            HttpServletRequest request){
        System.out.println("start");
        System.out.println(user.getuName());
        ModelAndView modelAndView = new ModelAndView();
        //添加用户
        String status = adminService.addUser(user);
        //判断是否添加成功
        if (status!=null){
            System.out.println("666");
            System.out.println(status);
            modelAndView.setViewName(status);
        }else {
            request.setAttribute("msg","用户名重复！");
            modelAndView.setViewName("forward:/admin/user_add.jsp");
        }
        //跳转操作
        return modelAndView;
    }
}
