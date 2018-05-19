package com.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: hugh
 * @Date: 17-11-25:上午9:24
 * @Description:
 */
@Controller
@RequestMapping("/demo/test/")
public class RequestController {

    @RequestMapping("login")
    public String login(String name,String password){
        System.out.println("name :"+name);
        System.out.println("password "+password);
        return "login";
    }
}
