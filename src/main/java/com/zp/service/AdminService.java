package com.zp.service;

import com.zp.entity.User;
import com.zp.vo.Page1Vo;

public interface AdminService {
    String addUser(User user);

    User updatePwd(Integer uId, String uPwd);

    Page1Vo findAlls(Integer pageNumber);

    Boolean del(Integer uId);

    User show(Integer uId);

    Boolean updateInfo(User user);

}
