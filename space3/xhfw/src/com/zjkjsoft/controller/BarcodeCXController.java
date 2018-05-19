package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.jfinal.aop.Before;

import com.jfinal.ext.render.excel.PoiRender;

import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;

import com.zjkjsoft.model.Cpjc;
import com.zjkjsoft.model.Cpjcjl;
import com.zjkjsoft.validator.RoleValidator;

/**
 * BarcodeCXController
 * 条码查询
 */

@Before(ManagerPowerInterceptor.class)
public class BarcodeCXController extends BaseController {
	private static String path="/zhcx/barcode/";//jsp路径
	//navTabId
	private static String navTabId="barcodeCX";

	
	@Override
	public String action() {
                      return  "条码查询";
 }
	/**
	 * 条码
	 * <br/>页面：/tmgl/barcode2/list.jsp
	 */
	@Override
	public void index() {
		
		String sql=" from cpjc where 1=1 ";
		String txm=getPara("txm");
		if(txm!=null&&!"".equals(txm))
			sql+=" and txm like '%"+txm+"%' ";	
		String wlh=getPara("wlh");
		if(wlh!=null&&!"".equals(wlh))
			sql+=" and wlh like '%"+wlh+"%' ";
		String wlm=getPara("wlm");
		if(wlm!=null&&!"".equals(wlm))
			sql+=" and wlm like '%"+wlm+"%' ";
		String fid=getPara("fid");
		if(fid!=null&&!"".equals(fid))
			sql+=" and fid ="+fid+"";
		String dd=getPara("dd");
		if(dd!=null&&!"".equals(dd))
			sql+=" and dd like '%"+dd+"%' ";
		setAttr("page", Cpjc.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc"));
		render(path+"list.jsp");
	}
	/**
	 * 条码记录查询
	 */
	public void list() {
		String sql=" from cpjcjl where 1=1 ";
		String txm=getPara("txm");
		if(txm!=null&&!"".equals(txm))
			sql+=" and txm = '"+txm+"' ";	
		String lx=getPara("lx");
		if(lx!=null&&!"".equals(lx))
			sql+=" and lx = "+lx+" ";	
		String jcry=getPara("jcry");
		if(jcry!=null&&!"".equals(jcry))
			sql+=" and jcry like '%"+jcry+"%' ";
		String kssj=getPara("kssj");
		if(kssj!=null&&!"".equals(kssj))
			sql+=" and jcrq >='"+kssj+"'";
		String jssj=getPara("jssj");
		if(jssj!=null&&!"".equals(jssj))
			sql+=" and jcrq <='"+jssj+"'";
		setAttr("page", Cpjcjl.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id "));
		render(path+"list1.jsp");
	}
	

	


}


