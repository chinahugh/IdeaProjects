package com.designpatterns.design.singleton.code;

/**
 * @Auther HUGH
 * @Date 2018/6/20
 * @Description Singleton_7 双重校验锁
 * <p>
 * STEP 1. 线程A访问getInstance()方法，因为单例还没有实例化，所以进入了锁定块。
 * STEP 2. 线程B访问getInstance()方法，因为单例还没有实例化，得以访问接下来代码块，而接下来代码块已经被线程1锁定。
 * STEP 3. 线程A进入下一判断，因为单例还没有实例化，所以进行单例实例化，成功实例化后退出代码块，解除锁定。
 * STEP 4. 线程B进入接下来代码块，锁定线程，进入下一判断，因为已经实例化，退出代码块，解除锁定。
 * STEP 5. 线程A初始化并获取到了单例实例并返回，线程B获取了在线程A中初始化的单例。
 * 理论上双重校验锁法是线程安全的，并且，这种方法实现了lazyloading。
 */
public class Singleton_7 {
    private volatile Singleton_7 singleton_7;

    private Singleton_7() {
    }

    public Singleton_7 getSingleton_7() {
        if (singleton_7 == null) {
            synchronized (Singleton_7.class) {
                if (singleton_7 == null) {
                    singleton_7 = new Singleton_7();
                }
            }
        }
        return singleton_7;
    }
}
