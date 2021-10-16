package consumer.controller;

import consumer.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@ResponseBody
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    private String consulUrl = "http://cloud-consul-provider8006";

    @Autowired
    private MappingService mappingService;

    @RequestMapping("/openfeign/select")
    public String select(){
        return mappingService.select(2);
    }
}
