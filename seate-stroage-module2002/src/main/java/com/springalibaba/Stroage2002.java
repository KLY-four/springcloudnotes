package com.springalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 库存服务
 * */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class Stroage2002 {
    public static void main(String[] args) {
        SpringApplication.run(Stroage2002.class,args);
    }
}
