package eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther HUGH
 * @Date 2018/9/23
 * @Description HelloWorld
 */
@Controller
@RequestMapping("/")
@ResponseBody
public class HelloWorld {
    @Value("${server.port}")
    private String port;

    @RequestMapping("helloworld")
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping("helloworld/{name}")
    public String helloWorldName(@PathVariable("name") String name) {
        return "Hello World " + name+" >>>> " +port;
    }
}
