package com.java.focus.stream;

import java.util.Optional;

/**
 * @Author: hugh
 * @Time: 2017/12/25 1:18 PM
 * @Discraption: Optional是一个容器对象，用于容纳非空对象。Optional对象通过缺失值值代表null。这个类有许多实用的方法来促使代码能够处理一些像可用或者不可用的值，而不是检查那些空值（null）。
 */
public class Optional_01 {
    public static void main(String args[]) {

        Optional_01 tester = new Optional_01();
        Integer value1 = null;
        Integer value2 = 5;

        // ofNullable 允许传参时给出 null
        Optional<Integer> a = Optional.ofNullable(value1);

        // 如果传递的参数为null，那么 of 将抛出空指针异常（NullPointerException）
        Optional<Integer> b = Optional.of(value2);
        System.out.println(tester.sum(a, b));
    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {

        // isPresent 用于检查值是否存在

        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        // 如果当前返回的是传入的默认值，orElse 将返回它
        Integer value1 = a.orElse(0);

        // get 用于获得值，条件是这个值必须存在
        Integer value2 = b.get();
        return value1 + value2;
    }
}
