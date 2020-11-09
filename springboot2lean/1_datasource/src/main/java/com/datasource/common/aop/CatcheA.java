package com.datasource.common.aop;

import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author HGH
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CatcheA {
    /**
     * 缓存名字，默认为类名加方法名
     *
     * @return
     */
    @NotNull  String name() ;

    /**
     * 是否清理缓存
     *
     * @return
     */
    boolean clear() default false;

    /**
     * 超时时间 ，默认不清理 单位：秒
     *
     * @return
     */
    long time() default -1;

}
