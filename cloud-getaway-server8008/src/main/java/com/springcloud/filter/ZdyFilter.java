package com.springcloud.filter;

import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

//自定义网关过滤器
@Component
public class ZdyFilter implements GlobalFilter, Ordered { //实现该接口

    //该方法为业务处理方法
    /**
     *  这里写的简单逻辑就是，如果请求参数key具有值那么将exchange传给下一个过滤器进行处理(exchange中封装了请求的所以信息)，
     *  否则返回一个带有状态码的响应体。
     *  如果后面没有filter进行传递了，那么请求自然到达目标服务
     * */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String value = exchange.getRequest().getQueryParams().getFirst("key"); //获取对应的请求参数
        if(value==null){
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete(); //请求不进入目标资源。直接返回
        }else {
            return chain.filter(exchange); //请求到达后面过滤器或目标资源
        }
    }

    //该方法是过滤器优先级，当我们定义多个过滤器时，会根据该返回值的决定过滤器的执行顺序，值越大执行越早
    @Override
    public int getOrder() {
        return 0;
    }
}
