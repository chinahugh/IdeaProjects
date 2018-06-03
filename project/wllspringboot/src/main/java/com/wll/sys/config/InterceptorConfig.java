package com.wll.sys.config;

import com.wll.pro.interceptor.LogHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Auther HUGH
 * @Date 2018/5/30
 * @Description InterceptorConfig
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 用于添加拦截规则
        //excludePathPatterns 用于排除拦截
        registry.addInterceptor(new LogHandlerInterceptor()).addPathPatterns("/**");
              /*  .excludePathPatterns("/hlladmin/login") //登录页
                .excludePathPatterns("/hlladmin/user/sendEmail") //发送邮箱
                .excludePathPatterns("/hlladmin/user/register") //用户注册
                .excludePathPatterns("/hlladmin/user/login"); //用户登录*/
        super.addInterceptors(registry);
    }
}
