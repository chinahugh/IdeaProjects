package com.huguohui.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: hugh
 * @Date: 17-11-23:下午9:10
 * @Description:
 */
@Controller
@RequestMapping(value = "test")
public class LoginController {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(String name,String password){
        System.out.println("LoginController-login");
        System.out.println("name :"+name);
        System.out.println("password :"+password);
        return "login";
    }
}
