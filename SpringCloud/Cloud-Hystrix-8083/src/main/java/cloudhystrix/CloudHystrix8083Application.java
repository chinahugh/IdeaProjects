package cloudhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author HUGH
 * @Date 2018/11/14 22:30
 * @Description CloudHystrix8083Application
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableHystrix
public class CloudHystrix8083Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudHystrix8083Application.class, args);
    }
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
