package com.zp.service.impl;

import com.zp.dao.UserMapper;
import com.zp.entity.User;
import com.zp.entity.UserExample;
import com.zp.service.UserService;
import com.zp.util.JasyptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                        .andUNameEqualTo(user.getuName());
        try {
            List<User> users = userMapper.selectByExample(userExample);
            if (users.size()>0){
//                将拿到的密码与数据库的进行脱敏比对
                if (user.getuPwd().equals(JasyptUtil.jie(users.get(0).getuPwd()))){
                    return users.get(0);
                }else {
                    return null;
                }
            }
        }catch (Exception e){
            System.out.println("失败了！");
            return null;
        }
        return null;
    }
}
