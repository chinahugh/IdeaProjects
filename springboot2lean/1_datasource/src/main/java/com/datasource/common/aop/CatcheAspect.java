package com.datasource.common.aop;

import com.datasource.common.E;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author HGH
 */
@Aspect
@Order(2)
@Component
public class CatcheAspect {
    private final Logger logger = LoggerFactory.getLogger(DBAspect.class);
    @Autowired
    private RedisTemplate<String, Object> redisT;

    @Pointcut(value = "@annotation(com.datasource.common.aop.CatcheA)")
    public void pointcut() {
    }

//    @Pointcut(value = "execution(public * com.datasource.service.impl.*.*(..))")
//    public void pointcut2() {
//    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint point) {

        Method method = ((MethodSignature) point.getSignature()).getMethod();
        CatcheA annotation = method.getAnnotation(CatcheA.class);
        String catchkey = annotation.name();
        boolean clear = annotation.clear();
        long time = annotation.time();
        logger.info("CatcheA annotation : name:{},clear:{},time:{}", catchkey, clear, time);
        Signature signature = point.getSignature();
        catchkey = signature.getDeclaringType().getName() + catchkey;
        try {
            Object proceed;
            Boolean aBoolean = redisT.hasKey(catchkey);
            if (clear) {
                redisT.delete(catchkey);
                proceed = point.proceed();
            } else if (Objects.nonNull(aBoolean) && aBoolean) {
                proceed = redisT.opsForValue().get(catchkey);
            } else {
                proceed = point.proceed();
                if (proceed instanceof Serializable) {
                    redisT.opsForValue().set(catchkey, proceed, time, TimeUnit.SECONDS);
                }
            }
            return proceed;
        } catch (Throwable t) {
            throw new E(t);
        }
    }
}
