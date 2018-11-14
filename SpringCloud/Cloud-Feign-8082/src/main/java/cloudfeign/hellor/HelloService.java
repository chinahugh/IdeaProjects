package cloudfeign.hellor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HUGH
 * @Date 2018/11/11 13:45
 * @Description HelloService  FeignClient中的value确定调用服务
 */
@FeignClient(value = "Cloud-Client")
//@Service
public interface HelloService {
    /**
     * 确定调用服务的方法
     * @param name
     * @return
     */
    @RequestMapping("/hello/{name}")
    String hello(@PathVariable(value = "name") String name);
}
