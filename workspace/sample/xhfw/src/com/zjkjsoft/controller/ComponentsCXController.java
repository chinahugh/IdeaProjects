package com.zjkjsoft.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
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
public class ComponentsCXController extends BaseController {
	private static String path="/zhcx/components/";//jsp路径
	//navTabId
	private static String navTabId="componentsCX";
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
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	/**
	 * 模糊查询
	 */
	public void list() {
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	
	private Page<JcxxComponents> getPageData()
	{
		id=getParaToInt();
		String idd=JcxxIndent.dao.findFirst(" select * from jcxxindent where id=?", id).get("dd");
		String selectSQL=" SELECT *";
		String sql="FROM jcxxcomponents where dd="+idd;
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
		redirect(path+"add.jsp");
	}
	
	
	/**
	 * 保存数据到数据库
	 */
	@Before(RoleValidator.class)
	public void save() {

		try{
			JcxxComponents m=getModel(JcxxComponents.class);
			if(m.get("id")!=null){
				m.update();
toDwzJson(200,"修改操作成功",navTabId,"","closeCurrent");
			}else{
				//m.set("id", "js_seq.nextval");

				m.save();
toDwzJson(200,"新增操作成功",navTabId,"","closeCurrent");
			}
			//toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
		}catch(Exception e){
			toDwzJson( 300, "保存异常！",navTabId);
		}
	}
	
	/**
	 * 订单的修改 编辑
	 * <br/>页面：/scxx/components/add.jsp
	 */
	public void edit() {
		setAttr("jcxxcomponents", JcxxComponents.dao.findById(getParaToInt()));
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


