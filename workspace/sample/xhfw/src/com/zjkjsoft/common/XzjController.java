package com.zjkjsoft.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zjkjsoft.element.PageElement;
import com.zjkjsoft.element.WebElenment;
import com.zjkjsoft.model.BarcodeConf;
import com.zjkjsoft.model.Cpcssz;
import com.zjkjsoft.model.Cpjc;
import com.zjkjsoft.model.Cpjcjd;
import com.zjkjsoft.model.Cpjcjl;
import com.zjkjsoft.model.Cpjcxm;
import com.zjkjsoft.model.Fcpjc;
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
public class XzjController extends Controller {
	private static String path="/xzj/";//jsp路径
	/** 日期格式化为 yyyy年MM月dd日  的类*/
	public static SimpleDateFormat sfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static SimpleDateFormat sfday = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 跳转到 登录页面
	 * <br/>页面：/login.jsp
	 */
	public void index() {
           redirect(path+"login.jsp");
	}


	/**
	 * 登录：验证 验证码、用户名、密码 是否正确
	 * <br/>假如正确 跳转到 页面：/manage.jsp
	 * <br/>假如错误 跳转到 页面：/login.jsp
	 */
	public void manage() {
        String msg="";
		String username = this.getPara("yhid");
		String password = this.getPara("yhmm");
		if (username == null || "".equals(username) || password == null
				|| "".equals(password)) {
			msg= "请正确输入用户帐号和密码！";
			setAttr("msg",msg);
			setAttr("arletMsg", "alert('"+msg+"');");
			render(path+"login.jsp");
		} else {
			String sql1 = "select a.* ,b.lx ,b.mc from suser a ,srole b where a.rid=b.id  and  a.loginname='"
					+ username.trim()
					+ "' and a.password='"
					+ MD5.toMD5(password.trim())
					+ "' ";
			Suser user = Suser.dao.findFirst(sql1);
			if (user == null) {
				msg= "请正确输入用户帐号和密码！";
				setAttr("msg",msg);
				setAttr("arletMsg", "alert('"+msg+"');");
				render(path+"login.jsp");
			} else {
				this.setSessionAttr("user", user);
				this.setSessionAttr("username", user.getStr("username"));
				int lx=user.getInt("lx");
                if(lx==0) {
                	msg="您无小主机操作权限！";
                	setAttr("msg", msg);
                	setAttr("arletMsg", "alert('"+msg+"');");
                	render(path+"login.jsp");
                }else  if(lx==1) {//加工
                	redirect(path+"jiagong");
                }else  if(lx==2) {//测试
                	redirect(path+"ceshi");
                }else  if(lx==3) {//故障码检测
                	redirect(path+"jc1");
                }else  if(lx==4) {//检测项检测
                	redirect(path+"jc2");
                }else  if(lx==5) {//条码绑定
                	redirect(path+"bangding");
                }else  if(lx==6) {//条码绑定
                	redirect(path+"fbangding");
                }
				
			}
		}
		
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
     //加工
	/**
	 * 跳转到 加工页面
	 * <br/>页面：/jiagong.jsp
	 */
	public void jiagong() {
		String txm=this.getPara("txm");
		
		//条码查询 产品
		if(txm!=null) {
			//加工操作
			String  czm=this.getPara("czm");
			//条码查询 产品
			if(czm!=null&&!"".equals(czm)) {
				if("baocun".equals(czm)) {
					Suser user =getSessionAttr("user");
					Cpjcjl m=getModel(Cpjcjl.class);
					m.set("jcry", user.getStr("username"));
					m.set("jcrq", sfs.format(new Date()));
					//int xh=m.getInt("xh");
					//long x=Db.queryInt("select max(xh) from cpjcjd  where fid=? and lx=1",m.getInt("fid"));
					Cpjc  cpjc=getModel(Cpjc.class);
					Cpjcjd cpjcjd =Cpjcjd.dao.findFirst("select xh from cpjcjd  where lx=? and fid=? and jsmcs like '%"+user.getStr("mc")+"%'",1,m.getInt("fid"));
//					if(xh<x) {
//					   cpjc.set("xh", xh);
//					}else {
//						//m.set("xh", 1).set("lx", 3);
//						cpjc.set("xh", 1).set("lx", 2);
//					}
	
					m.set("xh", cpjcjd.getInt("xh")).set("lx", 1).set("state", 1).save();
					cpjc.set("xh", cpjcjd.getInt("xh")).set("lx", 1).set("jid", m.getInt("id")).update();
				}else if ("shanchu".equals(czm)) {
					int jid=Db.queryInt(" SELECT MAX(id) FROM cpjcjl WHERE and jcry=? ", getSessionAttr("username"));
					Cpjcjl.dao.deleteById(jid);
//					Cpjc cpjc=Cpjc.dao.findFirst(" select * from cpjc where jid=? ",jid);
//					if (cpjc!=null) {
//						cpjc.set("xh", 0).set("lx", 0).set("jid", 0).update();
//					}
				}
			}else {
			   Cpjc  cpjc= Cpjc.dao.findFirst("select * from cpjc  where state=1 and txm=?",txm);
			   if(cpjc!=null) {
			//根据条形码查找物料记录到那个检测点
			//根据检测项目节点及检测项目
				setAttr("cpjc", cpjc);
//				setAttr("product", Product.dao.findById(cpjc.getInt("fid")));
//				List<Cpjcxm> xmL= Cpjcxm.dao.find("select * from cpjcxm  where "
//						+ "fid=(select id from cpjcjd  where lx=1 and fid=? and xh=?)",cpjc.getInt("fid"),cpjc.getInt("xh"));
//				setAttr("xmL", xmL);
			   }
			}
		}

		//加工记录 select *  from  cpjcjl  where  jcrq>='2017-12-27  00:00:00' and  jcrq<='2017-12-27  23:59:59'  and jcry='管理员'
		String today=sfday.format(new Date());
		List<Cpjcjl> list =Cpjcjl.dao.find("select *  from  cpjcjl  where  jcrq>='"+today+"  00:00:00' and  jcrq<='"+today+"  23:59:59'  and jcry=? order by id desc", getSessionAttr("username"));
		setAttr("list", list);
		render(path+"jiagong.jsp");
	}
	//测试
	/**
	 * 跳转到 测试页面
	 * <br/>页面：/ceshi.jsp
	 */
	public void ceshi() {
		//条码查询 产品
		//测试文件上传
		//测试记录
		render(path+"ceshi.jsp");
	}
	//检测1
	/**
	 * 跳转到 检测1页面
	 * <br/>页面：/jc1.jsp
	 */
	public void jc1() {
		//条码查询 产品

		String txm=this.getPara("txm");
		
		//条码查询 产品
		if(txm!=null) {
			//故障码
			
			String  czm=this.getPara("czm");
			//条码查询 产品
			if(czm!=null&&!"".equals(czm))  {
				if ("shanchu".equals(czm)) {
					int jid=Db.queryInt(" SELECT MAX(id) FROM cpjcjl WHERE and jcry=? ", getSessionAttr("username"));
					Cpjcjl.dao.deleteById(jid);
//					Cpjc cpjc=Cpjc.dao.findFirst(" select * from cpjc where jid=? ",jid);
//					if (cpjc!=null) {
//						cpjc.set("xh", 0).set("lx", 0).set("jid", 0).update();
//					}
				}else {
					Suser user =getSessionAttr("user");
					Cpjcjl m=getModel(Cpjcjl.class);
					m.set("jcry", user.getStr("username"));
					m.set("jcrq", sfs.format(new Date()));
					m.set("mc", czm);
					m.set("ms", Db.queryStr("select  mc from scode  where fid=1 and  dm=?",czm));
					//int xh=m.getInt("xh");
					//long x=Db.queryInt("select max(xh) from cpjcjd  where fid=? and lx=1",m.getInt("fid"));
					Cpjc  cpjc=getModel(Cpjc.class);
					Cpjcjd cpjcjd =Cpjcjd.dao.findFirst("select xh from cpjcjd  where lx=? and fid=? and jsmcs like '%"+user.getStr("mc")+"%'",3,m.getInt("fid"));
//					if(xh<x) {
//					   cpjc.set("xh", xh);
//					}else {
//						//m.set("xh", 1).set("lx", 3);
//						cpjc.set("xh", 1).set("lx", 2);
//					}
	
					m.set("xh", cpjcjd.getInt("xh")).set("lx", 3).set("state", 1).save();
					cpjc.set("xh", cpjcjd.getInt("xh")).set("lx", 1).set("jid", m.getInt("id")).update();
				}
					
			}else {
			   Cpjc  cpjc= Cpjc.dao.findFirst("select * from cpjc  where state=1 and txm=?",txm);
			   if(cpjc!=null) {
			//根据条形码查找物料记录到那个检测点
			//根据检测项目节点及检测项目
				setAttr("cpjc", cpjc);
//				setAttr("product", Product.dao.findById(cpjc.getInt("fid")));
//				List<Cpjcxm> xmL= Cpjcxm.dao.find("select * from cpjcxm  where "
//						+ "fid=(select id from cpjcjd  where lx=1 and fid=? and xh=?)",cpjc.getInt("fid"),cpjc.getInt("xh"));
//				setAttr("xmL", xmL);
			   }
			}
		}

		////检测1记录  select *  from  cpjcjl  where  jcrq>='2017-12-27  00:00:00' and  jcrq<='2017-12-27  23:59:59'  and jcry='管理员'
		String today=sfday.format(new Date());
		List<Cpjcjl> list =Cpjcjl.dao.find("select *  from  cpjcjl  where  jcrq>='"+today+"  00:00:00' and  jcrq<='"+today+"  23:59:59'  and jcry=? order by id desc", getSessionAttr("username"));
		setAttr("list", list);
		render(path+"jc1.jsp");
	}
	//检测2
	/**
	 * 跳转到 检测2页面
	 * <br/>页面：/jc2.jsp
	 */
	public void jc2() {
		//条码查询 产品
		//检测项目
		//检测2记录
		String txm=this.getPara("txm");
		Suser user =getSessionAttr("user");
		//条码查询 产品
		if(txm!=null) {
			//故障码
			setAttr("jcs", 1);
			String czm=this.getPara("czm");
			//条码查询 产品
			if(czm!=null&&!czm.isEmpty()) {
				
					
					Cpjcjl m=getModel(Cpjcjl.class);
					m.set("jcry", user.getStr("username"));
					m.set("jcrq", sfs.format(new Date()));
					//m.set("mc", czm);
					//m.set("ms", Db.queryStr("select  mc from scode  where fid=1 and  dm=?",czm));
					Cpjc  cpjc=getModel(Cpjc.class);
					Cpjcjd cpjcjd =Cpjcjd.dao.findFirst("select xh from cpjcjd  where lx=? and fid=? and jsmcs like '%"+user.getStr("mc")+"%'",4,m.getInt("fid"));
                    if("baocun".equals(czm)) {
                    	String[] ks=getParaValues("ks");
                    	String[] vs=getParaValues("vs");
                    	if(vs==null) {
                    		redirect(path+"jc2.jsp");
                        	return;
                    	}
                    	for(int i=0;i<ks.length;i++) {
        					m.set("mc", ks[i]);
        					m.set("ms", vs[i]);
                    		m.set("xh", cpjcjd.getInt("xh")).set("lx", 4).set("state", 1).save();
                    		m.remove("id");
                    	}    	
                   
                    }else {
                    	redirect(path+"jc2.jsp");
                    	return;
                    }
	
					
					cpjc.set("xh", cpjcjd.getInt("xh")).set("lx", 1).set("jid", m.getInt("id")).update();
			
			}else {
			   Cpjc  cpjc= Cpjc.dao.findFirst("select * from cpjc  where state=1 and txm=?",txm);
			   if(cpjc!=null) {
			//根据条形码查找物料记录到那个检测点
			//根据检测项目节点及检测项目
				setAttr("cpjc", cpjc);
				setAttr("cpjcxm", Cpjcxm.dao.find("select * from cpjcxm where fid =(select id from cpjcjd where fid=?  and jsmcs like '%"+user.getStr("mc")+"%')",cpjc.get("fid")));
//				setAttr("product", Product.dao.findById(cpjc.getInt("fid")));
//				List<Cpjcxm> xmL= Cpjcxm.dao.find("select * from cpjcxm  where "
//						+ "fid=(select id from cpjcjd  where lx=1 and fid=? and xh=?)",cpjc.getInt("fid"),cpjc.getInt("xh"));
//				setAttr("xmL", xmL);
			   }
			}
		}

		////检测1记录  select *  from  cpjcjl  where  jcrq>='2017-12-27  00:00:00' and  jcrq<='2017-12-27  23:59:59'  and jcry='管理员'
		String today=sfday.format(new Date());
		List<Cpjcjl> list =Cpjcjl.dao.find("select *  from  cpjcjl  where  jcrq>='"+today+"  00:00:00' and  jcrq<='"+today+"  23:59:59'  and jcry=? order by id desc", getSessionAttr("username"));
		setAttr("list", list);
		render(path+"jc2.jsp");
	}
	//绑定
	/**
	 * 跳转到 绑定页面
	 * <br/>页面：/bangding.jsp
	 */
	public void bangding() {
		//条码查询 产品
		String txm=this.getPara("txm");		
		//条码查询 产品
		if(txm!=null) {
			//绑定码			
			String  czm=this.getPara("czm");
			//条码查询 产品
			if(czm!=null&&!"".equals(czm))  {
				if ("shanchu".equals(czm)) {
					int jid=Db.queryInt(" SELECT MAX(id) FROM cpjcjl WHERE and jcry=? ", getSessionAttr("username"));
					Cpjcjl.dao.deleteById(jid);
//					Cpjc cpjc=Cpjc.dao.findFirst(" select * from cpjc where jid=? ",jid);
//					if (cpjc!=null) {
//						cpjc.set("xh", 0).set("lx", 0).set("jid", 0).update();
//					}
				}else {
					//判断是否可以绑定
					String wlh =Db.queryStr("select a.wlh   from indbind a,cpjc b ,cpjc c " + 
							"where a.fid=b.fid and a.fwlh=b.wlh and a.dd=b.dd " + 
							"and  a.fid=c.fid and a.wlh=c.wlh and a.dd=c.dd " + 
							"and  b.txm=? and  c.txm=?",txm,czm);
					if(wlh==null) {
						setAttr("msg", "此产品条码和关键件条码类型不符不能绑定！");
					}else {
					Suser user =getSessionAttr("user");
					Cpjcjl m=getModel(Cpjcjl.class);
					m.set("jcry", user.getStr("username"));
					m.set("jcrq", sfs.format(new Date()));
					m.set("mc", czm);
					m.set("ms", wlh);
					//int xh=m.getInt("xh");
					//long x=Db.queryInt("select max(xh) from cpjcjd  where fid=? and lx=1",m.getInt("fid"));
					Cpjc  cpjc=getModel(Cpjc.class);
					Cpjcjd cpjcjd =Cpjcjd.dao.findFirst("select xh from cpjcjd  where lx=? and fid=? and jsmcs like '%"+user.getStr("mc")+"%'",5,m.getInt("fid"));
					m.set("xh", cpjcjd.getInt("xh")).set("lx", 5).set("state", 1).save();
					cpjc.set("xh", cpjcjd.getInt("xh")).set("lx", 5).set("jid", m.getInt("id")).update();
				}
				}
					
			}else {
			   Cpjc  cpjc= Cpjc.dao.findFirst("select * from cpjc  where state=1 and txm=?",txm);
			   if(cpjc!=null) {
			//根据条形码查找物料记录到那个检测点
			//根据检测项目节点及检测项目
				setAttr("cpjc", cpjc);
//				setAttr("product", Product.dao.findById(cpjc.getInt("fid")));
//				List<Cpjcxm> xmL= Cpjcxm.dao.find("select * from cpjcxm  where "
//						+ "fid=(select id from cpjcjd  where lx=1 and fid=? and xh=?)",cpjc.getInt("fid"),cpjc.getInt("xh"));
//				setAttr("xmL", xmL);
			   }
			}
		}

		////检测1记录  select *  from  cpjcjl  where  jcrq>='2017-12-27  00:00:00' and  jcrq<='2017-12-27  23:59:59'  and jcry='管理员'
		String today=sfday.format(new Date());
		List<Cpjcjl> list =Cpjcjl.dao.find("select *  from  cpjcjl  where  jcrq>='"+today+"  00:00:00' and  jcrq<='"+today+"  23:59:59'  and jcry=? order by id desc", getSessionAttr("username"));
		setAttr("list", list);
		render(path+"bangding.jsp");
	}
	//防伪绑定
		/**
		 * 跳转到 防伪绑定页面
		 * <br/>页面：/fbangding.jsp
		 */
	public void fbangding() {
		Fcpjc m=getModel(Fcpjc.class);
		if(m.get("ftxm")!=null&&!"".equals(m.get("ftxm"))){
			if (m.get("btxm")!=null&&!"".equals(m.get("btxm"))) {
				Cpjc c=Cpjc.dao.findFirst(" select dd,wlh,wlm,fid from cpjc where txm=?", m.get("btxm"));
				if (m.get("dd").equals(c.get("dd"))&&m.get("wlh").equals(c.get("wlh"))&&m.get("fid").equals(c.get("fid"))) {
					m.set("bdr", this.getSessionAttr("username")).set("bdrq", IndexController.sfymdhms.format(new Date())).set("state", 1).update();
				}else {
					setAttr("msg","防伪码与产品条码不匹配");
				}
			}else {
				Fcpjc fcpjc=Fcpjc.dao.findFirst(" select * from fcpjc where ftxm=?", m.getStr("ftxm"));
				setAttr("fcpjc", fcpjc);
			}
		}
		String today=sfday.format(new Date());
		List<Fcpjc> list=Fcpjc.dao.find(" select id,ftxm,dd,wlh,wlm,btxm,bdrq from fcpjc where bdr='"+this.getSessionAttr("username")+"' and "
				+ "  bdrq>='"+today+" 00:00:00' and bdrq<='"+today+" 23:59:59' ");
		setAttr("list", list);
		render(path+"fbangding.jsp");
	}
}





