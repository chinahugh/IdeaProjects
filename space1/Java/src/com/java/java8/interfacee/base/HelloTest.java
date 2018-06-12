package com.java.java8.interfacee.base;

import com.java.focus.jvm.classload.Hello;

/**
 * @Auther HUGH
 * @Date 2018/6/12
 * @Description A
 * 默认方法 当没有显示提供其他实现时就采用这个实现
 */
public class HelloTest {
    public static void main(String[] args) {
        HelloInterface hello = new HelloInterface();
        int i = hello.get(10);
        System.out.println("i = " + i);
        hello.getString();
    }
}

interface A {
    int get(int i);

    /**
     * 默认方法
     */
    default void getString() {
        System.out.println("A : " + this.toString());
    }
}

interface B {
    int get(int i);
    /**
     * 默认方法
     */
    default void getString() {
        System.out.println("B : " + this.toString());
    }
}

class HelloInterface implements A, B {

    @Override
    public int get(int i) {

        return i * i;
    }

    /**
     * 如果一个类实现两个或两个以上接口，并且多个接口中包含统一默认方法，
     * 如果不实现该方法，编译器将报错。这种情况，我们必须让子类Override
     * 该方法，否则无法编译通过。
     */
    @Override
    public void getString() {
        System.out.println("this = " + this);
    }
}
