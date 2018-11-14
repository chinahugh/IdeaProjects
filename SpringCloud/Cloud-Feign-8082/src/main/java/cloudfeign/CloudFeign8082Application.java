package cloudfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author HUGH
 * @Date 2018/11/11 13:33
 * @Description CloudFeign8082Application
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class CloudFeign8082Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudFeign8082Application.class, args);
    }
}
