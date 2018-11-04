package eurekafeign.hello;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther HUGH
 * @Date 2018/9/26
 * @Description HelloService
 */
@FeignClient(value = "eurekaclient")
public interface HelloService {
    @RequestMapping("/helloworld/{name}")
    String hello(@PathVariable("name") String name);
}
