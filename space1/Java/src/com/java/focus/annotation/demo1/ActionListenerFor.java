package com.java.focus.annotation.demo1;

import java.awt.event.ActionListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Auther HUGH
 * @Date 2018/3/24
 * @Description ActionListenerFor 为按钮绑定事件监听器
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionListenerFor {
    /**
     * 该变量用于保存监听器实现类
     *
     * @return
     */
    Class<? extends ActionListener> listener();
}
