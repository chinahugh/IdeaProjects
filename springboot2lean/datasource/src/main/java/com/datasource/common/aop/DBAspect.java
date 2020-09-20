package com.datasource.common.aop;

import com.datasource.common.Page;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Aspect
@Component
public class DBAspect {
    Logger logger = LoggerFactory.getLogger(DBAspect.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Pointcut("@annotation(com.datasource.common.aop.DBAnno)")
    public void pointcut() {
    }

    @Pointcut("execution(public * com.datasource.common.DB.*(..))")
    public void pointcut2() {
    }

    @Around("pointcut()||pointcut2()")
    public Object around(ProceedingJoinPoint point) {
        try {
            Object[] args = point.getArgs();
            if (args[0] instanceof Page) {
                Page page = (Page) (args[0]);
                logger.info("args:{}", args.length);
                if (args[args.length - 1] instanceof Object[]) {
                    Object[] arg = (Object[]) (args[args.length - 1]);
                    List<Map<String, Object>> maps = jdbcTemplate.queryForList(args[1].toString(), arg);
                    page.setTotalRows(maps.size());
                }
            }
            return point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
