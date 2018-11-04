package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.jfinal.aop.Before;

import com.jfinal.ext.render.excel.PoiRender;

import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;

import com.zjkjsoft.model.Barcode2;
import com.zjkjsoft.validator.RoleValidator;

/**
 * RoleController
 * 二维码管理
 */

@Before(ManagerPowerInterceptor.class)
public class Barcode2Controller extends BaseController {
	private static String path="/tmgl/barcode2/";//jsp路径
	//navTabId
	private static String navTabId="barcode2";
	private static String key="mc";//查询关键字字段名
	
	@Override
	public String action() {
                      return  "二维码管理";
 }
	/**
	 * 二维码管理首页
	 * <br/>页面：/tmgl/barcode2/list.jsp
	 */
	@Override
	public void index() {
		String keywords=getPara("keywords");
		String sql="from barcode2  order by id desc";
		if(keywords!=null&&!"".equals(keywords))
			sql="from barcode2 where "+key+" like '%"+keywords+"%' order by id desc";	
		setAttr("page", Barcode2.dao.paginate(getParaToInt("pageNum", 1),
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
	
	private Page<Barcode2> getPageData()
	{
		String keywords=getPara("keywords");
		String sql="from barcode2  order by id desc";
		if(keywords!=null&&!"".equals(keywords))
			sql="from barcode2 where "+key+" like '%"+keywords+"%' order by id desc";	
		return Barcode2.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql);
	}
	/**
	 * 查看
	 * <br/>页面：/xtgl/role/view.jsp
	 */
	public void view() {
		setAttr("barcode2", Barcode2.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加二维码
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
			Barcode2 m=getModel(Barcode2.class);
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
	 * 二维码的修改 编辑
	 * <br/>页面：/xtgl/role/add.jsp
	 */
	public void edit() {
		setAttr("barcode2", Barcode2.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Barcode2.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Barcode2> data=getPageData().getList();
		String[] columns = {"mc","ms"};
		String[] heades = {"名称","描述"};
		String filename = new String("二维码管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

}


