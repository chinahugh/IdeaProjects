package com.java.audition.code;

import org.junit.Test;

/**
 * @Auther HUGH
 * @Date 2018/6/28
 * @Description SupperClass
 * 一.子类对父类成员的继承
 * 1.子类会继承父类的所有东西，包括私有，而修饰符只是影响属性或者方法对外是否可见。
 * 2.Java官方文档的解释：子类不能继承父类的私有属性，但是如果子类中公有的方法影响
 * 到了父类私有属性，那么私有属性是能够被子类使用的。
 * 二 .子类对父类成员的访问方式:
 * 1.在父类中提供public的方法对其私有成员进行调用
 */
public class SupperClass {
}

class A {
    private String str = "kkk";
    private int a = 12;

    public A() {
    }

    //    public A(int a){
//        this.a=a;
//    }
    private void a() {
        System.out.println("A_a");
    }
    //父类提供公有方法，对私有方法调用，子类也可以调用此方法，来调用父类私有方法
    public void ap() {
        a();
    }

    public String getStr() {
        return str;
    }

    public int getA() {
        return a;
    }
}

class B extends A {
    public B(int a) {
        super();

    }

    @Test
    public void test1() {
        getA();//方法是可以用的
        ap();
//        报错，父类的私有方法不可见
//        a();
    }

    @Override
    public void ap() {
        super.ap();
    }
}