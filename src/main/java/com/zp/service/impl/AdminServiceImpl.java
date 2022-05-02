package com.zp.service.impl;

import com.zp.dao.UserMapper;
import com.zp.entity.User;
import com.zp.entity.UserExample;
import com.zp.service.AdminService;
import com.zp.util.JasyptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


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
        user.setuPwd(JasyptUtil.jia(user.getuPwd()));
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

    @Override
    public User updatePwd(Integer uId, String uPwd) {
        //设置更新所需条件
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUIdEqualTo(uId);
        //设置参数
        User user = new User();
        user.setuId(uId);
        user.setuPwd(uPwd);
        try {
            int i = userMapper.updateByExampleSelective(user, userExample);
            if(i>0){
                User user1 = userMapper.selectByKey(uId);
                return user1;
            }
        }catch ( Exception e){
            System.out.println("修改失败,请联系管理员");
        }

        return null;
    }
}
