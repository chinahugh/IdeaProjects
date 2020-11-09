package com.datasource.common.aop;

import com.datasource.common.E;
import com.datasource.common.Page;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author HGH
 */
@Aspect
@Order(1)
@Component
public class DBAspect {
    Logger logger = LoggerFactory.getLogger(DBAspect.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Pointcut("@annotation(com.datasource.common.aop.DBAnno)")
    public void pointcut() {
    }

//    @Pointcut("execution(public * com.datasource.common.DB.*(..))")
//    public void pointcut2() {
//    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        try {
            Page page = null;
            Object[] args = point.getArgs();
            if (args[0] != null && args[0] instanceof Page) {
                page = (Page) (args[0]);
                if (args[args.length - 1] instanceof Object[]) {
                    Object[] arg = (Object[]) (args[args.length - 1]);
                    List<Map<String, Object>> maps = jdbcTemplate.queryForList(args[1].toString(), arg);
                    page.setTotalRows(maps.size());
                }
            }
            Object proceed = point.proceed();
            if (args[0] instanceof Page && proceed instanceof List && page != null) {
                page.setCurrentRows(((List) proceed).size());
            }
            return proceed;
        } catch (Throwable t) {
            logger.error(t.getMessage());
            throw new E(t);
        }
    }

}
