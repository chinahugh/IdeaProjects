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
import com.zjkjsoft.model.Employee;
import com.zjkjsoft.model.Supplier;
import com.zjkjsoft.model.Suser;
import com.zjkjsoft.util.ImportExcel;

/**
 * EmployeeController
 * 人员管理
 */

@Before(ManagerPowerInterceptor.class)
public class EmployeeController extends BaseController {
	private static String path="/jcxx/employee/";//jsp路径
	//navTabId
	private static String navTabId="employee";
	
	@Override
	public String action() {
                      return  "员工管理";
 }
	/**
	 * 员工管理首页
	 * <br/>页面：/jcxx/employee/list.jsp
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
	
	private Page<Employee> getPageData()
	{
		String sql="from employee  where 1=1 ";
		String bh=getPara("bh");
		if(bh!=null&&!"".equals(bh))
			sql+=" and bh like '%"+bh+"%' ";	
		String xm=getPara("xm");
		if(xm!=null&&!"".equals(xm))
			sql+=" and xm like '%"+xm+"%' ";	
		return Employee.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	/**
	 * 查看
	 * <br/>页面：/jcxx/employee/view.jsp
	 */
	public void view() {
		setAttr("employee", Employee.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加员工
	 * <br/>页面：/jcxx/employee/add.jsp
	 */
	public void add() {
		redirect(path+"add.jsp");
	}
	
	
	/**
	 * 保存数据到数据库
	 */
	
	public void save() {

		try{
			Employee m=getModel(Employee.class);
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
	 * 员工的修改 编辑
	 * <br/>页面：/jcxx/employee/add.jsp
	 */
	public void edit() {
		setAttr("employee", Employee.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Employee.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Employee> data=getPageData().getList();
		String[] columns = {"bh","xm","zzdw","zw"};
		String[] heades = {"编号","姓名","组织单位","职位"};
		String filename = new String("人员管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

	
	/**
	 * 导入文件页面
	 * <br/>页面：/jcxx/employee/importFile.jsp
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
			Employee m=new Employee();
			m.set("bh", map.get(0));
			m.set("xm", map.get(1));
			m.set("zzdw", map.get(2));
			m.set("zw", map.get(3));
			m.save();
		}
		toDwzJson(200, "导入成功！", navTabId, "", "closeCurrent");
	}
}




