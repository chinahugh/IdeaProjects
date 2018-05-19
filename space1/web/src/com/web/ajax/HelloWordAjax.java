package com.web.ajax;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author: hugh
 * @Time: 2018/02/12 10:54 PM
 * @Discraption: ajax helloworld 测试
 * @PATH jsp/ajax/hellowordajax.html
 */
public class HelloWordAjax extends HttpServlet {
    String path = "jsp/ajax/hellowordajax.html";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contentType = req.getContentType();
        System.out.println(contentType);
        String keyword = req.getParameter("keyword");
        //  response.setContentType("text/html; charset=utf-8"); html
        resp.setContentType("text/plain; charset=utf-8"); //文本
        //  text/javascript json数据
        // application/xml  xml数据
        if (keyword == null || "" == null) {
            System.out.println("null");
            req.setAttribute("msg", "为空");
        } else {
            if (!Objects.equals(keyword, "20")) {
                System.out.println("20");
                req.setAttribute("msg", "no");
            } else {
                System.out.println(keyword);
                req.setAttribute("msg", "yes");
            }
        }
    }
}
