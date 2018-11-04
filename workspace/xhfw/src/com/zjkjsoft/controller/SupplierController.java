package com.zjkjsoft.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Material;
import com.zjkjsoft.model.Supplier;
import com.zjkjsoft.util.ImportExcel;

/**
 * SupplierController
 * 供应商管理
 */

@Before(ManagerPowerInterceptor.class)
public class SupplierController extends BaseController {
	private static String path="/jcxx/supplier/";//jsp路径
	//navTabId
	private static String navTabId="supplier";
	
	@Override
	public String action() {
                      return  "供应商管理";
 }
	/**
	 * 供应商管理首页
	 * <br/>页面：/xtgl/role/list.jsp
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
	
	private Page<Supplier> getPageData()
	{
		String sql="from supplier  where 1=1 ";
		String gzzx=getPara("gzzx");
		if(gzzx!=null&&!"".equals(gzzx))
			sql+="and gzzx like '%"+gzzx+"%' ";	
		String dms=getPara("dms");
		if(dms!=null&&!"".equals(dms))
			sql+="and dms like '%"+dms+"%' ";	
		return Supplier.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	/**
	 * 查看
	 * <br/>页面：/xtgl/role/view.jsp
	 */
	public void view() {
		setAttr("supplier", Supplier.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加供应商
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
			Supplier m=getModel(Supplier.class);
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
	 * 供应商的修改 编辑
	 * <br/>页面：/xtgl/role/add.jsp
	 */
	public void edit() {
		setAttr("supplier", Supplier.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Supplier.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Supplier> data=getPageData().getList();
		String[] columns = {"mc","ms"};
		String[] heades = {"名称","描述"};
		String filename = new String("供应商管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}
	
	
	/**
	 * 导入文件页面
	 * <br/>页面：/jcxx/supplier/importFile.jsp
	 */
	public void importFile(){
		render(path+"importFile.jsp");
	}
	
	
	/**
	 * 导入Excel
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void importExcel() throws FileNotFoundException, IOException {
		String fileName=getPara("attachment.fileName");
		String realPath= this.getRequest().getSession().getServletContext().getRealPath("/");
		String path=realPath+getPara("attachment.attachmentPath").substring(1);
		String excel=fileName.substring(fileName.lastIndexOf(".")+1);
		List<Map<Integer,Object>> list = ImportExcel.importExce(path, excel);
		for(Map<Integer,Object> map:list) { // 遍历取出的数据，并保存
			Supplier m=new Supplier();
			m.set("lb", map.get(0));
			m.set("gc", map.get(1));
			m.set("gzzx", map.get(2));
			m.set("dms", map.get(3));
			m.save();
		}
		toDwzJson(200, "导入成功！", navTabId, "", "closeCurrent");
	}
}


