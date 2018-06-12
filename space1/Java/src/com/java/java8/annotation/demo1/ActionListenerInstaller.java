package com.java.java8.annotation.demo1;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

/**
 * @Auther HUGH
 * @Date 2018/3/24
 * @Description ActionListenerInstaller 注解处理程序
 */
class ActionListenerInstaller {
    /**
     * o 是Annotation对象
     *
     * @param o
     * @param ok
     * @param cancel
     */
    static void processAnnotations(Object o, JButton ok, JButton cancel) {
        try {
            Class<?> aClass = o.getClass();
            for (Field field : aClass.getDeclaredFields()) {
                //设置变量为自由访问
                field.setAccessible(true);
                //获取所有field对象上的ActionListenerFor注解
                ActionListenerFor annotation = field.getAnnotation(ActionListenerFor.class);
                //获取变量的值
                Object fObj = field.get(o);
                //annotation不为空，而且field是AbstractButton的对象
                if (fObj != null && annotation != null && fObj instanceof AbstractButton) {
                   //获取注解上的listener值
                    Class<? extends ActionListener> listener = annotation.listener();
                    //使用注解传入的值创建对象
                    ActionListener actionListener = listener.newInstance();
                    AbstractButton ab = (AbstractButton) fObj;
                    ab.addActionListener(actionListener);
//                    ok.addActionListener(actionListener);
                }

            }
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }


}
