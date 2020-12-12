package com.java.java8.annotation.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author HUGH
 * @Date 2019/1/26 8:34
 * @Description Ioc ioc注解类
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface Ioc {
    /**
     * 是否为单例开关 后续实现 TODO
     */
    boolean required() default true;
}
