package springboot.template.global.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Auther HUGH
 * @Date 2018/6/16
 * @Description InterceptorConfig
 */
public class InterceptorConfig extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(InterceptorConfig.class);

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
        logger.info("进入preHandle拦截 #########################################");
        logger.info("请求方式 ==> " + request.getMethod());
        logger.info("请求地址 ==> " + request.getRequestURL());
        StringBuffer sb = new StringBuffer();
        String bu;
        if (!request.getParameterMap().isEmpty()) {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                bu = parameterNames.nextElement();
                String parms = Arrays.toString(parameterMap.get(bu));
                sb.append(bu + " = " + parms + " , ");
            }
            logger.info("请求参数 ==> " + sb.toString());
        }
        logger.info("退出preHandle拦截 #########################################");
        return true;
    }

}
