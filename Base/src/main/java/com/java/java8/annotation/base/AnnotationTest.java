package com.java.java8.annotation.base;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/3/24
 * @Description SuppressWarningTest
 * 基本注解范例
 */

public class AnnotationTest {
    public static void main(String[] args) {
        AnnotationTest test = new AnnotationTest();
//        System.out.println("test.safeVarargs() = " + test.safeVarargs("213"));
    }

    /**
     * SuppressWarning 使用
     */
    @SuppressWarnings(value = "unchecked")
    public void suppressWarning() {
        List<String> list = new ArrayList<>();
    }

    /**
     * SafeVarargs   可变长度的方法参数的实际值是通过数组来传递的，
     * 二数组中存储的是不可具体化的泛型类对象，自身存在类型安全问题。
     * 因此编译器会给出相应的警告消息。
     */
    @SafeVarargs
    public final String safeVarargs(String... strs) {
        System.out.println(strs.length);
        return strs.length > 0 ? strs[0] : null;
    }

    @Test
    public void test() {
        System.out.println("test");
    }

    @Test
    public void getAnnotations() throws ClassNotFoundException, NoSuchMethodException {
        Annotation[] tests = com.java.java8.annotation.base.TTest.class.getMethod("test").getAnnotations();
        for (Annotation a : tests) {
            System.out.println(a);
        }
    }

    /**
     * Java不允许创建带泛型类型的数组对象,Java是在运行时才去检查写入数组中的数据类型,
     * 但是又由于数组在运行时的泛型会被消除generic types have been erased，因此在
     * 运行时，JVM无法区分Pair<View, String>和Pair<TextView, String>.也就相当于
     * 我们将一个无泛型参数传递给了一个可变泛型参数的方法, 进而导致堆污染(Heap Pollution)
     */
    public void covariant() {
        // 编译报错
//        Pair<View, String>[] array = new Pair<View, String>[2];

    }
}

class A<T> {

}