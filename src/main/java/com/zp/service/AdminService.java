package com.zp.service;

import com.zp.entity.User;
import com.zp.vo.PageVo;

import java.util.List;
import java.util.Map;

public interface AdminService {
    String addUser(User user);

    User updatePwd(Integer uId, String uPwd);

    PageVo findAlls(Integer pageNumber);

    Boolean del(Integer uId);

    User show(Integer uId);
}
