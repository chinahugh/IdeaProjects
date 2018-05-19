package com.zjkjsoft.controller;


import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.element.PageElement;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Indbind;
import com.zjkjsoft.model.JcxxIndent;
import com.zjkjsoft.model.ProBbh;
import com.zjkjsoft.model.Product;

/**
 * BindingController
 * 绑定配置
 */

@Before(ManagerPowerInterceptor.class)
public class BindingController extends BaseController {
	private static String path="/tmgl/binding/";//jsp路径
	//navTabId
	private static String navTabId="binding";
	
	@Override
	public String action() {
                      return  "绑定配置";
 }
	/**
	 * 订单抬头首页
	 * <br/>页面：/jcxx/indent/list.jsp
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
	
	private Page<JcxxIndent> getPageData()
	{
		String sql;
		String status=getPara("status1");
		long count=Db.queryLong("select count(*) as count from jcxxindent where state=1");
		if(status!=null&&!"".equals(status)) {
			if (count!=0) {
				sql=" from jcxxindent where 1=1 and state=1";
			} else {
				sql=" from jcxxindent where 1=1 ";
			}
			sql+=" and status like '%"+status+"%' ";	
		}else {
			if (count!=0) {
				sql=" from jcxxindent where status='未完成' and state=1";
			} else {
				sql=" from jcxxindent where status='未完成' ";
			}
		}
		String wlms=getPara("wlms");
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and wlms like '%"+wlms+"%' ";	
		String dd=getPara("dd");
		if(dd!=null&&!"".equals(dd))
			sql+=" and dd like '%"+dd+"%' ";	
		String mrpkzz=getPara("mrpkzz");
		if(mrpkzz!=null&&!"".equals(mrpkzz))
			sql+=" and mrpkzz like '%"+mrpkzz+"%' ";
		return JcxxIndent.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	
	/**
	 * 添加订单
	 * <br/>页面：/tmgl/binding/add.jsp
	 */
	public void add() {
		String dd=JcxxIndent.dao.findById(getParaToInt()).getStr("dd");
		Integer id=Db.queryInt(" select distinct fid from cpjc where dd=?", dd);//产品版本号id
		if (id!=null&&!"".equals(id)) {
			ProBbh probbh=ProBbh.dao.findById(id);
			Product product=Product.dao.findFirst("select wlh,wlms from product where id=?",probbh.get("fid"));
			setAttr("wlh", product.get("wlh"));
			setAttr("wlms", product.get("wlms"));
			setAttr("bbh", probbh.get("bbh"));
			setAttr("tree", PageElement.getTreeBom("select wlh,wlms,zj,zjms,bbh,fid from jcxxbom where fid="+probbh.get("fid")+" and bbh='"+probbh.get("bbh")+"' and wlh=? order by id",product.getStr("wlh"), "binding/list1/", "binding1","zj","bbh","zjms"));
		} else {
			setAttr("msg", "该订单没有绑定某一产品");
		}
		render(path+"add.jsp");
	}
	
	public void list1() {
		//Suser suser=this.getSessionAttr("user");
		//setAttr("flag", suser.getInt("rid"));
		String wlh=getPara(0);
		String fid=getPara(1);
		String bbh=getPara(2);
		int bid=Db.queryInt(" select id from probbh where fid=? and bbh=?",fid,bbh);
		String dd=Db.queryStr(" select distinct dd from cpjc where fid=?",bid);
		setAttr("dd", dd);
		String fwlh=Db.queryStr(" select wlh from product where id=?",fid);
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
		//toDwzJson(200, "删除成功！", "", 
		//		"", "binding", "");
		//this.renderText("{\"statusCode\":\"200\",\"message\":\"\\u64cd\\u4f5c\\u6210\\u529f\",\"navTabId\":\"binding\",\"rel\":\"binding1\",\"callbackType\":\"\",\"forwardUrl\":\"\",\"confirmMsg\":\"\"}");
		
	}
	
}


