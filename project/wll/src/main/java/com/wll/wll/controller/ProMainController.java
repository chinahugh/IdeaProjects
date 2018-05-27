package com.wll.wll.controller;


import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.wll.wll.controller.basecontroller.BaseController;
import com.wll.wll.controller.basecontroller.ViewPath;
import com.wll.wll.entity.ProMain;
import com.wll.wll.service.ProMainService;
import com.wll.wll.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/5/16
 * @Description ProMainController
 */
@Controller()
@RequestMapping("/main")
public class ProMainController extends BaseController{
    @Autowired
    private ProMainService proMainService;


    @ModelAttribute
    public ProMain get(String id) {
        ProMain proMain;
        if (StringUtils.isNotEmpty(id)) {
             proMain = proMainService.selectByPrimaryKey(id);
        }else {
            proMain=new ProMain();
        }
        return proMain;
    }

    @RequestMapping("list")
    public String list(ProMain proMain, Model model){
        List<ProMain> list= proMainService.list(proMain);
        model.addAttribute("list",list);
        return MAIN_PATH+"list";
    }

}
