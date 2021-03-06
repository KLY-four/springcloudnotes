package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer  //开启配置中心
public class CloudConfig3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfig3344.class,args);
    }
}
