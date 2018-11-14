package cloudclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author HUGH
 * @Date 2018/11/11
 * @Description CloudClient9000Application
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudClient9000Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudClient9000Application.class,args);
    }
}
