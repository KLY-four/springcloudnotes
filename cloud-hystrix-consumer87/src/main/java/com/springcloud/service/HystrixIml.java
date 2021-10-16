package com.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class HystrixIml implements HystrixService88{
    @Override
    public String ok(Integer id) {
        return "";
    }

    @Override
    public String timeOut(Integer id) {
        return "服务宕机";
    }
}
