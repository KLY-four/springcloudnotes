package com.springcloud.controller;

import com.springcloud.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MessageSendController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("/send")
    public String send(){
        messageService.send();
        return "发送完毕";
    }
}
