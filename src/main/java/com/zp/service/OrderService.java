package com.zp.service;

import com.zp.entity.Order;
import com.zp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderService {
    public boolean addOrder(Order order);

    List<Order> queryOrdersByuId(Integer uId);
}
