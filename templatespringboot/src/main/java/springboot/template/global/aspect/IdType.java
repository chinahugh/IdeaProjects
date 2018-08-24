package springboot.template.global.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther HUGH
 * @Date 2018/7/29
 * @Description IdType
 */

public class IdType {
    /**
     * id生成方式
     */
    private final String TYPE_2 = "2";
    /**
     * id生成方式
     */
    @Value("${myconfig.id.type}")
    private String idType;

    @Pointcut(value = "@annotation(springboot.template.global.annotation.Insert))")
    public void insert() {
    }


    public Object setId(ProceedingJoinPoint point) {
        System.out.println("idType = " + idType);
        Object proceed = null;
        if (TYPE_2.equals(idType)) {
            Object o = point.getArgs()[0];
            System.out.println("o = " + JSON.toJSONString(o));
        }
        try {
            proceed = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
