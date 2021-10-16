package com.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class ConsulController {

    @RequestMapping("/select/{id}")
    public String de(@PathVariable("id") Integer id){
        return "consul"+id;
    }
}
