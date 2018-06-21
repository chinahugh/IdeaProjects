package com.designpatterns.design.singleton.code;

/**
 * @Auther HUGH
 * @Date 2018/6/20
 * @Description Singleton_2 懒汉，线程安全
 * 能够在多线程中很好的工作，而且看起来它也具备很好的lazy loading，但是，遗憾的是，效率很低，99%情况下不需要同步
 */
public class Singleton_2 {
    private Singleton_2 singleton_2;

    public Singleton_2(){}

    public synchronized Singleton_2 getInstance(){
        if (singleton_2 == null) {
            singleton_2=new Singleton_2();
        }
        return singleton_2;
    }
}
