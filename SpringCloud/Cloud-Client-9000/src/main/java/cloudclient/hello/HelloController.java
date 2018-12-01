package cloudclient.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HUGH
 * @Date 2018/11/11
 * @Description HelloController
 */
@RestController
@RequestMapping("b")
public class HelloController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name + ", port is " + port;
    }
}
