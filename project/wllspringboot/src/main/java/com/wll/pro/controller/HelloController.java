package com.wll.pro.controller;

import com.alibaba.druid.util.StringUtils;
import com.wll.pro.entity.User;
import com.wll.pro.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/5/29
 * @Description HelloController
 */
@Controller
@RequestMapping("/")
public class HelloController {
    @Resource
    private HelloService helloService;
    @ModelAttribute
    public User get(String id){
        User user;
        if (StringUtils.isEmpty(id)) {
            user=new User();
        }else {
            user=helloService.get(id);
        }
        return user;
    }
    @RequestMapping("hello/{name}")
    @ResponseBody
    public User hello(@PathVariable("name") String name, User user, Model model){
        System.out.println("name = " + name);
        return user;
    }
    @RequestMapping("listhello/{namee}/{passwordd}")
    public String list(@PathVariable(value = "namee") String namee,
                           @PathVariable(value = "passwordd")  String passwordd ,
                           User user,Model model){
        model.addAttribute("title","list");
        System.out.println("name = " + namee);
        user.setName(namee);
        user.setPassword(passwordd);
        model.addAttribute("list", helloService.list(user));
        model.addAttribute("today",new Date());
        return "index";
    }
}
