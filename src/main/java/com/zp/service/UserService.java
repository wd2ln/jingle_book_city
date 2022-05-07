package com.zp.service;

import com.zp.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User login(User user);

    boolean register(User user);

    boolean updatePwd(int uId, String olduPwd, String uPwd);

    boolean updatePhoneandAddress(int uId, String uPhone, String uAddress);

}
