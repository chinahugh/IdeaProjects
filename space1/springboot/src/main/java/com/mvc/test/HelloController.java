package com.mvc.test;

import com.mvc.global.common.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author HUGH
 * @Date 2019/4/21 17:21
 * @Description HelloController
 */
@RestController
@RequestMapping(value = "/hello/", method = RequestMethod.GET)
public class HelloController {
    @RequestMapping("ajax")
    public R ajax(HttpServletResponse response) {
        /* response.addHeader("Access-Control-Allow-Origin", "*"); */
        return R.ok();
    }
}
