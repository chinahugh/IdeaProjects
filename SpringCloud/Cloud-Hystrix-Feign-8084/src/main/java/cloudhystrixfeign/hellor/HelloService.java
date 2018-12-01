package cloudhystrixfeign.hellor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author HUGH
 * @Date 2018/11/11 13:45
 * @Description HelloService  FeignClient中的value确定调用服务
 *
 * /*,fallback = HelloServiceImpl.class*
 */
@FeignClient(value = "Cloud-Client")
public interface HelloService {
    /**
     * 确定调用服务的方法
     * @param name
     * @return
     */
    @RequestMapping("/a/hello/{name}")
    String helloa(@PathVariable(value = "name") String name);
    /**
     * 确定调用服务的方法
     * @param name
     * @return
     */
    @RequestMapping("/b/hello/{name}")
    String hellob(@PathVariable(value = "name") String name);
}
