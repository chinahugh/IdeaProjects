package com.zjkjsoft.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zjkjsoft.element.PageElement;
import com.zjkjsoft.element.WebElenment;
import com.zjkjsoft.model.BarcodeConf;
import com.zjkjsoft.model.Cpcssz;
import com.zjkjsoft.model.Material;
import com.zjkjsoft.model.Product;
import com.zjkjsoft.model.Srole;
import com.zjkjsoft.model.Suser;
import com.zjkjsoft.util.MD5;
import com.zjkjsoft.util.StrUtil;
import com.zjkjsoft.util.TextUtil;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;

/**
 * 用户登录的类。验证用户名和密码是否正确。
 */
public class IndexController extends Controller {
	
	/** 日期格式化为 yyyy-MM-dd HH:mm 的类*/
	public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	/** 日期格式化为 MM-dd 的类*/
	public static SimpleDateFormat sfmd = new SimpleDateFormat("MM-dd");
	
	/** 日期格式化为 yyyy年MM月dd日  的类*/
	public static SimpleDateFormat sfynmdCN = new SimpleDateFormat("yyyy年MM月dd日");
	
	/** 日期格式化为 yyyy年MM月dd日  的类*/
	public static SimpleDateFormat sfymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static SimpleDateFormat sfymd = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 跳转到 登录页面
	 * <br/>页面：/login.jsp
	 */
	public void index() {
//		HttpServletRequest request=this.getRequest();
//		String ip = request.getHeader("X-Forwarded-For");  
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//		ip = request.getHeader("Proxy-Client-IP");  
//		}  
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//		ip = request.getHeader("WL-Proxy-Client-IP");  
//		}  
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//		ip = request.getHeader("HTTP_CLIENT_IP");  
//		}  
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//		ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
//		}  
//		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
//		ip = request.getRemoteAddr();  
//		} 
//	    System.out.println("ip=="+ip);
		render("/login.jsp");
	}

	/**
	 * 登录：验证 验证码、用户名、密码 是否正确
	 * <br/>假如正确 跳转到 页面：/manage.jsp
	 * <br/>假如错误 跳转到 页面：/login.jsp
	 */
	public void login() {
		String username = this.getPara("username");
		String password = this.getPara("password");
		if (username == null || "".equals(username) || password == null
				|| "".equals(password)) {
			setAttr("msg", "请正确输入用户帐号和密码！");
			render("/login.jsp");
		} else {
			String sql1 = "select *   from suser  where  loginname='"
					+ username.trim()
					+ "' and password='"
					+ MD5.toMD5(password.trim())
					+ "' ";
			Suser user = Suser.dao.findFirst(sql1);
			// {
			// \"statusCode\":\"200\",
			// \"message\":\"\u64cd\u4f5c\u6210\u529f\",
			// \"navTabId\":\"\",
			// \"rel\":\"\",
			// \"callbackType\":\"\",
			// \"forwardUrl\":\"\",
			// \"confirmMsg\":\"\"
			// }
			if (user == null) {
				// setAttr("msg", "请正确输入用户帐号和密码！");
				this
						.renderText("{\"statusCode\":\"301\",\"message\":\"请正确输入用户帐号和密码！\",\"navTabId\":\"\",\"callbackType\":\"\",\"forwardUrl\":\"\"}");
			} else {
				this.setSessionAttr("user", user);
				this.setSessionAttr("username", user.getStr("username"));
				this.setSessionAttr("loginname", user.getStr("loginname"));
				this.setSessionAttr("password", user.getStr("password"));
				// this.renderText("{statusCode:200,message:\u64cd\u4f5c\u6210\u529f,navTabId:,rel:main,callbackType:closeCurrent,forwardUrl:/,confirmMsg:}");
				this
						.renderText("{\"statusCode\":\"200\",\"message\":\"\u64cd\u4f5c\u6210\u529f\",\"navTabId\":\"\",\"rel\":\"main\",\"callbackType\":\"closeCurrent\",\"forwardUrl\":\"\",\"confirmMsg\":\"\"}");

			}

		}

	}
	
	/**
	 * 登录：验证 验证码、用户名、密码 是否正确
	 * <br/>假如正确 跳转到 页面：/manage.jsp
	 * <br/>假如错误 跳转到 页面：/login.jsp
	 */
	public void manage() {
		//验证码
		String  code=getPara("code");
		String  rand= this.getSessionAttr("rand");
		if(code==null||!code.equals(rand)){
			 String msg = "输入的验证码不对,请重新输入！";
			setAttr("arletMsg", "alert('"+msg+"');");
			setAttr("msg", msg);
		    render("/login.jsp");
			return ;
		}
		String username = this.getPara("yhid");
		String password = this.getPara("yhmm");
		if (username == null || "".equals(username) || password == null
				|| "".equals(password)) {
			setAttr("msg", "请正确输入用户帐号和密码！");
			render("/login.jsp");
		} else {
			String sql1 = "select *   from suser  where  loginname='"
					+ username.trim()
					+ "' and password='"
					+ MD5.toMD5(password.trim())
					+ "' ";
			Suser user = Suser.dao.findFirst(sql1);
			if (user == null) {
				render("/login.jsp");
			} else {
				this.setSessionAttr("user", user);
				this.setSessionAttr("username", user.getStr("username"));
				setAttr("cdtree", WebElenment.getCdtree(user.getInt("rid")));
				//setAttr("cdtree", WebElenment.getCdtreeNew(user.getInt("rid")));
				//String sql="SELECT id ,proname ,pronum ,infobh,batch FROM proinfo  where 1=1  "; 	        
				//setSessionAttr("gisList", Proinfo.dao.find(sql));
				render("/manage.jsp");
			}
		}
		
	}


	//////////////////////////////////////////后台

