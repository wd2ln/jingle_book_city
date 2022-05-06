package com.zp.service.impl;

import com.zp.dao.UserMapper;
import com.zp.entity.User;
import com.zp.entity.UserExample;
import com.zp.service.UserService;
import com.zp.util.JasyptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public boolean register(User user) {
        user.setuPwd(JasyptUtil.jia(user.getuPwd()));
        try {
            int i = userMapper.find(user.getuName());
            System.out.println(user.getuName());
                    if (i>=1)
                        return false;
                    user.setuRedgt(new Date());
                    userMapper.insert(user);
                    return true;
            }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
}

    @Override
    public boolean updatePwd(int uId, String olduPwd, String uPwd) {
        try {
            String s = userMapper.updatePwd(uId);
            if (!s.equals(JasyptUtil.jia(uPwd))){
            userMapper.updatePassword(uId,JasyptUtil.jia(uPwd));
            return true;
        }else {
            return false;
        }
        }catch (Exception e){
            return false;
        }
    }
    @Override
    public boolean updatePhoneandAddress(int uId, String uPhone, String uAddress) {
        try {
            userMapper.updatePhoneAndAddress(uId,uPhone,uAddress);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
