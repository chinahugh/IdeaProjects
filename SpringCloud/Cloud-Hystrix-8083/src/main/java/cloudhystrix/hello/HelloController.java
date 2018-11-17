package cloudhystrix.hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author HUGH
 * @Date 2018/11/11 12:45
 * @Description HelloController
 */
@RestController
public class HelloController {
    @Resource
    private HelloService helloService;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return helloService.hello(name);
    }
}
