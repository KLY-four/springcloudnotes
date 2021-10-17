package springcloudalibab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringNacos6002 {
    public static void main(String[] args) {
        SpringApplication.run(SpringNacos6002.class,args);
    }
}
