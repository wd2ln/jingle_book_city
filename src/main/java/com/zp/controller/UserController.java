package com.zp.controller;

import com.zp.entity.User;
import com.zp.service.UserService;
import com.zp.util.JasyptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(String uName, String uPwd, HttpServletRequest request, HttpSession session) {
        User user = new User();
        user.setuName(uName);
        user.setuPwd(uPwd);
        User user1 = userService.login(user);
        if (user1!=null){
            session.setAttribute("user",user1);
            request.setAttribute("msg","登录成功");
            return new ModelAndView("redirect:/index.jsp");
        }else {
            request.setAttribute("failMsg","用户名不存在！");
            return new ModelAndView("forward:user_login.jsp");
        }
    }
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ModelAndView register(User user,HttpServletRequest request,HttpSession session){
        user.setuRole(1);
        user.setuMark("普通用户");
        boolean user2=userService.register(user);
        if (user2){
            session.setAttribute("user",user2);
            request.setAttribute("msg","注册成功");
            return new ModelAndView("redirect:/user_login.jsp");
        }else {
            request.setAttribute("failMsg","用户名重复！");
            return new ModelAndView("forward:user_register.jsp");
        }
    }
    @RequestMapping("logout.action")
    public ModelAndView logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return new ModelAndView("redirect:/user_login.jsp");
    }

}
