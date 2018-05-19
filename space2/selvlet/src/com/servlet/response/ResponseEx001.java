package com.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @Author: hugh
 * @Time: 2018/01/05 9:13 PM
 * @Discraption: Response例子
 */
public class ResponseEx001 extends HttpServlet {
    private static final long serialVersionUID = -5557912649502664744L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String adress = req.getParameter("adress");
        if (Objects.isNull(name)) {
            resp.sendError(300,"name is null");
        }
        resp.sendRedirect("../../jsp/servlet.response/ResponseEx001.jsp");
    }
}
