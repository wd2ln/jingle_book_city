package com.zp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zp.dao.BookMapper;
import com.zp.dao.OrderMapper;
import com.zp.dao.OrderitemMapper;
import com.zp.entity.*;
import com.zp.service.AdminOrderService;
import com.zp.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminOrderServiceImpl implements AdminOrderService {
    @Autowired
    private OrderitemMapper orderitemMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private BookMapper bookMapper;
    @Override
    public Boolean del(String oId) {
        try {
            int del = orderitemMapper.del(oId);
            if (del>0?true:false){
                int i = orderMapper.deleteByPrimaryKey(oId);
                if (i>0){
                    return true;
                }
                return false;
            }

        }catch (Exception e){
            return false;
        }
        return false;
    }

    @Override
    public Boolean updateStatus(String oId, Integer oStatus) {

        try {

            int i = orderMapper.updateByZi(oId, oStatus);
            if (i>0){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public PageVo orderLists(Integer pageNumber, Integer oStatus) {
        //设置参数
        Integer pageSize=8;
        //设置分页
        PageHelper.startPage(pageNumber,pageSize);
        PageVo pageVo = new PageVo();

//        List<BookOrderOrderitem> books = bookMapper.selectByStatus(oStatus);
        List<Order> orders = orderMapper.selectByStatus(oStatus);
        for (int i = 0; i < orders.size(); i++) {

            orders.get(i).setItemList(orderitemMapper.selectByOid(orders.get(i).getoId()));
            System.out.println(i);
            try {
                for (int j=0;j<orders.get(i).getItemList().size();j++){
                    orders.get(i).getItemList().get(j).setBook(bookMapper.selectByBname(orders.get(i).getItemList().get(j).getbId()));

                }
            }catch (Exception e){
                System.out.println("异常");
                System.out.println(e.getMessage());
            }

        }
        if (orders!=null){
            PageInfo<Order> bookPageInfo = new PageInfo<>(orders);
            Long total = bookPageInfo.getTotal();
            int i1 = total.intValue();
            //同一订单则拿取关键字段

            pageVo.setList(bookPageInfo.getList());
            pageVo.setPageNumber(bookPageInfo.getPageNum());
            pageVo.setPageSize(bookPageInfo.getPageSize());
            //数据总量
            pageVo.setTotalCount(orders.size());
            pageVo.setTotalPage(i1%pageSize==0?i1/pageSize:i1/pageSize+1);
        }
        return pageVo;
    }
}
