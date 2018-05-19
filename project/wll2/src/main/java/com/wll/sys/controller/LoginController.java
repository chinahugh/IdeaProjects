package com.wll.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @Auther HUGH
 * @Date 2018/5/10
 * @Description LoginController
 */
@Controller
public class LoginController {
    @ModelAttribute
    public void get(String id){
        System.out.println("id = " + id);
    }
}
