package springcloudalibab.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class NacosProvider6002 {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/select")
    public String select(){
        return port+"对请求进行处理";
    }
}
