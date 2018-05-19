package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Indent;
import com.zjkjsoft.model.JcxxIndent;
import com.zjkjsoft.validator.RoleValidator;

/**
 * IndentController
 * 订单管理
 */

@Before(ManagerPowerInterceptor.class)
public class IndentCXController extends BaseController {
	private static String path="/zhcx/indent/";//jsp路径
	//navTabId
	private static String navTabId="indentCX";
	private static String key="mc";//查询关键字字段名
	
	@Override
	public String action() {
                      return  "订单管理";
 }
	/**
	 * 订单管理首页
	 * <br/>页面：/scxx/indent/list.jsp
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
	
	private Page<JcxxIndent> getPageData()
	{
		String sql;
		String status=getPara("status1");
		long count=Db.queryLong("select count(*) as count from jcxxindent where state=1");
		if(status!=null&&!"".equals(status)) {
			if (count!=0) {
				sql=" from jcxxindent where 1=1 and state=1";
			} else {
				sql=" from jcxxindent where 1=1 ";
			}
			sql+=" and status like '%"+status+"%' ";	
		}else {
			if (count!=0) {
				sql=" from jcxxindent where status='未完成' and state=1";
			} else {
				sql=" from jcxxindent where status='未完成' ";
			}
		}
		String dd=getPara("dd");
		if(dd!=null&&!"".equals(dd))
			sql+=" and dd like '%"+dd+"%' ";		
		String ddlx=getPara("ddlx");
		if(ddlx!=null&&!"".equals(ddlx))
			sql+=" and ddlx like '%"+ddlx+"%' ";		
		String mrpkzz=getPara("mrpkzz");
		if(mrpkzz!=null&&!"".equals(mrpkzz))
			sql+=" and mrpkzz like '%"+mrpkzz+"%' ";		
		return JcxxIndent.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	/**
	 * 查看
	 * <br/>页面：/scxx/indent/view.jsp
	 */
	public void view() {
		setAttr("jcxxindent", JcxxIndent.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加订单
	 * <br/>页面：/scxx/indent/add.jsp
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
			Indent m=getModel(Indent.class);
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
	 * <br/>页面：/scxx/indent/add.jsp
	 */
	public void edit() {
		setAttr("indent", Indent.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Indent.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<JcxxIndent> data=getPageData().getList();
		String[] columns = {"dd","wl","ddlx","ddsl","jbksrq","jbwcrq","xtzt","wlms"};
		String[] heades = {"订单","物料","订单类型","订单数量","基本开始日期","基本完成日期","系统状态","物料描述"};
		String filename = new String("订单抬头.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

}


