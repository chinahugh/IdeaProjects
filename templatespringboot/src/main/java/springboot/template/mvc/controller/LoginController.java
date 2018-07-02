package springboot.template.mvc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description LoginController 用户登录
 */
@Controller
@RequestMapping(value = "/",method = RequestMethod.POST)
public class LoginController extends BaseController {

    @RequestMapping(value = "loginn", method = RequestMethod.GET)
    public String login() {
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUserName(), userInfo.getUserPassword());
//       try {
//           subject.login(token);
//       }catch (Exception e){
//           e.fillInStackTrace();
//        }
        System.out.println("****************************************");
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "userPassword",required = true)String userPassword) {
        System.out.println("getUserPassword "+userName+" getUserName "+userPassword);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword);
        try {
            subject.login(token);
        }catch (Exception e){
           return "no "+e.getMessage();
        }
        return SecurityUtils.getSubject().getPrincipal();
    }


    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        return "login";
    }
}
