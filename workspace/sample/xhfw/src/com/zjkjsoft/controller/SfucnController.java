package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Sfucn;
import com.zjkjsoft.validator.FucnValidator;

/**
 * 系统菜单
 */

@Before(ManagerPowerInterceptor.class)
public class SfucnController extends BaseController {
	private static String path="/xtgl/fucn/";//jsp路径
	//navTabId
	private static String navTabId="sfucn";
	private static String key="mc";//查询关键字字段名
	
	@Override
	public String action() {
                      return  "系统菜单";
 }
	
	/**
	 * 系统菜单的首页
	 * <br/>页面 ：/xtgl/fucn/index.jsp
	 */
	@Override
	public void index() {
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	/**
	 * 查看
	 * <br/>页面 ：/xtgl/fucn/view.jsp
	 */
	public void view() {
		setAttr("sfucn", Sfucn.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}
	
	/**
	 * 到 添加 菜单的页面
	 * <br/>页面 ：/xtgl/fucn/add.jsp
	 */
	public void add() {
		redirect(path+"add.jsp");
	}
	
	/**
	 * 保存 添加的菜单到数据库
	 */
	@Before(FucnValidator.class)
	public void save() {

		try{
			Sfucn m=getModel(Sfucn.class);
			if(m.get("id")!=null){
				m.update();
toDwzJson(200,"修改操作成功",navTabId,"","closeCurrent");
			}else{
				//m.set("id", "fucn_seq.nextval");
				m.save();
toDwzJson(200,"新增操作成功",navTabId,"","closeCurrent");
			}
			//toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
		}catch(Exception e){
			toDwzJson( 300, "保存异常！",navTabId);
		}
	}
	
	/**
	 * 编辑菜单
	 * <br/>页面：/xtgl/fucn/add.jsp
	 */
	public void edit() {
		setAttr("sfucn", Sfucn.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除菜单
	 */
	public void delete() {
		Sfucn.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	
	private Page<Sfucn> getPageData()
	{
		String keywords=getPara("keywords");
		String sql="from sfucn order by id desc";
		if(keywords!=null&&!keywords.isEmpty())
			sql="from sfucn where "+key+" like '%"+keywords+"%' order by id desc";	
		return Sfucn.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException 
	{
		List<Sfucn> data=getPageData().getList();
		String[] columns = {"mc", "fid", "link"};
		String[] heades = {"名称", "父编号", "路径"};
		String filename = new String("功能管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

}


