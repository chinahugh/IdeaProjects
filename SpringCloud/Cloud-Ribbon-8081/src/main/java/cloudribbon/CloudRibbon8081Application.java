package cloudribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author HUGH
 * @Date 2018/11/11
 * @Description CloudRibbon8081Application
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudRibbon8081Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudRibbon8081Application.class, args);
    }

    /**
     * @deprecated restTemplate;并通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
