package com.springalibaba.service;

import com.springalibaba.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient("seata-account-module2003")
public interface AccountService {

    @RequestMapping("/account/decrease")
    public void Moneyde(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
