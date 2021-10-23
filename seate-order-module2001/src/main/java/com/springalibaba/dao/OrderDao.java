package com.springalibaba.dao;

import com.springalibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao
{
    //新建订单
    Integer create(Order order);

    //修改订单状态，从零改为1
    int update(@Param("userId") Long userId,@Param("status") Integer status);
}

