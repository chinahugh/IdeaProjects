package cloudzuul8085;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.util.Arrays;

/**
 * @author HUGH
 * @Date 2018/11/17 11:40
 * @Description CloudZuul8085Application
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudZuul8085Application {
    static Logger logger = LoggerFactory.getLogger(CloudZuul8085Application.class);

    public static void main(String[] args) {
        logger.info(Arrays.toString(args));
        SpringApplication.run(CloudZuul8085Application.class, args);
    }
}
