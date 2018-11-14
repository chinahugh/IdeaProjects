package cloudserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author HUGH
 * @Date 2018/11/10
 * @Description CloudServer8080Application
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudServer8080Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudServer8080Application.class,args);
    }
}
