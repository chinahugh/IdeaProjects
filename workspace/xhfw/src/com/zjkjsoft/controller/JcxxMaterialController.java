package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;


import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.common.IndexController;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.JcxxMaterial;
import com.zjkjsoft.model.Suser;

/**
 * JcxxMaterialController
 * 物料信息
 */

@Before(ManagerPowerInterceptor.class)
public class JcxxMaterialController extends BaseController {
	private static String path="/jcxx/jcxxmaterial/";//jsp路径
	//navTabId
	private static String navTabId="jcxxmaterial";
	
	@Override
	public String action() {
                      return  "物料信息";
 }
	/**
	 * 物料信息首页
	 * <br/>页面：/jcxx/material/list.jsp
	 */
	@Override
	public void index() {
		Suser suser=this.getSessionAttr("user");
		setAttr("flag", suser.getInt("rid"));
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	/**
	 * 模糊查询
	 */
	public void list() {
		Suser suser=this.getSessionAttr("user");
		setAttr("flag", suser.getInt("rid"));
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	
	private Page<JcxxMaterial> getPageData()
	{
		String sql;
		long count=Db.queryLong("select count(*) as count from jcxxmaterial where state=1");
		if (count!=0) {
			sql=" from jcxxmaterial where 1=1 and state=1";
		} else {
			sql=" from jcxxmaterial where 1=1 ";
		}
		String wlms=getPara("wlms");
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and wlms like '%"+wlms+"%' ";	
		String wlh=getPara("wlh");
		if(wlh!=null&&!"".equals(wlh))
			sql+=" and wlh like '%"+wlh+"%' ";	
		return JcxxMaterial.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	/**
	 * 查看
	 * <br/>页面：/jcxx/material/view.jsp
	 */
	public void view() {
		setAttr("jcxxmaterial", JcxxMaterial.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加物料
	 * <br/>页面：/jcxx/material/add.jsp
	 */
	public void add() {
		redirect(path+"add.jsp");
	}
	
	
	/**
	 * 保存数据到数据库
	 */
	public void save() {
		String date=IndexController.sfymdhms.format(new Date());
		try{
			JcxxMaterial m=getModel(JcxxMaterial.class);
			if(m.get("id")!=null){
				Db.update(" update jcxxmaterial set state=0 where id=?",m.get("id"));
				Db.update(" INSERT INTO jcxxmaterial(gc,wlh,wlms,wlth,ggxh,state,date) " + 
				" VALUES (?,?,?,?,?,?,?)",m.get("gc"),m.get("wlh"),m.get("wlms"),m.get("wlth"),m.get("ggxh"),1,date);
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
			toDwzJson( 300, "保存异常！",navTabId);
		}
	}
	
	/**
	 * 物料的修改 编辑
	 * <br/>页面：/jcxx/material/add.jsp
	 */
	public void edit() {
		setAttr("jcxxMaterial", JcxxMaterial.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		JcxxMaterial.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<JcxxMaterial> data=getPageData().getList();
		String[] columns = {"gc","wlh","wlms","wlth","ggxh"};
		String[] heades = {"工厂","物料号","物料描述","物料图号","规格型号"};
		String filename = new String("物料信息.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

	
}


