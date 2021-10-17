package com.springcloud.service.impl;

import com.springcloud.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

//注意：这里不需要加Service注解进行注入，该注解会自动注入
//该注解表示开启绑定器（绑定channel及交换机），同时指定source，这个就是输出的意思。因为这是一个消息提供者
@EnableBinding(Source.class)
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageChannel output;  //注入消息通道

    /**
     * 从该例子来看，stream屏蔽了消息中间件的差异，我们只需要面对统一的api进行编程即可
     * （很显然我们根本没有用到消息队列自己的api来对他们进行操作（因为是stream内部进行了实现，我们只面向stream的api））
     * binder是stream中用于对消息中间件封装的组件，也就是处在应用和消息中间件之间，帮我们
     * 处理了对不同消息中间件的操作封装。目前支持kafka、rabbit两种
     * */
    @Override
    public String send() {
        //发送消息
        //绑定器会向配置文件中所指定的消息中间件发送消息
        output.send(MessageBuilder.withPayload("hello stream").build());
        return null;
    }
}
