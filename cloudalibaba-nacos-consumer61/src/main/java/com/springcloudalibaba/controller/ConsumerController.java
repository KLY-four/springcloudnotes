package com.springcloudalibaba.controller;
import com.common.api.entities.PaymentEntity;
import com.common.api.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@ResponseBody
/**
 *  @RefreshScope注解并不是一个全局注解，他用在那个类上，则表示可以自动刷新该类中所获取的配置信息。
 *  如下面的s变量值，会自动进行刷新。
 * */
@RefreshScope  //保证配置信息的动态刷新。nacos的自动刷新比较强大，不需要像config那样手动刷新
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${nacos.spring}")
    private String s;

    @Value("${service-url.nacos-user-service}")
    private String url;

    @RequestMapping("/select")
    public String selectById(){
        String s =  restTemplate.getForObject(url+"/select", String.class);
        return s;
    }

    @RequestMapping("/get")
    public String get(){
        return s;
    }

}
