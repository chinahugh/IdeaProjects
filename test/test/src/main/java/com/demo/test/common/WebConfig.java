package com.demo.test.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author HGH
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    private static final Log logger = LogFactory.getLog(WebConfig.class);

    /**
     * 视图控制器配置
     *
     * @param registry
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("../dist/index");//默认视图跳转

    }

    /**
     * 静态资源配置
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mapper/**").addResourceLocations("classpath:/mapper/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/dist/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/dist/js/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/dist/fonts/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/dist/img/");
    }
    /**
     * 拦截器配置
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**", "/templates/**","/error","/login");
    }



    /**
     * 跨域配置
     *
     * @param registry
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//配置允许跨域的路径
            //    .allowedOrigins("*")//配置允许访问的跨域资源的请求域名
                .allowedMethods("PUT","POST","GET","DELETE","OPTIONS")//配置允许访问该跨域资源服务器的请求方法，如：POST、GET、PUT、DELETE等
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600) ; //配置允许请求header的访问，如 ：X-TOKEN
//        super.addCorsMappings(registry);
    }


//    @Override
//    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
////        converter.setSupportedMediaTypes(getSupportedMediaTypes());
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
////        WriteNullListAsEmpty  ：List字段如果为null, 输出为[],而非null
////        WriteNullStringAsEmpty ：字符类型字段如果为null, 输出为 "", 而非null
////        DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
////        WriteNullBooleanAsFalse：Boolean字段如果为null, 输出为false, 而非null
////        WriteMapNullValue：是否输出值为null的字段, 默认为false
//        fastJsonConfig.setSerializerFeatures(
//                // String null -> ""
//                SerializerFeature.WriteNullStringAsEmpty,
//                // Number null -> 0
//                SerializerFeature.WriteNullNumberAsZero,
//                //Boolean null ->false
//                SerializerFeature.WriteNullBooleanAsFalse,
//                //禁止循环引用
//                SerializerFeature.DisableCircularReferenceDetect,
//                //List字段如果为null, 输出为[],而非null
//                SerializerFeature.WriteNullListAsEmpty,
//                //map null ->{}
//                SerializerFeature.WriteMapNullValue,
//                SerializerFeature.WriteDateUseDateFormat
//        );
//        converter.setFastJsonConfig(fastJsonConfig);
//        converter.setDefaultCharset(Charset.forName("UTF-8"));
//
//        converters.add(converter);
//
//    }

    //
    /**
     * 添加自定义异常处理
     *
     * @param exceptionResolvers
     */
//    @Override
//    protected void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
//        //创建异常处理
//        exceptionResolvers.add(getHandlerExceptionResolver());
//    }
//
//    private HandlerExceptionResolver getHandlerExceptionResolver() {
//        return new HandlerExceptionResolver() {
//            @Nullable
//            @Override
//            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, @Nullable Object handler, Exception ex) {
//                ModelAndView modelAndView = new ModelAndView();
//                modelAndView.setViewName("error");
//                //    LOGGER.error(ex.getMessage(), ex);
//                //根据异常类型确定返回数据
//                R result = getResuleByHeandleException(request, handler, ex);
//                //响应结果
////                  responseResult(response, result);
//                return modelAndView;
//            }
//        };
//    }
//
//    private R getResuleByHeandleException(HttpServletRequest request, Object handler, Exception e) {
//        String msg;
//        if (e instanceof E) {
//            msg = e.getMessage();
//            logger.error(msg, e);
//            return R.error(msg);
//        }
//        if (e instanceof NoHandlerFoundException) {
//            msg = "接口 [" + request.getRequestURI() + "] 不存在";
//            logger.error(msg, e);
//            return R.error(msg);
//        }
////        if (e instanceof PageNotFound) {
////            msg = "接口 [" + request.getRequestURI() + "] 不存在";
////            LOGGER.error(msg, e);
////            return R.error(msg);
////        }
//        if (e instanceof HttpRequestMethodNotSupportedException) {
//            msg = "接口 [" + request.getRequestURI() + "] 不能使用GET访问";
//            logger.error(msg, e);
//            return R.error(msg);
//        }
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            msg = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s", request.getRequestURI(),
//                    handlerMethod.getBean().getClass().getName(), handlerMethod.getMethod().getName(), e.getMessage());
//            logger.error(msg, e);
//            return R.error(msg);
//        }
//        msg = "接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员" + e.getMessage();
//        logger.error(msg, e);
//        return R.error(msg);
//    }

}
