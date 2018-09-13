package springboot.template.global.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springboot.template.global.exception.ServiceException;
import springboot.template.global.intercepter.InterceptorConfig;
import springboot.template.global.result.R;
import springboot.template.global.result.RC;
import springboot.template.global.result.RR;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description WebConfig
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    private final static Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

    /**
     * 首页设置
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    /**
     * 自定义消息装换器
     *
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
        converter.setSupportedMediaTypes(getSupportedMediaTypes());
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        WriteNullListAsEmpty  ：List字段如果为null, 输出为[],而非null
//        WriteNullStringAsEmpty ：字符类型字段如果为null, 输出为 "", 而非null
//        DisableCircularReferenceDetect ：消除对同一对象循环引用的问题，默认为false（如果不配置有可能会进入死循环）
//        WriteNullBooleanAsFalse：Boolean字段如果为null, 输出为false, 而非null
//        WriteMapNullValue：是否输出值为null的字段, 默认为false
        fastJsonConfig.setSerializerFeatures(
                // String null -> ""
                SerializerFeature.WriteNullStringAsEmpty,
                // Number null -> 0
                SerializerFeature.WriteNullNumberAsZero,
                //Boolean null ->false
                SerializerFeature.WriteNullBooleanAsFalse,
                //禁止循环引用
                SerializerFeature.DisableCircularReferenceDetect,
                //List字段如果为null, 输出为[],而非null
                SerializerFeature.WriteNullListAsEmpty,
                //map null ->{}
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat
        );
        converter.setFastJsonConfig(fastJsonConfig);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }

    /**
     * 添加自定义异常处理
     *
     * @param exceptionResolvers
     */
    @Override
    protected void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        //创建异常处理
        exceptionResolvers.add(getHandlerExceptionResolver());
    }

    private HandlerExceptionResolver getHandlerExceptionResolver() {
        return new HandlerExceptionResolver() {
            @Nullable
            @Override
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, @Nullable Object handler, Exception ex) {
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("/templates/error-404.html");

//                LOGGER.error(ex.getMessage(),ex);
                //根据异常类型确定返回数据
                R result = getResuleByHeandleException(request, handler, ex);
                //响应结果
                responseResult(response, result);
                return modelAndView;
            }
        };
    }


    /**
     * swagger-ui设置，因为继承WebMvcConfigurationSupport之后，静态文件映射会出现问题，需要重新指定静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/favicon.ico")
                .addResourceLocations("classpath:/static/favicon.ico");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }

    private R getResuleByHeandleException(HttpServletRequest request, Object handler, Exception e) {
        if (e instanceof ServiceException) {
            LOGGER.error("ServiceException", e);
            return RR.error(e.getMessage());
        }
        if (e instanceof NoHandlerFoundException) {
            LOGGER.error("NoHandlerFoundException", e);
            return RR.error("接口 [" + request.getRequestURI() + "] 不存在");
        }
        if (e instanceof HttpRequestMethodNotSupportedException) {
            LOGGER.error("HttpRequestMethodNotSupportedException", e);
            return RR.error(RC.INTERNAL_SERVER_ERROR, "接口 [" + request.getRequestURI() + "] 不能使用GET访问");
        }
        if (handler instanceof HandlerMethod) {
            LOGGER.error("HandlerMethod", e);
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            String msg = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s", request.getRequestURI(),
                    handlerMethod.getBean().getClass().getName(), handlerMethod.getMethod().getName(), e.getMessage());
            return RR.error(RC.INTERNAL_SERVER_ERROR, msg);
        }
        LOGGER.error(e.getMessage(), e);
        String msg = "接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员" + e.getMessage();
        return RR.error(RC.INTERNAL_SERVER_ERROR, msg);
    }

    private void responseResult(HttpServletResponse response, R result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }

    private List<MediaType> getSupportedMediaTypes() {
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        return supportedMediaTypes;
    }

    public InterceptorConfig interceptorConfig() {
        return new InterceptorConfig();
    }

    /**
     * Override this method to add Spring MVC interceptors for
     * pre- and post-processing of controller invocation.
     *
     * @param registry
     * @see InterceptorRegistry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorConfig());
    }
}
