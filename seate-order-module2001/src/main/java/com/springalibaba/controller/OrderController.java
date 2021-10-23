package com.springalibaba.controller;

import com.springalibaba.domain.Order;
import com.springalibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/createorder")
    public int createOrder(Order order){
       orderService.create(order);
       return 1;
    }
}
