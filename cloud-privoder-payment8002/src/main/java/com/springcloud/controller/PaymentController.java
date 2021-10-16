package com.springcloud.controller;

import com.common.api.entities.PaymentEntity;
import com.common.api.response.ResponseResult;
import com.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
}
