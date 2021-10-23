package com.springalibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seate-stroage-module2002")
public interface StorageService {

    @RequestMapping("/storage/decrease")
    public Integer de(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
