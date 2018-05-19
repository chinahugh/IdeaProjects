package com.zjkjsoft.controller;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.common.IndexController;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.JcxxIndent;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * JcxxIndentController
 * 订单抬头
 */

@Before(ManagerPowerInterceptor.class)
public class JcxxIndentController extends BaseController {
	private static String path="/jcxx/jcxxindent/";//jsp路径
	//navTabId
	private static String navTabId="jcxxindent";
	
	@Override
	public String action() {
                      return  "订单抬头";
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
		String wlms=getPara("wlms");
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and wlms like '%"+wlms+"%' ";	
		String dd=getPara("dd");
		if(dd!=null&&!"".equals(dd))
			sql+=" and dd like '%"+dd+"%' ";	
		String mrpkzz=getPara("mrpkzz");
		if(mrpkzz!=null&&!"".equals(mrpkzz))
			sql+=" and mrpkzz like '%"+mrpkzz+"%' ";
		return JcxxIndent.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	/**
	 * 查看
	 * <br/>页面：/jcxx/indent/view.jsp
	 */
	public void view() {
		setAttr("jcxxindent", JcxxIndent.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加订单
	 * <br/>页面：/jcxx/indent/add.jsp
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
			JcxxIndent m=getModel(JcxxIndent.class);
			if(m.get("id")!=null){
				Db.update(" update jcxxindent set state=0 where id=?", (Object) m.get("id"));
				Db.update(" INSERT INTO jcxxindent(dd,wl,ddlx,ddsl,jbksrq,jbwcrq,xtzt,wlms,state,date,mrpkzz,status)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?)" 
				,m.get("dd"),m.get("wl"),m.get("ddlx"),m.get("ddsl"),m.get("jbksrq"),m.get("jbwcrq"),m.get("xtzt"),m.get("wlms"),1,date,m.get("mrpkzz"),m.get("status"));
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
	 * 订单的修改 编辑
	 * <br/>页面：/scxx/indent/add.jsp
	 */
	public void edit() {
		setAttr("jcxxIndent", JcxxIndent.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		JcxxIndent.dao.deleteById(getParaToInt());
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


