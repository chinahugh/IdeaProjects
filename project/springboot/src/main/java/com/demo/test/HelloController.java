package com.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Auther HUGH
 * @Date 2018/5/27
 * @Description HelloController
 */
@Controller
@RequestMapping("/helloo")
public class HelloController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hellosdfjhkaskl";
    }

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/add")
    public int addUser(UserDomain user) {
        return userService.addUser(user);
    }

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize) {
        return userService.findAllUser(pageNum, pageSize);
    }
}

