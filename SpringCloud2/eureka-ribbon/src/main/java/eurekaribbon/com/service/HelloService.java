package eurekaribbon.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther HUGH
 * @Date 2018/9/25
 * @Description HelloService
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    public String hello(String name){
        return restTemplate.getForObject("http://EUREKACLIENT/helloworld/"+name,String.class);
    }
}
