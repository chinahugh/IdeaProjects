package com.zjkjsoft.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.zjkjsoft.memcached.MemcachedClient;
import com.zjkjsoft.model.Syslog;
import com.zjkjsoft.model.Suser;

/**
 * 基础Controller
 * @author 张昆
 *  2012-9-3 下午10:37:28
 */
public abstract class BaseController extends Controller {
	public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static SimpleDateFormat sfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sfd = new SimpleDateFormat("yyyyMMddHHmmsss");
	public static SimpleDateFormat sfday = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sfnd = new SimpleDateFormat("yyyy");
	public static SimpleDateFormat sfny = new SimpleDateFormat("yyyy年MM月");
	public static SimpleDateFormat sfnyr = new SimpleDateFormat("yyyy年MM月dd日");
	public static MemcachedClient mcc;
	protected int pageSize=20;
	public static Gson gson=new Gson();
	public abstract void index();
	public abstract String action();
	@Override
	public void render(String view) {
		//this.setAttr("root","");
		if(null==getSessionAttr("user")){
			//super.render("/");
//			{
//				"statusCode":"301",
//				"message":"\u4f1a\u8bdd\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\u3002",
//				"navTabId":"",
//				"callbackType":"",
//				"forwardUrl":""
//			}
			this.renderText("{\"statusCode\":\"301\",\"message\":\"\u4f1a\u8bdd\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\u3002\",\"navTabId\":\"\",\"callbackType\":\"\",\"forwardUrl\":\"\"}");
		}else
		    super.render(view);
	}
	/**获取当前系统操作人*/
	public Record getCurrentUser(){
		return (Record)mcc.get(getSession().getId());
	}
	/**
	 * 转换dwz json格式输出
	 * @param statusCode
	 * @param message
	 * @param navTabId
	 */
	public void toDwzJson(Integer statusCode,String message,String navTabId){
		toDwzJson(statusCode, message, navTabId, null, null);
	}
	
	/**
	 * 转换dwz json格式输出
	 * @param statusCode
	 * @param message
	 * @param navTabId
	 * @param forwardUrl
	 * @param callbackType
	 */
	public void toDwzJson(Integer statusCode,String message,String navTabId,String forwardUrl,String callbackType){
		toDwzJson(statusCode, message, navTabId, forwardUrl, null, callbackType);
	}
	
	/**
	 * 转换dwz json格式输出
	 * @param statusCode
	 * @param message
	 * @param navTabId
	 * @param forwardUrl
	 * @param rel
	 * @param callbackType
	 */
	public void toDwzJson(int statusCode, String message, String navTabId, 
			String forwardUrl, String rel, String callbackType)
	{
		Suser user = this.getSessionAttr("user");
		if(null!=user)
		{
			Syslog.insertLog(user.getInt("id"), getRequest().getRemoteAddr(), action(), message);
			//Db.update("insert into syslog ( userid, mc, ms, ctime) values ( "+user.getInt("id")+",  '"+action()+"', '"+message+"', getdate())");
			//Db.update("insert into syslog (ID, ygzh, ygmc, mc, ms, sj) values (syslog_seq.nextval, '"+user.getStr("username")+"', '"+user.getStr("ygmc")+"', '"+action()+"', '"+message+"', '"+sfs.format(new Date())+"')");
		}
		Map<String,Object> jsonMap=new HashMap<String,Object>();
		jsonMap.put("statusCode", statusCode);
		if(message!=null&&!message.isEmpty())
			jsonMap.put("message",message);
		if(navTabId!=null&&!navTabId.isEmpty())
			jsonMap.put("navTabId", navTabId);
		if(forwardUrl!=null&&!forwardUrl.isEmpty())
			jsonMap.put("forwardUrl",forwardUrl);
		if(rel!=null&&!rel.isEmpty())
			jsonMap.put("rel", rel);
		if(callbackType!=null&&!callbackType.isEmpty())
			jsonMap.put("callbackType", callbackType);
		this.renderText(gson.toJson(jsonMap));
	}
}
