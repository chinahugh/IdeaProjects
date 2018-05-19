package com.demo.controller;

import com.demo.model.User;
import com.demo.service.UserServiceImpl;
import com.demo.service.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

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
    private final String PATH="demo/";
    @Resource
    private UserServiceImpl userService;

    @ModelAttribute
    public void start(String id){
        ModelAndView view = new ModelAndView();
        User user ;
        if (id!=null&&id!=""){
             user = userService.getUserById(Integer.parseInt(id));
        }else {
            user=new User();
            user.setId(2);
        }
    }
    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model){

        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println("********************************************************"+userId);
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return PATH+"test";
    }
}