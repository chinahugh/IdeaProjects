package com.java.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HUGH
 * @Date 2019/1/26 11:40
 * @Description BaseTypeUtils java基本类型工具类
 */
public class BaseTypeUtils {
    /**
     * 基本类型
     */
    public final static String[] baseTypes = {"int", "double", "long", "short", "byte", "boolean", "char", "float"};
    /**
     * 包装类型、String类型
     */
    public final static String[] packType = {"java.lang.Integer",
            "java.lang.Double",
            "java.lang.Float",
            "java.lang.Long",
            "java.lang.Short",
            "java.lang.Byte",
            "java.lang.Boolean",
            "java.lang.Character",
            "java.lang.String"};
    /**
     * 基本类型、包装类型、String类型
     */
    public final static String[] types = {"java.lang.Integer",
            "java.lang.Double",
            "java.lang.Float",
            "java.lang.Long",
            "java.lang.Short",
            "java.lang.Byte",
            "java.lang.Boolean",
            "java.lang.Character",
            "java.lang.String",
            "int", "double", "long", "short", "byte", "boolean", "char", "float"};

    public final static Map<String,Object> typesDefault=new HashMap<String, Object>(){
       {
           put("java.lang.Integer", null);
           put("java.lang.Double",null );
           put("java.lang.Float", null);
           put("java.lang.Long", null);
           put("java.lang.Short", null);
           put("java.lang.Byte", null);
           put("java.lang.Boolean", null);
           put("java.lang.Character", null);
           put("java.lang.String", "");
           put("int",0 );
           put("double", 0.0);
           put("long", 0);
           put("short", 0);
           put("byte", 0);
           put("boolean", false);
           put("char", 0);
           put("float", 0);
        }
    };

    private BaseTypeUtils(){}
    private static final Map<String,String> urlMap =new HashMap<String, String>() {
        {
            put("url1", "http://news.sina.com.cn");//新浪新闻
            put("url2", "http://news.163.com");//网易新闻
            put("url3", "http://news.qq.com");//腾讯新闻
            put("url4", "http://news.baidu.com");//百度新闻
            put("url5", "http://www.ifeng.com");//凤凰网
        }
    };
}
