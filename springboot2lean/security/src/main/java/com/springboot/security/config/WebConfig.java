package com.springboot.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
/**
 * @author HGH
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
       registry.addResourceHandler("/static/**/**").addResourceLocations("classpath:/static/");
    }
    /**
     * 视图控制器配置
     *
     * @param registry
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/index").setViewName("index");//默认视图跳转
    }
}
