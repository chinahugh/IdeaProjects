package springboot.template.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther HUGH
 * @Date 2018/6/11
 * @Description MainController
 */
@Controller
@RequestMapping("/")
public class MainController {
    @RequestMapping("main")
    public String main(Model model){
        return "main";
    }
}
