package consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@ResponseBody
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    private String consulUrl = "http://cloud-consul-provider8006";

    @RequestMapping("/consul/select")
    public String select(){
        String object = restTemplate.getForObject(consulUrl + "/select", String.class);
        return object;
    }
}
