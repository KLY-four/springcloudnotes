package consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients  //开启feign客户端的使用
public class SpringBootConsumer83 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootConsumer83.class,args);
    }
}
