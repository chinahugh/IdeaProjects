package com.zjkjsoft.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文本工具
 * @author 张昆
 *  2012-8-28 下午3:04:30
 */
public class TextUtil {
	/***
	 * 去除html代码
	 * @param htmlstr
	 * @return
	 */
	public static String quHtml(String htmlStr){
	
		String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_link="<link[^>]*?>[\\s\\S]*?<\\/link>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
        
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
        
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
        
        Pattern p_link=Pattern.compile(regEx_link,Pattern.CASE_INSENSITIVE); 
        Matcher m_link=p_link.matcher(htmlStr); 
        htmlStr=m_link.replaceAll(""); //过滤link标签 
        
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

       return htmlStr.trim(); //返回文本字符串 
	}
	/**
	 * 插入html代码
	 * @param str
	 * @return
	 */
	public static String inHTML(String str)
	{
		String sTemp;
		sTemp = str;
		if(sTemp==null||sTemp.equals(""))
		{
			return "没有内容,请添加";
		}
		sTemp = sTemp.replaceAll("&", "&amp;");
		sTemp = sTemp.replaceAll("<", "&lt;");
		sTemp = sTemp.replaceAll(">", "&gt;");
		sTemp = sTemp.replaceAll("\"", "&quot;");
		return sTemp;
	}
	
	/**
	 * 输入html代码
	 * @param str
	 * @return
	 */
	public static String outHTML(String str)
	{
		String sTemp;
		sTemp = str;
		if(sTemp==null||sTemp.equals(""))
		{
			return "没有内容,请添加";
		}
		sTemp = sTemp.replaceAll("&amp;", "&");
		sTemp = sTemp.replaceAll("&lt;", "<");
		sTemp = sTemp.replaceAll("&gt;", ">");
		sTemp = sTemp.replaceAll("&quot;", "\"");
		return sTemp;
	}
	public  static void main(String[] args){
		//String str="fr01";
		//System.out.println(str.substring(2));
		//System.out.append(TextUtil.inHTML("<html><a href='dsff我靠'>我们<span>中国</span></html>"));
		//System.out.append(TextUtil.outHTML("&lt;html&gt;&lt;a href='dsff我靠'&gt;我们&lt;span&gt;中国&lt;/span&gt;&lt;/html&gt;"));
	}
}
