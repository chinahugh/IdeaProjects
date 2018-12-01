package cloudhystrixfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author HUGH
 * @Date 2018/11/17 10:54
 * @Description CloudHystrixFeign8084Application
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
public class CloudHystrixFeign8084Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixFeign8084Application.class,args);
    }
}
