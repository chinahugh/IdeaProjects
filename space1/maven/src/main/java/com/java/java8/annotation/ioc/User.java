package com.java.java8.annotation.ioc;

import java.io.Serializable;
import java.util.Map;

/**
 * @author HUGH
 * @Date 2019/1/26 9:04
 * @Description User
 */
public class User implements Serializable {
    private String name;
    private Integer age;
    private InnerC inner;
private Map map;

    public User(String name, Integer age, InnerC inner, Map map) {
        this.name = name;
        this.age = age;
        this.inner = inner;
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public InnerC getInner() {
        return inner;
    }

    public void setInner(InnerC inner) {
        this.inner = inner;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", inner=" + inner +
                ", map=" + map +
                '}';
    }
}

class InnerC {
    private String name;
    private Character c;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getC() {
        return c;
    }

    public void setC(Character c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "InnerC{" +
                "name='" + name + '\'' +
                ", c=" + c +
                '}';
    }
}
