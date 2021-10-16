package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringRunProvider8001 {
    public static void main(String[] args) {
        SpringApplication.run(SpringRunProvider8001.class,args);
    }
}
