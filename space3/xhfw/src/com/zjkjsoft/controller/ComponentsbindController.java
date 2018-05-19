package com.zjkjsoft.controller;


import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.element.PageElement;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Indbind;
import com.zjkjsoft.model.JcxxComponents;
import com.zjkjsoft.model.JcxxIndent;
import com.zjkjsoft.model.ProBbh;

/**
 * ComponentsbindController
 * 组件绑定配置
 */

@Before(ManagerPowerInterceptor.class)
public class ComponentsbindController extends BaseController {
	private static String path="/tmgl/componentsbind/";//jsp路径
	//navTabId
	private static String navTabId="componentsbind";
	private static int id;
	
	@Override
	public String action() {
                      return  "组件绑定配置";
 }
	/**
	 * 订单组件首页
	 * <br/>页面：/tmgl/componentsbind/list.jsp
	 */
	@Override
	public void index() {
		//Suser suser=this.getSessionAttr("user");
		//setAttr("flag", suser.getInt("rid"));
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	/**
	 * 模糊查询
	 */
	public void list() {
		//Suser suser=this.getSessionAttr("user");
		//setAttr("flag", suser.getInt("rid"));
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	
	private Page<JcxxComponents> getPageData()
	{
		id=getParaToInt();
		String idd=JcxxIndent.dao.findFirst(" select * from jcxxindent where state=1 and id=?", id).get("dd");
		setAttr("dd", idd);
		String selectSQL=" SELECT *";
		String sql;
		long count=Db.findFirst("select count(*) as count from components where state=1 and dd=?",idd).getLong("count");
		if (count!=0) {
			sql=" from jcxxcomponents where 1=1 and state=1 and dd='"+idd+"'";
		} else {
			sql=" from jcxxcomponents where 1=1 and dd='"+idd+"'";
		}
		String wlms=getPara("wlms");
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and wlms like '%"+wlms+"%' ";	
		String wlh=getPara("wlh");
		if(wlh!=null&&!"".equals(wlh))
			sql+=" and wlh like '%"+wlh+"%' ";	
		return JcxxComponents.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), selectSQL, sql+" order by id desc ");
	}

	/**
	 * 添加订单
	 * <br/>页面：/tmgl/componentsbind/add.jsp
	 */
	public void add() {
		JcxxComponents jcxxcomponents=JcxxComponents.dao.findById(getParaToInt());
		String wlh=jcxxcomponents.getStr("wlh");
		this.setSessionAttr("fwlh", wlh);
		String dd=jcxxcomponents.getStr("dd");
		Integer id=Db.queryInt(" select distinct fid from cpjc where dd=?", dd);
		if (id!=null&&!"".equals(id)) {
			ProBbh probbh=ProBbh.dao.findById(id);
			String wlms=Db.queryStr(" select distinct wlms from jcxxbom where fid=? and bbh=? and wlh=? ",probbh.get("fid"),probbh.get("bbh"),wlh);
			if (wlms!=null&&!"".equals(wlms)) {
				setAttr("wlh", wlh);
				setAttr("wlms", wlms);
				setAttr("bbh", probbh.get("bbh"));
				setAttr("tree", PageElement.getTreeBom("select wlh,wlms,zj,zjms,bbh,fid from jcxxbom where fid="+probbh.get("fid")+" and bbh='"+probbh.get("bbh")+"' and wlh=? order by id",wlh, "componentsbind/list1/", "componentsbind1","zj","bbh","zjms"));
			} else {
				setAttr("msg", "该组件没有对应BOM");
			}
		}else {
			setAttr("msg", "该组件对应的订单没有绑定产品");
		}
		render(path+"add.jsp");
	}
	
	/**
	 * 模糊查询
	 */
	public void list1() {
		//Suser suser=this.getSessionAttr("user");
		//setAttr("flag", suser.getInt("rid"));
		String wlh=getPara(0);
		String fid=getPara(1);
		String bbh=getPara(2);
		int bid=Db.queryInt(" select id from probbh where fid=? and bbh=?",fid,bbh);
		String dd=Db.queryStr(" select distinct dd from cpjc where fid=?",bid);
		setAttr("dd", dd);
		String fwlh=this.getSessionAttr("fwlh");
		setAttr("fwlh", fwlh);
		Indbind indbind=new Indbind();
		Indbind ind=Indbind.dao.findFirst(" select * from indbind where wlh=? and dd=? and fid=? and fwlh=?" ,wlh,dd,bid,fwlh);
		if (ind!=null) {
			setAttr("msg", "该物料已绑定过");
		}else {
			indbind.set("dd", dd).set("fwlh", fwlh).set("wlh", wlh).set("fid", bid).save();
		}
		setAttr("page", getPageData1(dd,fwlh));
		render(path+"list1.jsp");
	}
	
	private Page<Indbind> getPageData1(String dd,String fwlh)
	{
		String sql=" from indbind where dd='"+dd+"' and fwlh='"+fwlh+"'";
		String wlh=getPara("wlh");
		if(wlh!=null&&!"".equals(wlh))
			sql+=" and wlh like '%"+wlh+"%' ";	
		return Indbind.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	
	public void list2() {
		String dd=getPara(0);
		String fwlh=getPara(1);
		setAttr("page", getPageData1(dd,fwlh));
		setAttr("dd", dd);
		setAttr("fwlh", fwlh);
		render(path+"list1.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Indbind.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
}


