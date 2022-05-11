package com.zp.service;

import com.zp.vo.PageVo;

public interface AdminOrderService {
    PageVo orderLists(Integer pageNumber, Integer oStatus);

    Boolean updateStatus(String oId, Integer oStatus);

    Boolean del(String oId);
}
