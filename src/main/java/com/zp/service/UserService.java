package com.zp.service;

import com.zp.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean login(User user);
}
