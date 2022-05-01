package com.zp.service.impl;

import com.zp.dao.UserMapper;
import com.zp.entity.User;
import com.zp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(User user) {
     userMapper.countByExample(user);
    }
}
