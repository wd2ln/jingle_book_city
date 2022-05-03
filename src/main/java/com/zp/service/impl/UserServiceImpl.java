package com.zp.service.impl;

import com.zp.dao.UserMapper;
import com.zp.entity.User;
import com.zp.entity.UserExample;
import com.zp.service.UserService;
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
                        .andUNameEqualTo(user.getuName())
                                .andUPwdEqualTo(user.getuPwd());
        try {
            List<User> users = userMapper.selectByExample(userExample);
            if (users.size()>0){
                if (user.getuPwd().equals()){
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
