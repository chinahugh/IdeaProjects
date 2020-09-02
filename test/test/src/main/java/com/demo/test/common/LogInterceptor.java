package com.demo.test.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author HGH
 */
public class LogInterceptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    /**
     * 日志对象
     */
//    protected static final Logger LOGGER = LoggerFactory.getLogger(LogInterceptor.class);
    private static final Log LOGGER = LogFactory.getLog(LogInterceptor.class);
    /**
     * 预处理回调方法，实现处理器的预处理（如检查登陆），第三个参数为响应的处理器，自定义Controller
     * 返回值：true表示继续流程（如调用下一个拦截器或处理器）；false表示流程中断（如登录检查失败）
     * ，不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("preHandle-------------------------------------------");
        LOGGER.info("getMethod"+request.getMethod());
        LOGGER.info("getRequestURI"+request.getRequestURI());
        HttpSession session = request.getSession();
        if (session.isNew()){
            LOGGER.info("preHandle--------------------2222-----------------------");
            LOGGER.info(session.getId());
        }
        LOGGER.info(session.getId());


        String token = request.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method=handlerMethod.getMethod();
        //检查方法名是否是“login”如果是则跳过，也可以加注解，用注解过滤不需要权限的方法
        if ("login".equals(method.getName())) {
            return true;
        }
        // 执行认证
//        if (token == null) {
//            throw new RuntimeException("无token，请重新登录");
//        }
//        // 获取 token 中的 name
//        String name;
//        try {
//            name = JWT.decode(token).getAudience().get(0);
//            System.out.println(name);
//        } catch (JWTDecodeException j) {
//            throw new RuntimeException("401");
//        }catch (Exception j) {
//logger.error(j.getMessage(),j);
////            throw new RuntimeException("401");
//        }
//        // 验证 token
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("111")).build();
//        try {
//            DecodedJWT verify = jwtVerifier.verify(token);
//            System.out.println(ObjectUtil.toString(verify));
//        } catch (JWTVerificationException e) {
//            throw new RuntimeException("401");
//        }catch (Exception e) {
//            throw new RuntimeException("401");
//        }
        return true;
    }

    /**
     * 后处理回调方法，实现处理器的后处理（但在渲染视图之前），此时我们可以通过modelAndView（模型和视图对象）
     * 对模型数据进行处理或对视图进行处理，modelAndView也可能为null。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        // 指定允许其他域名访问
//        response.setHeader("Access-Control-Allow-Origin", "*"); // 允许所有
//        // response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1, http://locahost"); // 允许白名单IP
//        // 响应类型
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        // 预检请求的结果缓存60分钟
//        response.setHeader("Access-Control-Max-Age", "3600");
//        // 响应头设置
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        LOGGER.info("postHandle-------------------------------------------");
    }
    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，如性能监控中我们可以在此记录结束时间并输出消耗时间，
     * 还可以进行一些资源清理，类似于try-catch-finally中的finally，但仅调用处理器执行链中
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        LOGGER.info("afterCompletion-------------------------------------------");
    }
}
