package com.zp.controller;

import com.zp.entity.User;
import com.zp.service.AdminService;
import com.zp.util.JasyptUtil;
import com.zp.vo.PageVo;
import com.zp.vo.UpdateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    @RequestMapping("logout")
    public ModelAndView logout(
                              HttpSession session,
                              HttpServletRequest request){
        //销毁session
        session.removeAttribute("user");
        session.invalidate();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:http://localhost:8080/index");
        //跳转操作
        return modelAndView;
    }

    /**
     *修改密码
     */
    @RequestMapping("change_password")
    public ModelAndView updatePassword(
            HttpSession session,
            HttpServletRequest request,
            Integer uId,
            String uPwd
    ){

        User user = adminService.updatePwd(uId, JasyptUtil.jia(uPwd));
        if(user!=null){
            session.setAttribute("user",user);
            request.setAttribute("msg","修改成功！");
        }else {
            request.setAttribute("failMsg","修改失败！");
        }
        //跳转操作
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:user_list?pageNumber=1");
        return modelAndView;
    }
    @RequestMapping("user_list")
    public ModelAndView findAll(
            Integer pageNumber,
            HttpServletRequest request){
        //判断传入的页数合法性
        pageNumber=pageNumber>0 ? pageNumber : 1;

        PageVo alls = adminService.findAlls(pageNumber);

        //获取的数据放入request中
        request.setAttribute("p",alls);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("forward:/admin/user_list.jsp");
        //跳转操作
        return modelAndView;
    }
    @RequestMapping("user_delete")
    public ModelAndView del(
            Integer uId){
        adminService.del(uId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:user_list?pageNumber=1");
        //跳转操作
        return modelAndView;
    }
    @RequestMapping("user_edit_show")
    public ModelAndView show(
            HttpServletRequest request,
            Integer uId){
        ModelAndView modelAndView = new ModelAndView();
        User user=adminService.show(uId);
        System.out.println(user==null);
        if (user!=null){
            System.out.println("==========");
            request.setAttribute("u",user);
            modelAndView.setViewName("forward:/admin/user_edit.jsp");
        }else {
            System.out.println("------------");

            modelAndView.setViewName("redirect:user_list?pageNumber=1");

        }
        //跳转操作user_update
        return modelAndView;
    }
    @RequestMapping("user_update")
    public ModelAndView update(
            HttpSession session, User user){
        ModelAndView modelAndView = new ModelAndView();
        adminService.updateInfo(user);
        modelAndView.setViewName("redirect:user_list?pageNumber=1");
        //跳转操作
        return modelAndView;
    }
}
