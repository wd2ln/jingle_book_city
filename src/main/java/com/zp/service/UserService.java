package com.zp.service;

import com.zp.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User login(User user);
}
