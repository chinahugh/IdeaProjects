package com.photo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Auther HUGH
 * @Date 2018/3/19
 * @Description MyFilter
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        System.out.println(request.getParameterNames());
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
        filterChain.doFilter(request,(HttpServletResponse)servletResponse);
    }

    @Override
    public void destroy() {

    }
}
