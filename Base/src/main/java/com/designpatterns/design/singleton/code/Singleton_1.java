package com.designpatterns.design.singleton.code;

/**
 * @Auther HUGH
 * @Date 2018/6/20
 * @Description Singleton_1 懒汉，线程不安全
 * 没有考虑到线程安全，可能存在多个访问者同时访问，并同时构造了多个对象的问题。
 * 之所以叫做懒汉模式，主要是因为此种方法可以非常明显的lazy loading。
 */
public class Singleton_1 {
    private Singleton_1 singleton_1;

    private Singleton_1() {
    }

    public Singleton_1 getSingleton_1() {
        if (singleton_1 == null) {
            singleton_1=new Singleton_1();
        }
        return singleton_1;
    }
}
