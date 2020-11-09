package com.datasource.common;


import cn.hutool.core.util.ReflectUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ObjectsUtils {
    public static Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> map = new HashMap<>(10);
        Object[] fields = ReflectUtil.getFieldMap(obj.getClass()).keySet().toArray();
        for (Object field : fields) {
            Object fieldValue = ReflectUtil.getFieldValue(obj, String.valueOf(field));
            map.put(String.valueOf(field), fieldValue);
        }
        return map;
    }

    public static void main(String[] args) {
//        User user = new User();
//        user.setId(1);
//        user.setInsertime(LocalDateTime.now());
//        user.setName("hgh");
//        Map<String, Object> stringObjectMap = objectToMap(user);
//        System.out.println(ObjectUtil.toString(stringObjectMap));

        ArrayList<Object> objects = new ArrayList<Object>() ;
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        System.out.println("Arrays.toString(o) = " + objects.toString());
//        List<Object> objects1 = objects.subList(, 7);
//        System.out.println("objects1 = " + objects1.toString());
    }
}
