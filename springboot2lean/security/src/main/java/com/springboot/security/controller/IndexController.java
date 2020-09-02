package com.springboot.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HGH
 */
@Controller
public class IndexController {

// @PreAuthorize("hasRole('admin')")
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }
//    @PreAuthorize("hasRole('base')")
    @RequestMapping("/base")
    public String base() {
        System.out.println("base");
        return "base";
    }
    @RequestMapping("/index")
    public String index() {
        System.out.println("index");
        return "index";
    }
    @RequestMapping("/index2")
    public String login() {
        System.out.println("index2");
        return "index2";
    }
    @RequestMapping("/logg")
    @ResponseBody
    public String logg() {
        System.out.println("logg");
        return "logg";
    }
}
