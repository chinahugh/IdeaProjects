package com.mvc.global.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mvc.global.common.E;
import com.mvc.global.common.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HUGH
 * @Date 2019/7/28 10:02
 * @Description WebConfig
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    private Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

    @Override
    public HandlerExceptionResolver handlerExceptionResolver() {
        return new HandlerExceptionResolver() {
            @Override
            public ModelAndView resolveException(HttpServletRequest request,
                                                 HttpServletResponse response,
                                                 Object handler,
                                                 Exception ex) {
                response.setStatus(200);
                response.setCharacterEncoding("UTF-8");
                response.setHeader("Content-type", "application/json;charset=UTF-8");
                try {
                    R result = getResuleByHeandleException(request, handler, ex);
                    response.getWriter().write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
                } catch (IOException e) {
                    logger.error(ex.getMessage(), ex);
                }
                return new ModelAndView();
            }
        };
    }

    private R getResuleByHeandleException(HttpServletRequest request, Object handler, Exception e) {
        String msg;
        if (e instanceof E) {
            msg = e.getMessage();
        } else if (e instanceof NoHandlerFoundException) {
            msg = "接口 [" + request.getRequestURI() + "] 不存在";
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            msg = "接口 [" + request.getRequestURI() + "] 不能使用GET访问";
        } else if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            msg = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                    request.getRequestURI(),
                    handlerMethod.getBean().getClass().getName(),
                    handlerMethod.getMethod().getName(),
                    e.getMessage());
        } else {
            msg = "接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员" + e.getMessage();
        }
        logger.error(msg, e);
        return R.error(msg);
    }
}
