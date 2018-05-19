package com.zjkjsoft.controller;



import java.io.UnsupportedEncodingException;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.element.PageElement;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Sorg;

/**
 * 部门单位管理
 */

@Before(ManagerPowerInterceptor.class)
public class SorgController extends BaseController {
	private static String path="/xtgl/sorg/";//jsp路径
	//navTabId
	private static String navTabId="sorg";
	private static String key="mc";//查询关键字字段名
	
	@Override
	public String action() {
                      return  "部门管理";
   }
	
	/**
	 * 到部门单位管理首页
	 * <br/>页面：/xtgl/sorg/index.jsp
	 */
	@Override
	public void index() {
		String sql="from sorg where 1=1 ";
		String keywords=getPara("keywords");
		if(keywords!=null&&!"".equals(keywords))
			sql+=" and   "+key+" like '%"+keywords+"%' ";
		Integer fid=this.getSessionAttr("sorgFid");
		if(fid!=null)
			sql+=" and   fid="+fid+" ";
		 sql+=" order by xh,id desc " ;
		setAttr("page", Sorg.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql));
		setAttr("treeStr", PageElement.getTreeS("select * from sorg where  fid=? order by xh",  Integer.valueOf(0), "sorg/list/", "bmBox","mc"));
		render(path+"index.jsp");
	}
	/**
	 * 查看部门
	 * <br/>页面：/xtgl/sorg/view.jsp
	 */
	public void view() {
		setAttr("sorg", Sorg.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}
	
	/**
	 * 显示某个部门下设的部门列表
	 * <br/>页面：/xtgl/sorg/list.jsp
	 */
	public void list() {

		setAttr("page", getPageData());
		setAttr("fid", getParaToInt());
		this.setSessionAttr("sorgFid", getParaToInt());
		render(path+"list.jsp");
	}
	
	
	private Page<Sorg> getPageData()
	{
		String keywords=getPara("keywords");
		String sql="from sorg  where fid= "+getParaToInt()+" order by id desc";
		if(keywords!=null&&!"".equals(keywords))
			sql="from sorg where  fid= "+getParaToInt()+" and  "+key+" like '%"+keywords+"%' order by id desc";	
		return Sorg.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql);
	}
	
	/**
	 * 添加部门
	 * <br/>页面：/xtgl/sorg/add.jsp
	 */
	public void add() {
		redirect(path+"add.jsp?fid="+getParaToInt());
	}
	
	/**
	 * 保存添加的部门到数据库
	 */
	public void save() {

		try{
			Sorg m=getModel(Sorg.class);
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
	 * <br/>页面：/xtgl/sorg/add.jsp
	 */
	public void edit() {
		setAttr("sorg", Sorg.dao.findById(getParaToInt()));
		render(path+"add.jsp?fid="+getPara("fid"));
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Sorg.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Sorg> data=getPageData().getList();
		String[] columns = {"mc","ms"};
		String[] heades = {"名称","描述"};
		String filename = new String("部门管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}


}


