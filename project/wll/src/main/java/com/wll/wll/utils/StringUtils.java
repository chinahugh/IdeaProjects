package com.wll.wll.utils;

/**
 * @Auther HUGH
 * @Date 2018/5/16
 * @Description StringUtils
 */
public class StringUtils {
    public static boolean isNotEmpty(CharSequence id) {
        return !com.alibaba.druid.util.StringUtils.isEmpty(id);
    }
}
