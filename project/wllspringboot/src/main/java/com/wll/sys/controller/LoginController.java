package com.wll.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther HUGH
 * @Date 2018/6/3
 * @Description LoginController
 */
@Controller
@RequestMapping("/login/")
public class LoginController {
    @RequestMapping("login")
    public String login(Model model){
    return "login";
    }
}
