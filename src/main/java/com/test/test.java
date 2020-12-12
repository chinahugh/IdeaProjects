package com.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HUGH
 * @Date 2019/11/14 13:00
 * @Description test
 */
public class test {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        b.aaa();
    }
}

class A {
    public A() {
    }

    public void a() {
        System.out.println(1111111111);
    }
}

class B {
    private List<A> list = new ArrayList<>();

    public B(A a) {
        list.add(a);
    }

    public void aaa(){
        for (A a:list){
            a.a();
        }
    }
}


