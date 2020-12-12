package com.java.java8.stream;

/**
 * @Author: hugh
 * @Time: 2017/12/25 1:09 PM
 * @Discraption: 接口默认方法
 */
public class Student implements Younger, Learner {
    @Override
    public void print() {
        Younger.super.print();
        Learner.super.print();
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.print();
    }
}

interface Younger {
    default void print() {
        System.out.println("I am Younger");
    }
}

interface Learner {
    default void print() {
        System.out.println("I am Learner");
    }
}