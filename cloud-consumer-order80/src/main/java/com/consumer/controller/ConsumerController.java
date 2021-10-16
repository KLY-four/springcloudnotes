package com.consumer.controller;
import com.common.api.entities.PaymentEntity;
import com.common.api.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
@ResponseBody
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

//    private String url = "http://localhost:8001";  //不走eureka，直接指定地址发http
     private String url = "http://CLOUD-PAYMENT-SERVICE";  //通过微服务名称来调用(走eureka)

  //  private String zookeeperUrl = "http://cloud-zookeeper-provider8004";

    @RequestMapping("/insert")
    public ResponseResult insert(PaymentEntity paymentEntity) {
        ResponseResult result = restTemplate.postForObject(url+"/insert", new PaymentEntity("rr"), ResponseResult.class);
        return result;
    }

    @RequestMapping("/selectById")
    public ResponseResult selectById(Integer id){
        ResponseResult object =  restTemplate.getForObject(url+"/select?id=" + id, ResponseResult.class);
        return object;
    }

    /*@RequestMapping("/zk/select")
    public String select(){
        String object = restTemplate.getForObject(zookeeperUrl + "/select", String.class);
        return object;
    }*/
}
