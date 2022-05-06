package com.zp.service.impl;

import com.zp.dao.BookMapper;
import com.zp.dao.OrderMapper;
import com.zp.entity.Order;
import com.zp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Order> queryOrdersByuId(Integer uId) {

       List<Order> orders=new ArrayList<>();

            try {
                orders=orderMapper.queryordersByuId(uId);
                for (Order order : orders) {
                    order.setItemList(orderMapper.queryOrderItemByUidAndOid(order.getoId()));
                    for (int j = 0; j < order.getItemList().size(); j++) {
                        order.getItemList().get(j).setBook(bookMapper.selectByPrimaryKey(order.getItemList().get(j).getbId()));
                    }
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }


        return orders;
    }

}
