package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.zjkjsoft.common.IndexController;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.JcxxComponents;
import com.zjkjsoft.model.JcxxIndent;

/**
 * JcxxComponentsController
 * 订单组件
 */

@Before(ManagerPowerInterceptor.class)
public class JcxxComponentsController extends BaseController {
	private static String path="/jcxx/jcxxcomponents/";//jsp路径
	//navTabId
	private static String navTabId="jcxxcomponents";
	private static int id;
	
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
		long count=Db.findFirst("select count(*) as count from components where state=1").getLong("count");
		if (count!=0) {
			sql=" from jcxxcomponents where 1=1 and state=1 and dd="+idd;
		} else {
			sql=" from jcxxcomponents where 1=1 and dd="+idd;
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
	 * 查看
	 * <br/>页面：/jcxx/components/view.jsp
	 */
	public void view() {
		setAttr("jcxxcomponents", JcxxComponents.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加订单
	 * <br/>页面：/jcxx/components/add.jsp
	 */
	public void add() {
		String dd=getPara();
		JcxxComponents jcxxComponents=new JcxxComponents();
		jcxxComponents.set("dd", dd);
		setAttr("jcxxComponents",jcxxComponents);
		render(path+"add.jsp");
	}
	
	
	/**
	 * 保存数据到数据库
	 */
	public void save() {
		String date=IndexController.sfymdhms.format(new Date());
		try{
			JcxxComponents m=getModel(JcxxComponents.class);
			if(m.get("id")!=null){
				Db.update(" update jcxxcomponents set state=0 where id=?", (Record) m.get("id"));
				Db.update(" INSERT INTO jcxxcomponents(dd,wl,xmzj,xqrq,xqsl,chsl,wlms,syxq,state,date)  VALUES (?,?,?,?,?,?,?,?,?,?) " 
				,m.get("dd"),m.get("wl"),m.get("xmzj"),m.get("xqrq"),m.get("xqsl"),m.get("chsl"),m.get("wlms"),m.get("syxq"),1,date);
toDwzJson(200,"修改操作成功",navTabId,"","closeCurrent");
			}else{
				//m.set("id", "js_seq.nextval");
				m.set("date", date);
				m.set("state", 1);
				m.save();
toDwzJson(200,"新增操作成功",navTabId,"","closeCurrent");
			}
			//toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
		}catch(Exception e){
			e.printStackTrace();
			toDwzJson( 300, "保存异常！",navTabId);
		}
	}
	
	/**
	 * 订单的修改 编辑
	 * <br/>页面：/scxx/components/add.jsp
	 */
	public void edit() {
		setAttr("jcxxComponents", JcxxComponents.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		JcxxComponents.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<JcxxComponents> data=getPageData().getList();
		String[] columns = {"dd","wl","xmzj","xqrq","xqsl","chsl","wlms","syxq"};
		String[] heades = {"订单","物料","项目组件","需求日期","需求数量","撤回数量","物料描述","溯源需求"};
		String filename = new String("订单组件.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}
	
}


