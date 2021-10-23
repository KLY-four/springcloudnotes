package com.springcloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Controller
@ResponseBody
public class SentienlController {

    @RequestMapping("/test")
    /**
     * @SentinelResource注解类似与hystrix中的@HystrixCommend注解。但是该注解只能(且必须)在热点key配置中使用(目前自测
     *  该注解在熔断上是不生效的)
     *
     *  该注解属性value为资源吗，需要和请求路径一致，blockHandler属性用于配置兜底方法。
     *  该注解的使用后续专门进行讲解。
     *
     *  热点key的统计窗口时常配置是指，发生熔断的时间，在n秒后熔断关闭(并非我们所想的统计时间，因为热点key是qps
     *  模式，都是指一秒内)
     *
     * */
    @SentinelResource(value="/test",blockHandler = "de1")
    public String de(@RequestParam("id") Integer id) throws InterruptedException {
        //TimeUnit.SECONDS.sleep(2);
       // int a =2/0;
        return "test sentienl";
    }

    public String de1(Integer id,BlockException exception){
        return "兜底";
    }
}
