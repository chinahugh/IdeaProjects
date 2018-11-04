package com.zjkjsoft.controller;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Cpjc;
import com.zjkjsoft.model.Fcpjc;
import com.zjkjsoft.model.JcxxIndent;
import com.zjkjsoft.util.BarcodeUtil;

/**
 * BarcodeController 防伪条码查看
 */

@Before(ManagerPowerInterceptor.class)
public class BarcodeFWListController extends BaseController {
	private static String path = "/tmgl/barcodefwlist/";// jsp路径
	// navTabId
	private static String navTabId = "barcodefwlist";
	private static String key = "mc";// 查询关键字字段名

	@Override
	public String action() {
		return "防伪条码查看";
	}

	/**
	 * 条码管理首页 <br/>
	 * 页面：/tmgl/barcodefwlist/list.jsp
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

	private Page<Fcpjc> getPageData() {
		JcxxIndent jc = JcxxIndent.dao.findById(getParaToInt());//由订单id获取订单号
		String sql = " from (SELECT id,scrq,ftxm,dd,wlh,fid,fs,wlm,btxm ,state from fcpjc where dd='"+jc.getStr("dd")+"'  and wlh='"+jc.getStr("wl")+"'";
		String tm = getPara("tm");
		if (tm != null && !"".equals(tm))
			sql += " and ftxm like '%" + tm + "%' ";
		String tmfs = getPara("tmfs");
		if (tmfs != null && !"".equals(tmfs))
			sql += " and fs like '%" + tmfs + "%' ";
		String scrq = getPara("scrq");
		if (scrq != null && !"".equals(scrq))
			sql += " and scrq like '%" + scrq + "%' ";
		String state = getPara("state");
		if (state != null && !"".equals(state))
			sql += " and state like '%" + state + "%' ";
		return Fcpjc.dao.paginate(getParaToInt("pageNum", 1), getParaToInt("numPerPage", 20), " select a.state,a.scrq,a.id,a.ftxm,a.dd,a.wlh,b.bbh,a.fs,a.wlm,a.btxm ",
				sql + ")a LEFT JOIN probbh b on b.id=a.fid  order by ftxm desc ");
	}

	/**
	 * 查看 <br/>
	 * 页面：/tmgl/barcodefwlist/view.jsp
	 */
	public void view() {
		setAttr("jcxxindent", JcxxIndent.dao.findById(getParaToInt()));
		render(path + "view.jsp");
	}
	
	/**
	 * 
	 */
	public void printconf() {
		String sql="from fcpjc where  id in (";
		String ids=BarcodeUtil.display2(getParaValues("ids"));
		
		setAttr("ids", ids);
		setAttr("page", Fcpjc.dao.paginate(getParaToInt("pageNum", 1), getParaToInt("numPerPage", 5), " select ftxm ",
				sql+ids + ") order by id desc "));
		render(path + "print.jsp");
	}
	/**
	 * 删除
	 */
	public void delete() {
		for (int id : getParaValuesToInt("ids")) {
			Fcpjc.dao.deleteById(id);
		}		
		toDwzJson( 200, "删除成功！", navTabId);
	}
	

	public void state() {		
		Fcpjc.dao.stateid(getPara("ids"));
		this.renderText("{\"statusCode\":\"200\"}");
	}
}
