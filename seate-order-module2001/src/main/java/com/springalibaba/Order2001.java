package com.springalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单服务
 * */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Order2001 {
    public static void main(String[] args) {
        SpringApplication.run(Order2001.class,args);
    }
}
