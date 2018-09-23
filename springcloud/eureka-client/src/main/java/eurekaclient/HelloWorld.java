package eurekaclient;

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
    @RequestMapping("helloworld")
    public String helloWorld() {
        return "Hello World";
    }
    @RequestMapping("helloworld/{name}")
    public String helloWorldName(@PathVariable("name")String name) {
        return "Hello World " +name;
    }
}
