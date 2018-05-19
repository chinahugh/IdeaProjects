package com.zjkjsoft.controller;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Cpjc;
import com.zjkjsoft.model.JcxxComponents;
import com.zjkjsoft.model.JcxxIndent;
import com.zjkjsoft.util.BarcodeUtil;

/**
 * BarcodeController 条码查看
 */

@Before(ManagerPowerInterceptor.class)
public class BarcodeZJListController extends BaseController {
	private static String path = "/tmgl/barcodezjlist/";// jsp路径
	// navTabId
	private static String navTabId = "barcodezjlist";
	private static String key = "mc";// 查询关键字字段名

	@Override
	public String action() {
		return "条码查看";
	}

	/**
	 * 条码管理首页 <br/>
	 * 页面：/tmgl/barcodezjlist/list.jsp
	 */
	@Override
	public void index() {
		setAttr("page", getPageData());
		render(path + "list.jsp");
	}

	/**
	 * 模糊查询
	 */
	public void list() {
		setAttr("page", getPageData());
		render(path + "list.jsp");
	}

	private Page<Cpjc> getPageData() {
		JcxxComponents jc = JcxxComponents.dao.findById(getParaToInt());//由订单id获取订单号
		String sql = " from(SELECT id,txm,dd,wlh,fid,fs,wlm,state,scrq from cpjc where dd='"+jc.getStr("dd")+"'  and wlh='"+jc.getStr("wlh")+"'";
		String tm = getPara("tm");
		if (tm != null && !"".equals(tm))
			sql += " and txm like '%" + tm + "%' ";
		String tmfs = getPara("tmfs");
		if (tmfs != null && !"".equals(tmfs))
			sql += " and fs like '%" + tmfs + "%' ";
		String scrq = getPara("scrq");
		if (scrq != null && !"".equals(scrq))
			sql += " and txm like '%" + scrq + "%' ";
		String state = getPara("state");
		if (state != null && !"".equals(state))
			sql += " and state like '%" + state + "%' ";
		return Cpjc.dao.paginate(getParaToInt("pageNum", 1), getParaToInt("numPerPage", 20), " select a.scrq,a.id,a.txm,a.dd,a.wlh,b.bbh,a.fs,a.wlm,a.state  ",
				sql + ")a LEFT JOIN probbh b on b.id=a.fid  order by txm desc ");
	}

	/**
	 * 查看 <br/>
	 * 页面：/tmgl/barcodezjlist/view.jsp
	 */
	public void view() {
		setAttr("cpjc", Cpjc.dao.findById(getParaToInt()));
		render(path + "view.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		for (int id : getParaValuesToInt("ids")) {
			Cpjc.dao.deleteById(id);
		}		
		toDwzJson( 200, "删除成功！", navTabId);
	}
	/**
	 * 
	 */
	public void printconf() {
		String sql="from cpjc where  id in (";
		String ids=BarcodeUtil.display2(getParaValues("ids"));
		setAttr("ids", ids);
		setAttr("page", Cpjc.dao.paginate(getParaToInt("pageNum", 1), getParaToInt("numPerPage", 5), " select txm ",
				sql+ids+ ") order by id desc "));
		render(path + "print.jsp");
	}

	public void state() {		
		System.out.println("ids"+getPara("ids"));
		Cpjc.dao.stateid(getPara("ids"));
		this.renderText("{\"statusCode\":\"200\"}");
	}
}
