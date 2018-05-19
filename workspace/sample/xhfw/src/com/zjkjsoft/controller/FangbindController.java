package com.zjkjsoft.controller;


import java.util.Date;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.common.IndexController;
import com.zjkjsoft.element.PageElement;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Barcode;
import com.zjkjsoft.model.Cpjc;
import com.zjkjsoft.model.Fcpjc;
import com.zjkjsoft.model.Indbind;
import com.zjkjsoft.model.JcxxIndent;
import com.zjkjsoft.model.ProBbh;
import com.zjkjsoft.model.Product;

/**
 * FangbindController
 * 防伪绑定
 */

@Before(ManagerPowerInterceptor.class)
public class FangbindController extends BaseController {
	private static String path="/tmgl/fangbind/";//jsp路径
	//navTabId
	private static String navTabId="fangbind";
	
	@Override
	public String action() {
                      return  "防伪绑定";
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
	
	private Page<Fcpjc> getPageData()
	{
		String today=IndexController.sfymd.format(new Date());
		String sql=" from fcpjc where bdr='"+this.getSessionAttr("username")+"' and "
				+ " bdrq>='"+today+" 00:00:00' and "
				+ " bdrq<='"+today+" 23:59:59' ";
		String selectSQL=" select id,ftxm,dd,wlh,wlm,btxm,bdrq ";
		String ftxm=getPara("ftxm");
		if(ftxm!=null&&!"".equals(ftxm))
			sql+=" and ftxm like '%"+ftxm+"%' ";	
		String dd=getPara("dd");
		if(dd!=null&&!"".equals(dd))
			sql+=" and dd like '%"+dd+"%' ";	
		String wlh=getPara("wlh");
		if(wlh!=null&&!"".equals(wlh))
			sql+=" and wlh like '%"+wlh+"%' ";	
		return Fcpjc.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), selectSQL, sql+" order by id desc ");
	}
	
	/**
	 * 添加订单
	 * <br/>页面：/tmgl/fangbind/add.jsp
	 */
	public void add() {
		redirect(path+"add.jsp");
	}
	
	public void save() {
		try{
			Fcpjc m=getModel(Fcpjc.class);
			Cpjc c=getModel(Cpjc.class);
			if(m.get("ftxm")!=null&&!"".equals(m.get("ftxm"))){
				if (m.get("btxm")!=null&&!"".equals(m.get("btxm"))) {
					if (c.get("wlh")!=null&&!"".equals(c.get("wlh"))) {
						if (m.get("dd").equals(c.get("dd"))&&m.get("wlh").equals(c.get("wlh"))&&m.get("fid").equals(c.get("fid"))) {
							m.set("bdr", this.getSessionAttr("username")).set("bdrq", IndexController.sfymdhms).set("state", 1).update();
							toDwzJson(200,"绑定成功",navTabId,"","closeCurrent");
							return;
						}else {
							toDwzJson(200,"防伪码与产品条码不匹配",navTabId,"","closeCurrent");
							return;
						}
					}else {
						Cpjc cpjc=Cpjc.dao.findFirst(" select dd,wlh,wlm,fid from cpjc where txm=?", m.get("btxm"));
						setAttr("cpjc", cpjc);
						setAttr("fcpjc", m);
					}
				}else {
					Fcpjc fcpjc=Fcpjc.dao.findFirst(" select * from fcpjc where ftxm=?", m.getStr("ftxm"));
					setAttr("fcpjc", fcpjc);
				}
			}
			render(path+"add.jsp");
		}catch(Exception e){
			toDwzJson( 300, "绑定异常！",navTabId);
		}
	}
	
	
	/**
	 * 删除
	 */
	public void delete() {
		Fcpjc fcpjc=Fcpjc.dao.findById(getParaToInt());
		fcpjc.set("btxm", "").update();
		toDwzJson( 200, "删除成功！", navTabId);
		//toDwzJson(200, "删除成功！", "", 
		//		"", "binding", "");
		//this.renderText("{\"statusCode\":\"200\",\"message\":\"\\u64cd\\u4f5c\\u6210\\u529f\",\"navTabId\":\"binding\",\"rel\":\"binding1\",\"callbackType\":\"\",\"forwardUrl\":\"\",\"confirmMsg\":\"\"}");
		
	}
	
}


