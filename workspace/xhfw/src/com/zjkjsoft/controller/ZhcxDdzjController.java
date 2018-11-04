package com.zjkjsoft.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.JcxxComponents;
import com.zjkjsoft.model.JcxxIndent;
import com.zjkjsoft.util.ImportExcel;
import com.zjkjsoft.validator.RoleValidator;

/**
 * JcxxComponentsController
 * 订单组件
 */

@Before(ManagerPowerInterceptor.class)
public class ZhcxDdzjController extends BaseController {
	private static String path="/zhcx/ddzj/";//jsp路径
	//navTabId
	private static String navTabId="zhcxddzj";
	private  int id;
	
	@Override
	public String action() {
                      return  "订单组件";
 }
	/**
	 * 订单组件首页
	 * <br/>页面：/jcxx/components/list.jsp
	 */
	@Override
	public void index() {
		setAttr("page", getPageData());
		render(path+"index.jsp");
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
		String dd=getPara("dd");
		if(dd!=null&&!"".equals(dd))
			sql+=" and dd like '%"+dd+"%' ";		
		String ddlx=getPara("ddlx");
		if(ddlx!=null&&!"".equals(ddlx))
			sql+=" and ddlx like '%"+ddlx+"%' ";		
		String mrpkzz=getPara("mrpkzz");
		if(mrpkzz!=null&&!"".equals(mrpkzz))
			sql+=" and mrpkzz like '%"+mrpkzz+"%' ";		
		return JcxxIndent.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	public void list0() {
		setAttr("page", getPageData());
		render(path+"list0.jsp");
	}
	/**
	 * 模糊查询
	 */
	public void list1() {
		setAttr("page", getPageData1());
		render(path+"list1.jsp");
	}
	
	private Page<JcxxComponents> getPageData1()
	{
		id=getParaToInt();
		setAttr("fid", id);
		String idd=JcxxIndent.dao.findFirst(" select * from jcxxindent where id=?", id).get("dd");
		String selectSQL=" SELECT *";
		String sql;
		long count=Db.queryLong("select count(*) from jcxxcomponents where state=1");
		if (count!=0) {
			sql="from jcxxcomponents where state=1 and dd="+idd;
		}else {
			sql="from jcxxcomponents where 1=1 and dd="+idd;
		}
		String wlms=getPara("wlms");
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and wlms like '%"+wlms+"%' ";	
		String wl=getPara("wl");
		if(wl!=null&&!"".equals(wl))
			sql+=" and wl like '%"+wl+"%' ";	
		String xmzj=getPara("xmzj");
		if(xmzj!=null&&!"".equals(xmzj))
			sql+=" and xmzj like '%"+xmzj+"%' ";	
		String syxq=getPara("syxq");
		if(syxq!=null&&!"".equals(syxq))
			sql+=" and syxq like '%"+syxq+"%' ";	
		return JcxxComponents.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), selectSQL, sql+" order by id desc ");
	}
}


