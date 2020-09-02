package com.springboot.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HGH
 */
@Configuration
public class SecurityFilterBefore implements Filter {
    private Logger logger = LoggerFactory.getLogger(SecurityFilterBefore.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        logger.info(request.getMethod());
        logger.info(request.getRequestURL().toString());
        logger.info(request.getServletContext().getContextPath());
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
