package com.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpConfig {

    @Bean
    @LoadBalanced
//    如果我们不走eureka(也就是直接ip:port来吊其他服务)，那么该注解不能加，因为该注解需要配合eureka上的服务一起用
      //所以如果我们通过服务(也就是http://CLOUD-PAYMENT-SERVICE，而不是ip:port)来调，那么该注解必须加。
    //博客:https://blog.csdn.net/sinat_36710456/article/details/80041619
    //当然，该注解不仅仅只针对eureka，在zookeeper、consul等中也是一样的原理
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
