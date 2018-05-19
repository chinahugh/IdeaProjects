package com.wll.sys.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @Auther HUGH
 * @Date 2018/5/10
 * @Description MybatisDao
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface MybatisDao {
    String value() default "";
}
