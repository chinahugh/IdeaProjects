package com.wll.sys.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Auther HUGH
 * @Date 2018/6/8
 * @Description WebConfigurer
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurationSupport {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebConfigurer.class);
    /**
     * 首页设置
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}
