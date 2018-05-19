package com.java.focus.annotation.base;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/3/24
 * @Description SuppressWarningTest
 *  基本注解范例
 */

public class AnnotationTest {
    public static void main(String[] args) {

    }

    /**
     *SuppressWarning 使用
     */
    @SuppressWarnings(value = "unchecked")
    public void suppressWarning(){
        List<String> list=new ArrayList<>();
    }
/*    @SafeVarargs*/
    public void safeVarargs(){
        List list=new ArrayList<>();
        list.add(8);
        List<String> l=list;
        System.out.println(l.get(0));
    }
    @Test
    public void test(){
        System.out.println("test");
    }
    @Test
    public void getAnnotations() throws ClassNotFoundException, NoSuchMethodException {
        Annotation[] tests = com.java.focus.annotation.base.Test.class.getMethod("test").getAnnotations();
       for (Annotation a:tests){
           System.out.println(a);
       }
    }
}
