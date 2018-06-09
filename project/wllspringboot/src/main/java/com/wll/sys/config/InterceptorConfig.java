package com.wll.sys.config;

import com.wll.pro.interceptor.LogHandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Auther HUGH
 * @Date 2018/5/30
 * @Description InterceptorConfig
 *  WebMvcConfigurerAdapter过期，继承新类WebMvcConfigurationSupport，它是Adapter的扩展
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    /**
     * 拦截器
     * @param registry
     */
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
