package consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(value = "cloud-consul-provider8006")
public interface MappingService {  //该接口会被openfeign进行动态代理

    @RequestMapping("/select/{id}")
    public String select(@PathVariable("id") Integer id);
}
