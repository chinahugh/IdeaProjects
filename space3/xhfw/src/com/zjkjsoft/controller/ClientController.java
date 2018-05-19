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
import com.zjkjsoft.model.Client;
import com.zjkjsoft.model.Employee;
import com.zjkjsoft.model.Suser;
import com.zjkjsoft.util.ImportExcel;

/**
 * ClientController
 * 检修所管理
 */

@Before(ManagerPowerInterceptor.class)
public class ClientController extends BaseController {
	private static String path="/jcxx/client/";//jsp路径
	//navTabId
	private static String navTabId="client";
	
	@Override
	public String action() {
                      return  "客户管理";
 }
	/**
	 * 检修所管理首页
	 * <br/>页面：/jcxx/client/list.jsp
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
	
	private Page<Client> getPageData()
	{
		String sql=" from client where 1=1 ";
		String bh=getPara("bh");
		if(bh!=null&&!"".equals(bh))
			sql+=" and bh like '%"+bh+"%' ";	
		String mc=getPara("mc");
		if(mc!=null&&!"".equals(mc))
			sql+=" and mc like '%"+mc+"%' ";	
		return Client.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	/**
	 * 查看
	 * <br/>页面：/xtgl/role/view.jsp
	 */
	public void view() {
		setAttr("client", Client.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加
	 * <br/>页面：/jcxx/client/add.jsp
	 */
	public void add() {
		redirect(path+"add.jsp");
	}
	
	
	/**
	 * 保存数据到数据库
	 */
	
	public void save() {

		try{
			Client m=getModel(Client.class);
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
	 * 客户的修改 编辑
	 * <br/>页面：/jcxx/client/add.jsp
	 */
	public void edit() {
		setAttr("client", Client.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Client.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Client> data=getPageData().getList();
		String[] columns = {"bh","mc","lxr1","lxr2","dh1","dh2","dz","cs","dzyx","bz"};
		String[] heades = {"编号","名称","联系人1","联系人2","电话1","电话2","地址","城市","电子邮箱","备注"};
		String filename = new String("检修所管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

	
	/**
	 * 导入文件页面
	 * <br/>页面：/jcxx/client/importFile.jsp
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
			Client m=new Client();
			m.set("bh", map.get(0));
			m.set("mc", map.get(1));
			m.set("lxr1", map.get(2));
			m.set("lxr2", map.get(3));
			m.set("dh1", map.get(4));
			m.set("dh2", map.get(5));
			m.set("dz", map.get(6));
			m.set("cs", map.get(7));
			m.set("dzyx", map.get(8));
			m.set("bz", map.get(9));
			m.save();
		}
		toDwzJson(200, "导入成功！", navTabId, "", "closeCurrent");
	}
}


