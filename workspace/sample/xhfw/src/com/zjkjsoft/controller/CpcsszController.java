package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Cpcssz;


/**
 * 
 * 产品测试配置管理
 */

@Before(ManagerPowerInterceptor.class)
public class CpcsszController extends BaseController {
	private static String path="/xtpz/cpcssz/";//jsp路径
	//navTabId
	private static String navTabId="cpcssz";
	private static String key="mc";//查询关键字字段名
	
	@Override
	public String action() {
                      return  "产品测试配置";
 }
	/**
	 * 角色管理首页
	 * <br/>页面：/xtgl/role/list.jsp
	 */
	@Override
	public void index() {
		String keywords=getPara("keywords");
		String sql="from cpcssz  order by id desc";
		if(keywords!=null&&!"".equals(keywords))
			sql="from cpcssz where "+key+" like '%"+keywords+"%' order by id desc";	
		setAttr("page", Cpcssz.dao.paginate(getParaToInt("pageNum", 1),
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
	
	private Page<Cpcssz> getPageData()
	{
		String keywords=getPara("keywords");
		String sql="from cpcssz  order by id desc";
		if(keywords!=null&&!"".equals(keywords))
			sql="from cpcssz where "+key+" like '%"+keywords+"%' order by id desc";	
		return Cpcssz.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql);
	}
	/**
	 * 查看
	 * <br/>页面：/xtgl/role/view.jsp
	 */
	public void view() {
		setAttr("cpcssz", Cpcssz.dao.findById(getParaToInt()));
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
	public void save() {

		try{
			Cpcssz m=getModel(Cpcssz.class);
//测试项目	
				String[] cs=this.getParaValues("c");
				int i=0;
				for(String c:cs) {
					m.set("c"+i++, c);
				}
				m.set("cs", i);
				for(;i<20;i++) {
					m.set("c"+i++, null);
				}
			
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
		Cpcssz cpcssz=Cpcssz.dao.findById(getParaToInt());
		setAttr("cpcssz", cpcssz);
		List list = new ArrayList();
		for(int i=0;i<cpcssz.getInt("cs");i++)
			list.add(cpcssz.getStr("c"+i));
		setAttr("list", list);
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Cpcssz.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Cpcssz> data=getPageData().getList();
		String[] columns = {"mc","ms"};
		String[] heades = {"名称","描述"};
		String filename = new String("角色管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

}


