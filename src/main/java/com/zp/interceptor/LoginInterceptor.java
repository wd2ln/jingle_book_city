package com.zp.interceptor;

import com.zp.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        System.out.println(user);
        //拦截未登录用户
        if (user!=null){
            System.out.println("存在");
            return true;
        }
        System.out.println("不存在");
        response.sendRedirect("/user_login.jsp");
        return false;
    }
}
