package com.wll.pro.controller;

import com.alibaba.druid.util.StringUtils;
import com.wll.pro.entity.User;
import com.wll.pro.entity.XmMain;
import com.wll.pro.service.HelloService;
import com.wll.pro.service.XmMainService;

import net.sf.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/5/31
 * @Description XmMainController
 */
/*@Controller
@RequestMapping("/xmmain/")*/
public class XmMainController {
    @Resource
    private XmMainService xmMainService;
    @Resource
    private HelloService userService;

    //  @ModelAttribute
    public XmMain get(String id) {
        XmMain xmMain = null;
        if (!StringUtils.isEmpty(id)) {
            xmMain = new XmMain();
        }
        if (xmMain == null && "".equals(xmMain)) {
            xmMain = new XmMain();
        }
        return xmMain;
    }

  //  @RequestMapping("list")
    public String list(XmMain xmMain, Model model) {
        System.out.println("xmMain = " + JSONObject.fromObject(xmMain));
     /*   List<XmMain> list= xmMainService.list(xmMain);
        model.addAttribute("list",list);*/
        model.addAttribute("xmMain", new XmMain());
        return "list";
    }

    @RequestMapping("listuser")
    public String listuser(@ModelAttribute(value = "xmMain")User xmMain, Model model) {
        List<User> list = userService.list(xmMain);
        model.addAttribute("list", list);
        return "index";
    }
}
