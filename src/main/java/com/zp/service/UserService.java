package com.zp.service;

import com.zp.entity.User;

public interface UserService {
    User login(User user);

    boolean register(User user);


}
