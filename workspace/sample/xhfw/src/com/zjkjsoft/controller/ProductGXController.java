package com.zjkjsoft.controller;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.zjkjsoft.element.PageElement;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Product;
import com.zjkjsoft.model.Scode;
import com.zjkjsoft.model.Srcs;
import com.zjkjsoft.model.Suser;
import com.zjkjsoft.validator.RoleValidator;
import com.zjkjsoft.validator.RolfunValidator;

/**
 * ProductController
 * 产品管理
 */

@Before(ManagerPowerInterceptor.class)
public class ProductGXController extends BaseController {
	private static String path="/xtgl/cpgx/";//jsp路径
	/** navTabId */
	private static String navTabId="scode";
	/** 查询关键字字段名 */
	private static String key="mc";
	
	
	@Override
	public String action() {
                      return  "部门管理";
   }
	
	/**
	 * 到部门单位管理首页
	 * <br/>页面：/xtgl/scode/index.jsp
	 */
	@Override
	public void index() {
		String sql="from scode where 1=1 ";
		String keywords=getPara("keywords");
		if(keywords!=null&&!"".equals(keywords))
			sql+=" and   "+key+" like '%"+keywords+"%' ";
		Integer fid=this.getSessionAttr("scodeFid");
		if(fid!=null)
			sql+=" and   fid="+fid+" ";
		 sql+=" order by xh,id desc " ;
		setAttr("page", Scode.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql));
	//	setAttr("treeStr", PageElement.getTreeS("select * from scode where  fid=? order by xh",  Integer.valueOf(0), "scode/list/", "bmBox","mc"));
		setAttr("treeJSStr", PageElement.getTreeC1("select * from scode where  fid=? order by xh ,id ", Integer.valueOf(3), "productGX/list/","cpgxBox", "mc"));

		render(path+"index.jsp");
	}
	/**
	 * 查看部门
	 * <br/>页面：/xtgl/scode/view.jsp
	 */
	public void view() {
		setAttr("scode", Scode.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}
	
	/**
	 * 显示某个部门下设的部门列表
	 * <br/>页面：/xtgl/scode/list.jsp
	 */
	public void list() {

		setAttr("page", getPageData());
		setAttr("fid", getParaToInt());
		this.setSessionAttr("scodeFid", getParaToInt());
		render(path+"list.jsp");
	}
	
	private Page<Scode> getPageData()
	{
		String keywords=getPara("keywords");
		String sql="from scode  where fid= "+getParaToInt()+" order by id desc";
		if(keywords!=null&&!"".equals(keywords))
			sql="from scode where  fid= "+getParaToInt()+" and  "+key+" like '%"+keywords+"%' order by id desc";	
		return Scode.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql);
	}
	
	/**
	 * 添加部门
	 * <br/>页面：/xtgl/scode/add.jsp
	 */
	public void add() {
		redirect(path+"add.jsp?fid="+getParaToInt());
	}
	
	/**
	 * 保存添加的部门到数据库
	 */
	public void save() {

		try{
			Scode m=getModel(Scode.class);
			if(m.get("id")!=null){
				m.update();
				toDwzJson(200,"修改操作成功",navTabId,"","closeCurrent");
			}else{
			//	m.set("id", null);
				m.save();
				toDwzJson(200,"新增操作成功",navTabId,"","closeCurrent");
			}
			//toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
		}catch(Exception e){
			toDwzJson( 300, "保存异常！",navTabId);
		}
	}
	
	/**
	 * 修改部门的信息
	 * <br/>页面：/xtgl/scode/add.jsp
	 */
	public void edit() {
		setAttr("scode", Scode.dao.findById(getParaToInt()));
		render(path+"add.jsp?fid="+getPara("fid"));
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Scode.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	}