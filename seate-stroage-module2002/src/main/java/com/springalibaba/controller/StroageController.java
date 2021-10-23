package com.springalibaba.controller;

import com.springalibaba.service.StroageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StroageController {
    @Autowired
    private StroageService service;


    //扣减库存
    @RequestMapping("/storage/decrease")
    public void decrease(Long productId, Integer count) {
        service.decrease(productId, count);
        return;
    }

}
