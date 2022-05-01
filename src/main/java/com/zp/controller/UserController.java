package com.zp.controller;

import com.zp.dao.UserMapper;
import com.zp.entity.User;
import com.zp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username,String password) {
        User user = new User();
        user.setuName(username);
        user.setuPwd(password);
        boolean f = userService.login(user);
        if (f == true) {
            return "/index.action";
        } else {
            return "forward:user_login";
        }
    }
}
