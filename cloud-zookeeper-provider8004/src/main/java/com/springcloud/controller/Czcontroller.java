package com.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class Czcontroller {


    @RequestMapping("/select")
    public String select(){
        return "zookeeper";
    }
}
