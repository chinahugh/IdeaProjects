package cloudribbon.hello;

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

    public String hello(String name) {
        return restTemplate.getForObject("http://Cloud-Client/hello/" + name, String.class);
    }
}
