package com.zp.service.impl;

import com.zp.dao.UserMapper;
import com.zp.entity.User;
import com.zp.service.AdminService;
import com.zp.util.JasyptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String addUser(User user) {
        //标记普通用户
        user.setuMark("普通用户");
        user.setuRole(1);
        //加密密码
        //user.setuPwd(JasyptUtil.jia(user.getuPwd()));
        //插入
        int i;
        try {
            i = userMapper.insertSelective(user);
            if (i>0){
                System.out.println("添加成功");
                return "redirect:user_list.action?pageNumber=1";
            }else {
                return null;
            }
        }catch (Exception e){
            System.out.println("添加失败");
            return null;
        }
    }
}
