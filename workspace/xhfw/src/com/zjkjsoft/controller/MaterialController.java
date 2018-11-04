package com.zjkjsoft.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.common.IndexController;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Material;
import com.zjkjsoft.util.ImportExcel;
import com.zjkjsoft.validator.RoleValidator;

/**
 * MaterialController
 * 物料信息
 */

@Before(ManagerPowerInterceptor.class)
public class MaterialController extends BaseController {
	private static String path="/jcxx/material/";//jsp路径
	//navTabId
	private static String navTabId="material";
	
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
	
	private Page<Material> getPageData()
	{
		String sql;
		long count=Db.queryLong("select count(*) as count from material where state=1");
		if (count!=0) {
			sql=" from material where 1=1 and state=1";
		} else {
			sql=" from material where 1=1 ";
		}
		String wlms=getPara("wlms");
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and wlms like '%"+wlms+"%' ";	
		String wlh=getPara("wlh");
		if(wlh!=null&&!"".equals(wlh))
			sql+=" and wlh like '%"+wlh+"%' ";	
		return Material.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	/**
	 * 查看
	 * <br/>页面：/jcxx/material/view.jsp
	 */
	public void view() {
		setAttr("material", Material.dao.findById(getParaToInt()));
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
	@Before(RoleValidator.class)
	public void save() {

		try{
			Material m=getModel(Material.class);
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
	 * 物料的修改 编辑
	 * <br/>页面：/jcxx/material/add.jsp
	 */
	public void edit() {
		setAttr("material", Material.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Material.dao.deleteById(getPara());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Material> data=getPageData().getList();
		String[] columns = {"gc","wlh","wlms","wlth","ggxh"};
		String[] heades = {"工厂","物料号","物料描述","物料图号","规格型号"};
		String filename = new String("物料信息.xlsx".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

	
	/**
	 * 导入文件页面
	 * <br/>页面：/jcxx/material/importFile.jsp
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
		String date=IndexController.sfymdhms.format(new Date());
		String fileName=getPara("attachment.fileName");
		String realPath= this.getRequest().getSession().getServletContext().getRealPath("/");
		String path=realPath+getPara("attachment.attachmentPath").substring(1);
		String excel=fileName.substring(fileName.lastIndexOf(".")+1);
		List<Map<Integer,Object>> list = ImportExcel.importExce(path, excel);
		List<Material> data=new ArrayList<Material>();
		for(Map<Integer,Object> map:list) { // 遍历取出的数据，并保存
			Material m=new Material();
			m.set("gc", map.get(0));
			m.set("wlh", map.get(1).toString().substring(8));
			m.set("wlms", map.get(2));
			m.set("wlth", map.get(3));
			m.set("ggxh", map.get(4));
			m.set("date", date);
			m.set("state", 1);
			//判断导入的某条数据与数据库中的某条数据是否完全一致,如有，则不做处理
			long num1;
			if (m.get("ggxh")!=null) {
				num1=Db.queryLong(" select count(*) as num from material where gc=? and wlh=? and wlms=? and wlth=? and ggxh=? "
						,m.get("gc"),m.get("wlh"),m.get("wlms"),m.get("wlth"),m.get("ggxh"));
			}else {
				num1=Db.queryLong(" select count(*) as num from material where gc=? and wlh=? and wlms=? and wlth=? "
						,m.get("gc"),m.get("wlh"),m.get("wlms"),m.get("wlth"));
			}
			if (num1!=0) {
				continue;
			}
			//判断导入的某条数据与数据库中的某条数据不完全一致，如有，需记录，
			long num2=Db.queryLong(" select count(*) as num from material where wlh=? ",m.get("wlh"));
			if (num2!=0) {
				data.add(m);
			}
			m.save();
		}
		
		//判断material有没有新数据加入
		long num3=Db.queryLong(" select count(*) as num from material where date=? ", date);
		if (num3!=0) {
			//把最新的数据复制到jcxxmaterial表中
			Db.update(" INSERT INTO jcxxmaterial(gc,wlh,wlms,wlth,ggxh,state,date) SELECT " + 
					" m.gc,m.wlh,m.wlms,m.wlth,m.ggxh,m.state,m.date FROM material  m " + 
					"WHERE m.date=(SELECT MAX(DATE) AS DATE FROM material ) ");
		}
		
		//把jcxxmaterial,material表中的就旧数据状态改为0
		for (Material mate : data) {
			Db.update(" update jcxxmaterial set state=0 where wlh=? and date!=? ", mate.get("wlh"),mate.get("date"));
			Db.update(" update material set state=0 where wlh=? and date!=? ", mate.get("wlh"),mate.get("date"));
		}
		
		//如果存在重复数据，将数据导出
		try {
				String[] columns = {"gc","wlh","wlms","wlth","ggxh","date"};
				String[] heades = {"工厂","物料号","物料描述","物料图号","规格型号","导入时间"};
				String filename = new String("物料重复数据.xlsx".getBytes("UTF-8"), "ISO8859-1");
				render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
				return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 取消覆盖文件页面
	 * <br/>页面：/jcxx/material/importCancelFile.jsp
	 */
	public void importCancelFile(){
		render(path+"cancelRepeate.jsp");
	}
	
	
	/**
	 * 导入Excel,取消重复的数据
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void cancelRepeate() throws FileNotFoundException, IOException {
		String fileName=getPara("attachment.fileName");
		String realPath= this.getRequest().getSession().getServletContext().getRealPath("/");
		String path=realPath+getPara("attachment.attachmentPath").substring(1);
		String excel=fileName.substring(fileName.lastIndexOf(".")+1);
		List<Map<Integer,Object>> list = ImportExcel.importExce(path, excel);
		for(Map<Integer,Object> map:list) {
			Material m=new Material();
			m.set("wlh", map.get(1));
			m.set("date", map.get(5));
			//将material表中的最新覆盖数据删除
			Db.update(" DELETE FROM material WHERE wlh = ? and date = ? ", m.get("wlh"),m.get("date"));
			//将jcxxmaterial表中的最新覆盖数据删除
			Db.update(" DELETE FROM jcxxmaterial WHERE wlh = ? and date = ? ", m.get("wlh"),m.get("date"));
			//把jcxxmaterial,material表中原先的最新数据状态改为1
			String date=Db.queryStr(" SELECT MAX(DATE) AS DATE FROM material where date!=? ",m.get("date"));
			Db.update(" update jcxxmaterial set state=1 where wlh=? and date=?",m.get("wlh"),date);
			Db.update(" update material set state=1 where wlh=? and date=?",m.get("wlh"),date);
		}
		toDwzJson(200, "取消覆盖成功！", navTabId, "", "closeCurrent");
	}
}


