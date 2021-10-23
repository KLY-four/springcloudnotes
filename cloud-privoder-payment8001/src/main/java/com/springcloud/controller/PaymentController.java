package com.springcloud.controller;

import com.common.api.entities.PaymentEntity;
import com.common.api.response.ResponseResult;
import com.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient; //该配置可以获取注册中心（从yaml中配置的地址）的一些信息，后续比较常用

    @RequestMapping("/insert")
    public ResponseResult<PaymentEntity> insert(@RequestBody PaymentEntity paymentEntity){
        int i = paymentService.insert(paymentEntity);
        if(i>0){
            return new ResponseResult<>(200,"成功", paymentEntity,port);
        }else {
            return new ResponseResult<>(9999,"失败",null,port);
        }
    }

    @RequestMapping("/select")
    public ResponseResult<List<PaymentEntity>> selectById(Integer id){
        List<PaymentEntity> list = paymentService.selectById(id);
        return new ResponseResult<>(200,"成功",list,port);
    }

    @RequestMapping("/getInfo")
    public void getInfo(){
        List<String> services = discoveryClient.getServices(); //获取eureka上的服务
        System.out.println(services);

        List<ServiceInstance> instances = discoveryClient.getInstances("");//根据服务名称获取到所有的服务实例
        for (ServiceInstance s:instances
             ) {
            System.out.println(s.getHost());
            System.out.println(s.getPort());
            System.out.println(s.getUri());
        }
    }
}
