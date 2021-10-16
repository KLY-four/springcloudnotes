package com.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(value = "cloud-hystrix-provider8007",fallback = HystrixIml.class)
public interface HystrixService88 {

    @RequestMapping("/ok/{id}")
    public String ok(@PathVariable("id") Integer id);

    @RequestMapping("/timeOut/{id}")
    public String timeOut(@PathVariable("id") Integer id);
}
