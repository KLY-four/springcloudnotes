package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.service.HystrixService88;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
//@DefaultProperties(defaultFallback = "")
public class Controller88 {

    @Autowired
    private HystrixService88 hystrixService88;

    @RequestMapping("/consumer/ok/{id}")
    public String ok(@PathVariable("id") Integer id){
        return hystrixService88.ok(id);
    }

    @RequestMapping("/consumer/timeOut/{id}")
   /* @HystrixCommand(fallbackMethod = "timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "30000")
    })*/
    public String timeOut(@PathVariable("id") Integer id){
        return hystrixService88.timeOut(id);
    }

    /**
     * 这里是对客户端进行的服务降级配置，注意：这里的超时时间是指timeout方法的执行时间，该方法内部
     * 就包含了远程服务调用的时间(因为这里的网络调用就是hystrixService88代理对象来完成的)
     * 换句话说就是该方法执行开始到获取返回结果的时间差
     * 服务降级是接口(也就是方法)级别的，方法上如果没配置那么也就没有服务降级这一说法。该异常也就异常了。
     *
     * */

    public String timeOutHandler(Integer id){ //兜底方法，服务接口抛异常或超时了都会走到这里
        return "访问超时1";
    }

    /**  存在的问题：
     *  一、配置繁琐问题：(每个方法都要配置一个兜底方法会很麻烦)
     *  解决：
     * 全局的服务降级配置，上面我们是直接在方法上面指定了fallbackmetnod(兜底方法)，这种的话可能会导致
     * 每一个需要服务降级的方法都要写一个兜底方法，所以我们可以设置一个全局的服务降级方法。
     * 使用：
     *   在类上加上@DefaultProperties(defaultFallback = "兜底方法名称")
     *   然后在需要进行服务降级的方法上加上@HystrixCommand注解(里面不需要定义fallbackmetnod属性了，但可以配置超时属性)
     *   这样，该类下的服务降级方法都共用同一个兜底方法。当然，如果我们在HystrixCommand注解中配置了fallbackmetnod属性
     *   那么则会抛弃全局兜底方法的使用
     *
     *   二、兜底方法和业务方法的解耦(看下面)
     * */

    /**
     * 服务降级处理最常见的就是三种、方法执行异常、超时、或服务宕机(当然还有服务熔断引起的服务降级)。以上我们配置的@HystrixCommand在面对这三种情况时
     * 都可以处理(也就是走到兜底方法去)
     * 但除了这种方法外，还有一种方法可以专门用来解决。并且同时可以做到兜底方法和业务方法的解耦。
     * 那就是通过feign支持hystrix，这个在yaml中需要配置。
     * 他是如何处理的呢？
     * 使用：
     *   在service接口上的@FeignClient注解里加入一个属性 fallback=xx.class
     *   我们定义一个xx类实现service接口。然后里面的方法返回兜底信息(每个方法就是对应方法的兜底方法)
     * 这样无论是超时(这个目前还没看到在哪可以配置，估计默认超时时间是一秒)、异常、宕机都可以进行服务降级。
     * */

    /**
     * 什么是服务降级、服务降级就是让原本会返回异常信息的接口返沪指定的信息，让消费端更美观
     * 其次也不至于由于异常导致上游服务也挂掉。
     * 服务降级可以在任何方法上进行处理。
     * 服务降级的两种方式：
     *   一、注解
     *   二、feign支持
     * */
}
