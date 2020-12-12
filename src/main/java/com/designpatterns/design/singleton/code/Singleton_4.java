package com.designpatterns.design.singleton.code;

/**
 * @Auther HUGH
 * @Date 2018/6/20
 * @Description Singleton_4 饿汉，变种
 */
public class Singleton_4 {

    private Singleton_4(){}

    private static final Singleton_4 singleton_4;

    static {
        singleton_4=new Singleton_4();
    }

    public static Singleton_4 getSingleton_4() {
        return singleton_4;
    }
}
