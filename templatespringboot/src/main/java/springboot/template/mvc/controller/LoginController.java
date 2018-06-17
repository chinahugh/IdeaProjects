package springboot.template.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.service.service.UserInfoService;

import javax.annotation.Resource;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description LoginController 用户登录
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.POST)
public class LoginController extends BaseController {
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login")
    public String login(UserInfo userInfo, Model model, RedirectAttributes redirectAttributes) {
        boolean login = userInfoService.login(userInfo);
        if (login) {
            return "main";
        } else {
            model.addAttribute("msg", "用户用或密码不正确");
            return "login";
        }
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        return "login";
    }
}
