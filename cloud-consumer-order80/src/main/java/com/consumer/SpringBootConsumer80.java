package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringBootConsumer80 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsumer80.class,args);
    }
}
