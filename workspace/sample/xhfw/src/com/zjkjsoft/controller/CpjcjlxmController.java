package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Scode;
import com.zjkjsoft.model.Sorg;
import com.zjkjsoft.model.Srole;
import com.zjkjsoft.validator.RoleValidator;

/**
 * RoleController
 * 角色管理
 */

@Before(ManagerPowerInterceptor.class)
public class CpjcjlxmController extends BaseController {
	private static String path="/xtgl/role/";//jsp路径
	//navTabId
	private static String navTabId="srole";
	private static String key="mc";//查询关键字字段名
	
	@Override
	public String action() {
                      return  "角色管理";
 }
	/**
	 * 角色管理首页
	 * <br/>页面：/xtgl/role/list.jsp
	 */
	@Override
	public void index() {
		String keywords=getPara("keywords");
		String sql="from srole  order by id desc";
		if(keywords!=null&&!"".equals(keywords))
			sql="from srole where "+key+" like '%"+keywords+"%' order by id desc";	
		setAttr("page", Srole.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql));
		render(path+"list.jsp");
	}
	/**
	 * 模糊查询
	 */
	public void list() {
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	
	private Page<Srole> getPageData()
	{
		String keywords=getPara("keywords");
		String sql="from srole  order by id desc";
		if(keywords!=null&&!"".equals(keywords))
			sql="from srole where "+key+" like '%"+keywords+"%' order by id desc";	
		return Srole.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql);
	}
	/**
	 * 查看
	 * <br/>页面：/xtgl/role/view.jsp
	 */
	public void view() {
		setAttr("srole", Srole.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加角色
	 * <br/>页面：/xtgl/role/add.jsp
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
			Srole m=getModel(Srole.class);
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
	 * 角色的修改 编辑
	 * <br/>页面：/xtgl/role/add.jsp
	 */
	public void edit() {
		setAttr("srole", Srole.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Srole.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Srole> data=getPageData().getList();
		String[] columns = {"mc","ms"};
		String[] heades = {"名称","描述"};
		String filename = new String("角色管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

}


