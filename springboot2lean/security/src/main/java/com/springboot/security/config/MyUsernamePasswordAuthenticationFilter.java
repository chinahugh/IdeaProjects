package com.springboot.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户登陆逻辑过滤器
 */
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private RedisService redisService;
//    private boolean postOnly = true;
//
//    public MyUsernamePasswordAuthenticationFilte(RedisService redisService){
//        this.redisService=redisService;
//    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        //你可以在这里做验证码校验，校验不通过抛出AuthenticationException()即可
        return super.attemptAuthentication(request,response);
    }
}
