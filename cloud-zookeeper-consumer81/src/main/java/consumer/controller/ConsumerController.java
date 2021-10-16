package consumer.controller;

import com.common.api.entities.PaymentEntity;
import com.common.api.response.ResponseResult;
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

    private String zookeeperUrl = "http://cloud-zookeeper-provider8004";

    @RequestMapping("/zk/select")
    public String select(){
        String object = restTemplate.getForObject(zookeeperUrl + "/select", String.class);
        return object;
    }
}
