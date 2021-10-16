package com.springcloud.controller;

import com.springcloud.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @RequestMapping("/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return hystrixService.ok(id);
    }

    @RequestMapping("/timeOut/{id}")
    public String timeOut(@PathVariable("id") Integer id) throws InterruptedException {
        return hystrixService.timeOut(id);
    }

    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = hystrixService.paymentCircuitBreaker(id);
        return result;
    }

}
