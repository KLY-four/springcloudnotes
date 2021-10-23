package com.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringSentienl5001 {
    public static void main(String[] args) {
        SpringApplication.run(SpringSentienl5001.class,args);
    }
}
