package com.zp.dao;

import com.zp.entity.Order;
import com.zp.entity.OrderExample;
import java.util.List;

import com.zp.entity.Orderitem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(String oId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(String oId);
    List<Order> selectByStatus(Integer ostatus);
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> queryordersByuId(Integer uId);

    List<Orderitem> queryOrderItemByUidAndOid(String getoId);
    int updateByZi(String oId, Integer oStatus);

    void addOrderitem(Orderitem value);
}
