package com.zjkjsoft.util;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.uu.http.client.HttpClient;

import com.zjkjsoft.model.Sms;

public class WxUtil {
	public static SimpleDateFormat sfd = new SimpleDateFormat("yyyyMMddHHmmsss");
	public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	  public static boolean sendRequest(String content){
		  try{   
			  
			  	 Sms m = new Sms();
			  	 m.set("fstype", "wx");
				 m.set("userid", 1);
				 m.set("phoneNumber", "18700092834");
				 m.set("smsContent", content);
				 m.set("sendTime", sf.format(new Date()));		
				 m.save();	
			  
			  
				 //String  sms_url="http://xbzdxm.com:8081/zjkjsms/f/smsSend?action=send&userid=4508a66445a24aafa0c6c833a800e9a8&account=openBeta&password=zjkjyshbeta2017&phoneNumber=13992838531&smsContent=欢度国庆&signature=&sendTime=&extno="; 
		          URL gis = new  URL("http://ysh2008.vicp.net/wpp.php?content="+URLEncoder.encode(content, "utf-8"));
		          //URL gis=new URL("file:\\D:\\Program Files\\Java\\jdk1.6.0_16\\bin\\URLReader.java");  
		           BufferedReader in = new BufferedReader(new InputStreamReader(gis.openStream()));
		             String line;
		             while( (line=in.readLine()) != null )  {
		            	 System.out.println(line);
		            	 line=StrUtil.turnUTF(line);
		                   System.out.println(line);
		                   if(line.indexOf("ok")>1){
		                	   System.out.println("weixin----------------ok");
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
	
	/*public static void main(String[] args) {
			sendRequest("http://wo.sptc.wang/wpp.php?content=消息");
			
	}*/
}
