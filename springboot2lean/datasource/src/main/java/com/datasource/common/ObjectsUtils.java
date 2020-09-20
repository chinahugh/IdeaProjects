package com.datasource.common;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.datasource.entity.User;

import java.time.LocalDateTime;
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
        User user = new User();
        user.setId(1);
        user.setInsertime(LocalDateTime.now());
        user.setName("hgh");
        Map<String, Object> stringObjectMap = objectToMap(user);
        System.out.println(ObjectUtil.toString(stringObjectMap));
    }
}
