package cloudhystrixfeign.hellor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author HUGH
 * @Date 2018/11/11 13:44
 * @Description HelloController
 */
@RestController
public class HelloController {
    private Logger logger= LoggerFactory.getLogger(HelloService.class);
    @Resource
    private HelloService helloService;

    @RequestMapping("/a/hello/{name}")
    public String helloa(@PathVariable(value = "name") String name) {
        logger.info("HelloController | hello(..) | {}",name);
        return helloService.helloa(name);
    }
    @RequestMapping("/b/hello/{name}")
    public String hellob(@PathVariable(value = "name") String name) {
        logger.info("HelloController | hello(..) | {}",name);
        return helloService.hellob(name);
    }
}
