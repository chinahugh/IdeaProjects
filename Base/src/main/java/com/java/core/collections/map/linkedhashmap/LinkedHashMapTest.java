package com.java.core.collections.map.linkedhashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

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

        map.put(21,4);
        map.put(2,3);
        map.put(1,5);
        int size = map.size();
        System.out.println(map.toString());

        HashMap<Object, Object> map2 = new HashMap<>();
        map2.put(1,2);

        map2.put(21,4);
        map2.put(20,4);
        map2.put(2,3);
        map2.put(1,5);
        map2.put(21,4);
        map2.put(2,3);
        map2.put(3,4);
        map2.put(1,5);
        int size2 = map2.size();
        System.out.println(map2.toString());

        TreeMap<Object, Object> map3 = new TreeMap<>();
        map3.putAll(map);
        map3.put(1,2);

        map3.put(21,4);
        map3.put(2,3);
        map3.put(3,4);
        map3.put(1,5);
        int size3 = map3.size();
        System.out.println(map3.toString());
    }
}
