package com.demo.test.controller;

import com.demo.test.model.User;
import com.demo.test.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Auther HUGH
 * @Date 2018/4/9
 * @Description UserController
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final String PATH="demo/test/";
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model){
        System.out.println("********************************************************");
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return PATH+"Test";
    }
}