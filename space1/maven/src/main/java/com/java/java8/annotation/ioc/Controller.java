package com.java.java8.annotation.ioc;

/**
 * @author HUGH
 * @Date 2019/1/26 9:03
 * @Description Controller
 */
public class Controller {
    @Ioc(required = false)
    private User user;

    public void display(){
        System.out.println(user);
    }

    @Override
    public String toString() {
        return "Controller{" +
                "user=" + user +
                '}';
    }
}
