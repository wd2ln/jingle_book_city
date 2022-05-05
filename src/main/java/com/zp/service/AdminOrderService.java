package com.zp.service;

import com.zp.vo.PageVo;

public interface AdminOrderService {
    PageVo orderLists(Integer pageNumber, Integer oStatus);
}
