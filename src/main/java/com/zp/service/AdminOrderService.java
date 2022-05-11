package com.zp.service;

import com.zp.vo.Page1Vo;

public interface AdminOrderService {
    Page1Vo orderLists(Integer pageNumber, Integer oStatus);

    Boolean updateStatus(String oId, Integer oStatus);

    Boolean del(String oId);
}
