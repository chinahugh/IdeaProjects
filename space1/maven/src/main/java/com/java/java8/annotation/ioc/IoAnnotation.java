package com.java.java8.annotation.ioc;

import com.java.utils.BaseTypeUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author HUGH
 * @Date 2019/1/26 8:46
 * @Description IocAnnotation 实现IOC注入过程
 */
public class IoAnnotation {
    /**
     * 类的对象集合，所有的类都将创建唯一的对象放入集合
     */
    @SuppressWarnings("unchecked")
    private static ConcurrentHashMap<Class<?>, Object> classMap = new ConcurrentHashMap();

    /**
     * clzss对象中实例注入
     *
     * @param clzss
     */
    public void ioc(Object clzss) {
        Field[] declaredFields = clzss.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            //判断字段具有Ioc注解
            if (isAnnocation(field, Ioc.class)) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    Object instance = getInstance(type);
                    //赋值
                    field.set(clzss, instance);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取类的对象
     *
     * @param type 获取对象的类
     * @return
     */
    private Object getInstance(Class<?> type) {
        Object o = null;
        if (classMap.containsKey(type)) {
            o = classMap.get(type);
        } else {
            //获取所有构造函数
            //若type为接口，无法创建对象,后续需实现接口实现类的对象注入 TODO
            Constructor<?>[] declaredConstructors = type.getDeclaredConstructors();
            for (Constructor constructor : declaredConstructors) {
                constructor.setAccessible(true);
                //获取构造函数参数
                Parameter[] parameters = constructor.getParameters();
                //无参构造对象
                if (parameters.length == 0) {
                    try {
                        o = type.newInstance();
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    //有参构造对象
                    //获取所有参数
                    Class[] parameterTypes = constructor.getParameterTypes();
                    Object[] arrays = new Object[constructor.getParameterCount()];
                    for (int i = 0; i < parameterTypes.length; i++) {
                        arrays[i] = getDefault(parameterTypes[i]);
                    }
                    try {
                        //构造函数创建对象
                        o = constructor.newInstance(arrays);
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (o != null) {
                Ioc annotation = o.getClass().getAnnotation(Ioc.class);
                if (annotation == null ||(annotation!=null&&annotation.required())) {
                    classMap.put(type, o);
                }
            }
        }
        return o;
    }

    /**
     * 获取类的默认值，
     * 1.java基础类型的值在本方法直接赋值
     * 2.非java基础类型的值将调用getInstance进行递归，找到底层基础类型进行赋值
     *
     * @param parameterType
     * @return
     */
    private Object getDefault(Class parameterType) {
        Object o = null;
        //是否为java基础类型
        if (parameterType.isPrimitive()) {
            throw new RuntimeException("不能为基础类型");
        } else {
            //是否为String类型
            if (parameterType.equals(String.class)) {
                o = "";
            } else {
                //其它类型返回溯源至基本类型
                if (!isBaseType(parameterType)) {
                    o = getInstance(parameterType);
                }
            }
        }
        return o;
    }

    /**
     * 判断类是否为java基本类型
     *
     * @param type
     * @return
     */
    private boolean isBaseType(Class type) {
        boolean b = false;
        for (String s : BaseTypeUtils.packType) {
            if (s.equals(type.getTypeName())) {
                b = true;
                break;
            }
        }
        return b;
    }

    public boolean isAnnocation(Field field, Class<Ioc> clzss) {
        Ioc annotation = field.getAnnotation(clzss);
        if (annotation != null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IoAnnotation ioAnnotation = new IoAnnotation();
        Object clzss = ioAnnotation.getInstance(Controller.class);
        ioAnnotation.ioc(clzss);
        Controller instance = (Controller) ioAnnotation.getInstance(Controller.class);
        instance.display();
    }
}