	/**
	 * 用于选择角色
	 * <br/>页面：/element/jsLookup.jsp
	 */
	public void treeJSLoop() {
		setAttr("list", Srole.dao.find(" select * from srole   order by id"));
		render("element/jsLookup.jsp");
	}
	/**
	 * 用于选择多角色
	 * <br/>页面：/element/jsLookup.jsp
	 */
	public void treeJSLoops() {
		setAttr("list", Srole.dao.find(" select * from srole   order by id"));
		render("element/jsLookups.jsp");
	}
	/**
	 * 栏目目录树
	 * <br/>页面：/element/lmLookup.jsp
	 */
	public void treeLMLoop() {
		String a = getPara("a");
		String b = getPara("b");
		setAttr("treeStr", PageElement.getLMLookUp(a, b));
		render("element/lmLookup.jsp");
	}
	/**
	 * 用于选择部门
	 * <br/>页面：/element/lmLookup.jsp
	 */
	public void treeBMLoop() {
		String a = getPara("a");
		String b = getPara("b");
		setAttr("treeStr", PageElement.getBMLookUp(a, b));
		render("element/lmLookup.jsp");
	}
	/**
	 * 用于选择部门
	 * <br/>页面：/element/lmLookup.jsp
	 */
	public void treeCpbbLoop() {
		String a = getPara("a");
		setAttr("treeStr", PageElement.getCpbbTree(a));
		render("element/lmLookup.jsp");
	}
	
	/**
	 * 用于选择条码打印方式
	 * <br/>页面：/element/DYLookup.jsp
	 */
	public void treeDYLoop() {
		String sql = "from barcodeconf where 1=1 ";
		String mc = getPara("mc");
		if (mc != null && !"".equals(mc))
			sql += " and mc like '%" + mc + "%' ";
		String gh = getPara("gh");
		if (gh != null && !"".equals(gh))
			sql += " and gh like '%" + gh + "%' ";	
		
		setAttr("page", BarcodeConf.dao.paginate(getParaToInt("pageNum", 1), getParaToInt("numPerPage", 20), " select * ",sql + " order by id desc "));
		render("element/dyLookup.jsp");
	}
	/**
	 * 用于选择物料
	 * <br/>页面：/element/lmLookup.jsp
	 */
	public void listWLLoop() {
		//String a = getPara("a");
		//String b = getPara("b");
		String sql;
		long count=Db.queryLong("select count(*) as count from jcxxmaterial where state=1");
		if (count!=0) {
			sql=" from jcxxmaterial where 1=1 and state=1";
		} else {
			sql=" from jcxxmaterial where 1=1 ";
		}
		String wlms=getPara("wlms");
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and wlms like '%"+wlms+"%'";	
		String wlh=getPara("wlh");
		if(wlh!=null&&!"".equals(wlh))
			sql+=" and wlh like '%"+wlh+"%'";
		setAttr("page", Material.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 10), " select * ", sql+" order by id desc"));
		render("element/wlLookup.jsp");
	}
	
	
	/**
	 * 用于选择产品
	 * <br/>页面：/element/cpLookup.jsp
	 */
	public void listCPLoop() {
		String sql=" from product p left join probbh pb on p.id=pb.fid  where 1=1 ";
		String selectSQL=" select p.wlh,p.wlms,pb.id,pb.bbh ";
		String wlm=getPara("wlm");
		if(wlm!=null&&!"".equals(wlm))
			sql+=" and wlm like '%"+wlm+"%'";	
		String wlh=getPara("wlh");
		if(wlh!=null&&!"".equals(wlh))
			sql+=" and wlh like '%"+wlh+"%'";
		setAttr("page", Product.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 10), selectSQL, sql+" order by id desc"));
		render("element/cpLookup.jsp");
	}
	
	/**
	 * 根据条码查找物料过滤测试模版
	 * <br/>页面：element/cpcsLookup.jsp
	 */
	public void listCPCSLoop() {
		//String a = getPara("a");
		//String b = getPara("b");
		String sql="from cpcssz where 1=1 ";
		String mc =getPara("mc");
		if(mc!=null&&!"".equals(mc))
			sql+=" and mc like '%"+mc+"%'";	
		String wlms=getPara("wlms");
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and wlm like '%"+wlms+"%'";	
		String wl=getPara("wl");
		if(wl!=null&&!"".equals(wl))
			sql+=" and wl like '%"+wl+"%'";
		setAttr("page", Cpcssz.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 10), " select * ", sql+" order by id desc"));
		render("element/cpcsLookup.jsp");
	}
	/**
	 * 用于修改密码
	 * <br/>弹出对话框
	 */
	public void changepwd() {
		String oldPassword = this.getPara("oldPassword");
		String newPassword = this.getPara("newPassword");
		String rnewPassword = this.getPara("rnewPassword");
		String dianhua = this.getPara("tel");
		Suser user0 = this.getSessionAttr("user");
		if (user0 == null || !MD5.toMD5(oldPassword.trim()).equals(user0.getStr("password"))) {
			setAttr("msg", "请正确输入用户帐号和密码！");
			render("login.jsp");
		} else {
			if (newPassword.equals(rnewPassword)) {
		    	   if(dianhua!=null&&"".equals(dianhua))
		    		   user0.set("tel", dianhua) ; 
				user0.set("password", MD5.toMD5(rnewPassword.trim())).update();
				renderText("{\"statusCode\":\"200\",\"message\":\"密码已重设！\",\"navTabId\":\"\",\"callbackType\":\"\",\"forwardUrl\":\"\"}");
			} else {
				renderText("{\"statusCode\":\"301\",\"message\":\"两次新密码不一致，请重设！\",\"navTabId\":\"\",\"callbackType\":\"\",\"forwardUrl\":\"\"}");
			}
		}

	}

}





