package com.demo.jsp;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * jsp for循环
 */
@WebService(name = "/foreach")
public class Foreach extends HttpServlet {
	
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf8");
        Object[] obs = new Object[10];

        HttpSession session = req.getSession();
        session.setAttribute("list", obs);
    }
}
