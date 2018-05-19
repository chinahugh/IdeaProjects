package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;


import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;

import com.jfinal.plugin.activerecord.Page;

import com.zjkjsoft.element.PageElement;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;

import com.zjkjsoft.model.Cpjcjd;

import com.zjkjsoft.validator.RoleValidator;


/**
 * CpjcjdController
 * 检测工序节点
 */

@Before(ManagerPowerInterceptor.class)
public class CpjcjdController extends BaseController {
	private static String path="/xtpz/cpjcjd/";//jsp路径
	//navTabId
	private static String navTabId="cpjcjd";
	private static String key="mc";//查询关键字字段名
	@Override
	public String action() {
                      return  "检测工序节点";
 }
	
	/**
	 * 到 角色菜单的首页
	 * <br/>页面：/xtgl/rolfun/index.jsp
	 */
	@Override
	public void index() {
		setAttr("treeJSStr", Cpjcjd.getTree2("cpjcjd/list/","cpjdBox", "mc"));
		//setAttr("treeJSStr", PageElement.getTreeC1("select id,mc from cpjcgx where  id>? order by xh ,id ", Integer.valueOf(0), "cpjcjd/list/","cpjdBox", "mc"));
		render(path+"index.jsp");
	}
	
	/**
	 * 模糊查询
	 */
	public void list() {
		setAttr("fid", getParaToInt());
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	
	private Page<Cpjcjd> getPageData()
	{
		String keywords=getPara("keywords");
		String sql="from cpjcjd  where fid ="+getParaToInt();
		if(keywords!=null&&!"".equals(keywords))
			sql+=" and  "+key+" like '%"+keywords+"%'";	
		return Cpjcjd.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc");
	}
	/**
	 * 查看
	 * <br/>页面：/xtgl/role/view.jsp
	 */
	public void view() {
		setAttr("fid", getParaToInt());
		setAttr("cpjcjd", Cpjcjd.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加角色
	 * <br/>页面：/xtgl/role/add.jsp
	 */
	public void add() {
		setAttr("fid", getParaToInt());
		render(path+"add.jsp");
	}
	
	
	/**
	 * 保存数据到数据库
	 */
	public void save() {

		try{
			Cpjcjd m=getModel(Cpjcjd.class);
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
			e.printStackTrace();
			toDwzJson( 300, "保存异常！",navTabId);
		}
	}
	
	/**
	 * 角色的修改 编辑
	 * <br/>页面：/xtgl/role/add.jsp
	 */
	public void edit() {		
		setAttr("cpjcjd", Cpjcjd.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Cpjcjd.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Cpjcjd> data=getPageData().getList();
		String[] columns = {"mc","ms"};
		String[] heades = {"名称","描述"};
		String filename = new String("角色管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

}


