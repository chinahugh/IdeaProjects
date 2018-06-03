package com.wll.pro.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author HUGH
 * @Date 2018/5/30
 * @Description LogHandlerInterceptor
 */
public class LogHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("请求URL ============> " + request.getRequestURI());
        System.out.println("请求参数 ============> ");

        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            System.out.println("     参数 ==> " + name+" : "+value);
        }
        System.out.println("session id =========> " + request.getSession().getId());
        System.out.println("request  AuthType ==> " + request.getAuthType());
        System.out.println("request  method ====> " + request.getMethod());
        System.out.println("request  query =====> " + request.getQueryString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("************** postHandle *******************");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("************** afterCompletion *******************");
        System.out.println("response ContentType =====> " + response.getContentType());
    }
}
