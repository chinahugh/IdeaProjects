package com.java.core.collections.map.linkedhashmap;

import org.junit.Test;

import java.util.LinkedHashMap;

/**
 * @Auther HUGH
 * @Date 2018/6/23
 * @Description LinkedHashMapTest
 */
public class LinkedHashMapTest {
    @Test
    public void a(){
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(1,5);
        map.put(21,4);
        int size = map.size();
        System.out.println(map.toString());
    }
}
