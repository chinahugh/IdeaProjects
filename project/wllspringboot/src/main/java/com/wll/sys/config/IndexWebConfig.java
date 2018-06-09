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
 * @Description IndexWebConfig
 */
@Configuration
public class IndexWebConfig extends WebMvcConfigurationSupport {
    private final static Logger LOGGER = LoggerFactory.getLogger(IndexWebConfig.class);

}
