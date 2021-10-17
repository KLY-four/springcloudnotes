package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

@Controller
@EnableBinding(Sink.class) //消费端同样需要绑定chnnel和交换机，sink表示输入，也就是获取消息
public class MessageConsumerController {

    @Value("${server.port}")
    private Integer port;

    @StreamListener(Sink.INPUT) //用于监听交换机的数据，当有数据时则触发消费
    public void getMessage(Message<String> message){
        System.out.println(port+"消费消息  ---》"+message.getPayload());
    }
}
