package com.demo.web.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: hugh
 * @Time: 2017/12/10 10:15 PM
 * @Discraption:
 */
@RequestMapping("/myrequest")
@Controller
public class MyRequest {
    @Resource
    private HttpServletRequest request;

    @RequestMapping("/requestmethod")
    public String requestmethod() {
        String pathInfo = request.getPathInfo();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String pathTranslated = request.getPathTranslated();
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String path = request.getSession().getServletContext().getContextPath();

        System.out.println("path "+realPath);
        System.out.println("realPath "+realPath);
        System.out.println("pathinfo "+pathInfo);
        System.out.println("contextPath "+contextPath);
        System.out.println("servletPath "+servletPath);
        System.out.println("pathTranslated "+pathTranslated);
        System.out.println("llll"+contextPath+"lslsl");
        return "index";
    }
}
