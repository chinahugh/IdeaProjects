package com.zjkjsoft.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.uu.http.client.HttpClient;

import com.zjkjsoft.model.Sms;

public class SMSUtil {
	public static String gatewayIP="xbzdxm.com";
	public static String user="4508a66445a24aafa0c6c833a800e9a8";
	public static String pwd="zjkjyshbeta2017";
	public static SimpleDateFormat sfd = new SimpleDateFormat("yyyyMMddHHmmsss");
	public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	/**
	 * 短信单发
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static boolean dxdf(int userid,String phoneNumber,String sms) throws UnsupportedEncodingException{
		//Personnel personnel=Personnel.dao.findById(ygid);	
		//String ygdh=personnel.getStr("ygdh");	
		if( sms.length()>0){
			String str=phoneNumber;
			if(str.indexOf("，")>-1){
				 str=str.replace("，",",");
			}
			String [] a=str.split(",");
			for(String mobile:a){
				System.out.println(mobile);
			
				 String retInfor="";
				 String sms_url="";
				 /*String sms_content=sms.replace("%", "%25");
				 sms_content=sms_content.replace("=", "%3D");
				 sms_content=sms_content.replace("?", "%3F");
				 sms_content=sms_content.replace("#", "%23");
				 sms_content=sms_content.replace("&", "%26");
				 sms_content=sms_content.replace("/", "%2F");
				 sms_content=sms_content.replace("+", "%20");
				 sms_content=sms_content.replace(" ", "%20");*/
				 //sms_url="http://xbzdxm.com:8081/zjkjsms/f/smsSend?action=send&userid=4508a66445a24aafa0c6c833a800e9a8&account=openBeta&password=zjkjyshbeta2017&phoneNumber=15023239810,13527576163&smsContent=短信测试&signature =&sendTime=&extno =; 
				 sms_url="http://"+gatewayIP+":8081/zjkjsms/f/smsSend?action=send&userid="+user+"&account=openBeta&password="+pwd+"&phoneNumber="+mobile+"&smsContent="+URLEncoder.encode(sms, "utf-8")+"&signature=&sendTime=&extno="; //用于以http方式发送
				 // retInfor=HttpClient.sendRequest(sms_url);
                 System.out.println(sms_url);
                 sms_url=StrUtil.turnGBKbyUTF(sms_url);
                 System.out.println("dbk---"+sms_url);
				 if(sendRequest(sms_url)){
				 Sms m = new Sms();
				 m.set("fstype", "sms");
				 m.set("userid", userid);
				 m.set("phoneNumber", mobile);
				 m.set("smsContent", sms);
				 m.set("sendTime", sf.format(new Date()));		
				 m.save();	
				
				 }
				
			//用于以http方式发送
			//System.out.println("以http方式发送返回结果："+retInfor);
		}	}
		 return true;
	
	}

	/**
	 * 站内通知单发
	 * @return
	 */
//	public static void zntzdf(String ygid,String sms){
//		if(ygid!=null && sms.length()>0){
//	 
//			String tzbh=sfd.format(new Date());
//			m.set("tzbh", tzbh);
//			m.set("tzlx","系统短信");
//			m.set("mc","系统短信");
//			m.set("fjmc","系统");
//			m.set("fjtime",sf.format(new Date()));
//			m.set("sjid",ygid);//m.set("sjid",new BigDecimal(ygid));
//			m.set("cont", sms);
//			m.set("id", "inform_seq.nextval").set("tzlx",0).save();//原稿保存
//			m.set("id", "inform_seq.nextval").set("tzlx",2).save();//收件						
//		}
//	}
	/**
	 * 站内通知群发
	 * @return
	 */
//	public static void zntzqf(String[] ygids,String sms){
//		if(ygids.length>0 && sms.length()>0){
//			for(int i=0;i<ygids.length;i++){
//				zntzdf(ygids[i], sms);
//			}
//		}		
//	}
	/**
	 * 组合（即能够发送短信，同时能够发送通知）单发
	 * @return 
	 */


//	public static void zhqf(List<Personnel> personnelL,String sms){
//		
//			for(int i=0;i<personnelL.size();i++){
//				zhdf( personnelL.get(i).getBigDecimal("id")+"", sms);
//			}
//	}
	
	  public static boolean sendRequest(String sms_url){
		  try{   
				 //String  sms_url="http://xbzdxm.com:8081/zjkjsms/f/smsSend?action=send&userid=4508a66445a24aafa0c6c833a800e9a8&account=openBeta&password=zjkjyshbeta2017&phoneNumber=13992838531&smsContent=欢度国庆&signature=&sendTime=&extno="; 
		          URL gis = new  URL(sms_url);
		          //URL gis=new URL("file:\\D:\\Program Files\\Java\\jdk1.6.0_16\\bin\\URLReader.java");  
		           BufferedReader in = new BufferedReader(new InputStreamReader(gis.openStream()));
		             String line;
		             while( (line=in.readLine()) != null )  {
		            	 System.out.println(line);
		            	 line=StrUtil.turnUTFbyGBK(line);
		                   System.out.println(line);
		                   if(line.indexOf("提交成功")>1){
		                	   System.out.println("----------------ok");
		                	   return true;
		                   }
		             }
		             in.close();
		             return false;
		         }catch(Exception e){
		             System.out.println(e);
		             return false;
		         }
	}
	
	public static void main(String[] args) {
		/*
		String str="18700092834,18700092833，1870000000";
		if(str.indexOf("，")>-1){
			 str=str.replace("，",",");
		}
		String [] a=str.split(",");
		for(String mobile:a){
			System.out.println(mobile);
		}
		*/
		
		
	}
}
