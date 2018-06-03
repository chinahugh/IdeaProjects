package com.wll.pro.controller;

import com.wll.pro.entity.Menu;
import com.wll.pro.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/3
 * @Description MenuController
 */
@Controller
@RequestMapping("/")
public class MenuController {
    @Resource
    private MenuService menuService;

    @RequestMapping("htindex")
    @ResponseBody
    public String index(Model model) {
        List<Menu> list = menuService.getMenuList(new Menu());
        model.addAttribute("list", list);
        return "ht.htindex";
    }
}
