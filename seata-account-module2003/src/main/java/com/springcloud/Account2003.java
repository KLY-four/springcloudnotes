package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 账户余额服务
 * */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Account2003 {
    public static void main(String[] args) {
        SpringApplication.run(Account2003.class,args);
    }
}
