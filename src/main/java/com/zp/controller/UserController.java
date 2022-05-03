package com.zp.controller;

import com.zp.entity.User;
import com.zp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin
@RestController
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
            return new ModelAndView("redirect:/index");
        }else {
            request.setAttribute("failMsg","用户名不存在！");
            return new ModelAndView("forward:user_login.jsp");
        }
    }
}
