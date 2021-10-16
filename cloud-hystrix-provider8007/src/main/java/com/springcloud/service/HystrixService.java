package com.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixService {

    public String ok(Integer id){
        return "访问"+Thread.currentThread().getName()+"成功   id: "+id;
    }

   /* @HystrixCommand(fallbackMethod = "timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })*/
    public String timeOut(Integer id) throws InterruptedException {
        //int a =1/0;
       TimeUnit.MICROSECONDS.sleep(900);
        return "访问"+Thread.currentThread().getName()+"超时   id: "+id;
    }

    public String timeOutHandler(Integer id){ //兜底方法，服务接口抛异常或超时了都会走到这里
        return "访问超时2";
    }

    //-------------------------------------------------------------------------------------
    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到%多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+id;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }

    /**
     *  hystrix既可以对消费端做服务降低也可以对服务端做消费降级，配置是一样的。但是一般只对客户端做配置即可
    * */

    /**
     * 这里我们直接在服务端讲解熔断(直接调服务端，不从消费端调了)
     * 服务熔断夹着服务降级，当请求来时，如果该方法执行出现异常，那么将触发服务降级，返回兜底方法结果。
     * 当达到一定配置时，也就是多少时间内多少次请求的失败率达到指定数字。那么该接口就会被熔断。(这里的失败是指触发服务降级)
     * 此时只要是访问该方法的请求都会直接触发服务降级，而不会执行接口。
     * 服务熔断有三种状态、可用、半开闭、关闭
     * 在最初时接口是可用状态，当触发熔断后，该接口处于关闭状态，也就是熔断了，由于hystrix自带了服务监控，
     * 所以他不会一直让该服务处于熔断状态，而是过一段时间会尝试让一次请求去访问，如果成功将恢复该服务(也就是常说的恢复链路调用)，
     * 否则继续让其熔断。
     *
     * 所以服务熔断是伴随着服务降级的，而不是单独存在。
     * */
}
