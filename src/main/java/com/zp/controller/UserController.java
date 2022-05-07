package com.zp.controller;

import com.zp.entity.User;
import com.zp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;

import com.zp.util.JasyptUtil;
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
            if (user1.getuRole()==0){
                user1.setIsadmin(true);
            }else {
                user1.setIsadmin(false);

            }
            session.setAttribute("user",user1);
            request.setAttribute("msg","登录成功");
            return new ModelAndView("redirect:/index");
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
    @RequestMapping("logout")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession(false);
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }

        if (session!=null){
            session.invalidate();
        }

        return new ModelAndView("redirect:/user_login.jsp");
    }
    @RequestMapping("change_password")
    public ModelAndView updatePwd(int uId,String olduPwd,String uPwd,HttpServletRequest request,HttpSession session){
        boolean i=userService.updatePwd(uId,olduPwd,uPwd);
        if (i){
            request.setAttribute("msg","修改成功");
            User user = (User) request.getSession().getAttribute("user");
            user.setuPwd(JasyptUtil.jia(user.getuPwd()));
            request.getSession().removeAttribute("user");
            request.getSession().setAttribute("user",user);
            return new ModelAndView("forward:user_center.jsp");
        }else {
            request.setAttribute("failMsg","修改密码时出现错误，请确认原密码是否正确或联系管理员!");
            return new ModelAndView("forward:user_center.jsp");
        }
    }
    @RequestMapping(value = "change_phone_and_address",method = RequestMethod.POST)
    public ModelAndView changAction(int uId,String uPhone,String uAddress,HttpServletRequest request,HttpSession session){
        boolean b = userService.updatePhoneandAddress(uId, uPhone, uAddress);
        if (b){
            request.setAttribute("msg","修改成功");
            User user = (User) request.getSession().getAttribute("user");
            user.setuPhone(uPhone);
            user.setuAddress(uAddress);
            request.getSession().removeAttribute("user");
            request.getSession().setAttribute("user",user);
            return new ModelAndView("forward:user_center.jsp");
        }else {
            request.setAttribute("msg","服务器正忙，请稍后重试！");
            return new ModelAndView("forward:user_center.jsp");
        }
    }
}
