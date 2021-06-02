package com.java.core.collections.map;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther HUGH
 * @Date 2018/6/21
 * @Description Map
 */
public class Hello {
    private Map map;
    private HashMap hashMap;
    private AbstractMap abstractMap;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public HashMap getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    public AbstractMap getAbstractMap() {
        return abstractMap;
    }

    public void setAbstractMap(AbstractMap abstractMap) {
        this.abstractMap = abstractMap;
    }

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("asd", "asdd");
        map.put("asd2", "asdd123");
        map.put("asd3", "asddasd");
        String s = map.values().toString();
        System.out.println(s);
        Object[] a= {"asd","asd"};
        System.out.println(Arrays.toString(a));
    }
}
