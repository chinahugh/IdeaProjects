package template.com.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author HUGH
 * @Date 2019/4/21 17:21
 * @Description ReqctController
 */
@RestController
@RequestMapping(value = "/hello/",method = RequestMethod.GET)
public class HelloController {
    @RequestMapping("ajax")
    public String ajax(HttpServletResponse response){
       // response.addHeader("Access-Control-Allow-Origin", "*");
        return "hello";
    }
}
