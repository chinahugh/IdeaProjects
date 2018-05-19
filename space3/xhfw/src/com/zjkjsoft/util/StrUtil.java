package com.zjkjsoft.util;

import java.io.UnsupportedEncodingException;
import java.util.Set;

/**
 * 字符串处理类
 *
 */
public class StrUtil {
	
	/**
	 * 		
	 * @param str
	 * @param c
	 * @return
	 */
	public static Set getSetByStrs(String str,String c){
	   Set<String> set =new java.util.HashSet();
	   String[] strs=str.split(c);
	   for(int i=0;i<strs.length;i++) 
			  set.add(strs[i]) ;	   
	   return set;
	}
	public static String turnGBK(String temp)
	{
		if(temp!=null)
		{
			try {
				temp=new String(temp.getBytes("iso-8859-1"),"gbk");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	public static String turnUTF(String temp)
	{
		if(temp!=null)
		{
			try {
				temp=new String(temp.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	public static String turnGBKbyUTF(String temp)
	{
		if(temp!=null)
		{
			try {
				temp=new String(temp.getBytes("utf-8"),"gbk");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
	public static String turnUTFbyGBK(String temp)
	{
		if(temp!=null)
		{
			try {
				temp=new String(temp.getBytes("gbk"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return temp;
	}
}
