package com.demo.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: hugh
 * @Date: 17-11-23:下午9:34
 * @Description:
 */
@Controller
@RequestMapping(value = "demo/test/redirect")
public class Redirect {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "Redirectindex";
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:final";
    }

    @RequestMapping(value = "/final", method = RequestMethod.GET)
    public String finalPage() {
        return "Redirectfinal";
    }
}
