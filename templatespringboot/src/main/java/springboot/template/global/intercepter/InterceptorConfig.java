package springboot.template.global.intercepter;

import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther HUGH
 * @Date 2018/6/16
 * @Description InterceptorConfig
 */
public class InterceptorConfig implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

    /**
     * 进入controller层之前拦截请求
     *
     * @param request
     * @param request
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("\n---------------------开始进入请求地址拦截----------------------------");
        System.out.println("请求方式 ==> " + request.getMethod());
        System.out.println("请求地址 ==> " + request.getRequestURL());
        System.out.println("请求参数 ==> " + JSONArray.fromObject(request.getParameterMap()==null?"":request.getParameterMap()));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("\n-----------------处理请求完成后视图渲染之前的处理操作------------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        System.out.println("\n------------------------视图渲染之后的操作---------------------------");
    }
}
