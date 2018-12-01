package cloudhystrix.hello;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author HUGH
 * @Date 2018/11/11 12:51
 * @Description HelloService
 */
@Service
public class HelloService {
    @Resource
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String helloa(String name) {
        return restTemplate.getForObject("http://Cloud-Client/a/hello/" + name, String.class);
    }
    @HystrixCommand(fallbackMethod = "error")
    public String hellob(String name) {
        return restTemplate.getForObject("http://Cloud-Client/b/hello/" + name, String.class);
    }
    public String error(String name){
        return name+" error !!!";
    }
}
