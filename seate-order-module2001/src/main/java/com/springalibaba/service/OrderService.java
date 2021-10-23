package com.springalibaba.service;

import com.springalibaba.domain.Order;

public interface OrderService {

    int create(Order order);

    int update(Long userId,Integer status);
}
