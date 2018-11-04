package com.zjkjsoft.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;


import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.common.IndexController;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Bom;
import com.zjkjsoft.model.ProBbh;
import com.zjkjsoft.model.Product;
import com.zjkjsoft.util.ImportExcel;
import com.zjkjsoft.validator.RoleValidator;

/**
 * BomController
 * bom信息
 */

@Before(ManagerPowerInterceptor.class)
public class BomController extends BaseController {
	private static String path="/jcxx/bom/";//jsp路径
	//navTabId
	private static String navTabId="bom";
	
	@Override
	public String action() {
                      return  "BOM管理";
 }
	/**
	 * BOM信息首页
	 * <br/>页面：/jcxx/bom/list.jsp
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
	
	private Page<Bom> getPageData()
	{
		String selectSQL=" SELECT * ";
		String sql=" FROM bom where 1=1 ";
		String wlms=getPara("wlms");
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and m.wlms like '%"+wlms+"%' ";		
		String wlh=getPara("wlh");
		if(wlh!=null&&!"".equals(wlh))
			sql+=" and b.wlh like '%"+wlh+"%' ";		
		return Bom.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), selectSQL , sql+" order by id desc ");
	}
	/**
	 * 查看
	 * <br/>页面：/jcxx/bom/view.jsp
	 */
	public void view() {
		setAttr("bom", Bom.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加
	 * <br/>页面：/jcxx/bom/add.jsp
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
			//Material material=getModel(Material.class);
			//Material m=Material.dao.findFirst("select * from naterial where wl=?", material.get("wl"));
			Bom b=getModel(Bom.class);
			if(b.get("id")!=null){
				b.update();
				toDwzJson(200,"修改操作成功",navTabId,"","closeCurrent");
			}else{
				//m.set("id", "js_seq.nextval");

				b.save();
				toDwzJson(200,"新增操作成功",navTabId,"","closeCurrent");
			}
			//toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
		}catch(Exception e){
			toDwzJson( 300, "保存异常！",navTabId);
		}
	}
	
	/**
	 * BOM的修改 编辑
	 * <br/>页面：/jcxx/bom/add.jsp
	 */
	public void edit() {
		setAttr("bom", Bom.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Bom.dao.deleteById(getPara());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Bom> data=getPageData().getList();
		String[] columns = {"wlh","wlms","wlth","zj","zjms","zjsl","zjth"};
		String[] heades = {"物料号","物料描述","物料图号","组件","组件描述","组件数量","组件图号"};
		String filename = new String("BOM信息.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

	
	/**
	 * 导入文件页面
	 * <br/>页面：/jcxx/bom/importFile.jsp
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
		Product product=Product.dao.findFirst(" select * from product order by id desc ");
		int fid=product.getInt("id");
		ProBbh probbh=new ProBbh();
		probbh.set("fid", fid).set("bbh", "1").save();
		String fileName=getPara("attachment.fileName");
		String realPath= this.getRequest().getSession().getServletContext().getRealPath("/");
		String path=realPath+getPara("attachment.attachmentPath").substring(1);
		String excel=fileName.substring(fileName.lastIndexOf(".")+1);
		List<Map<Integer,Object>> list = ImportExcel.importExce(path, excel);
		for(Map<Integer,Object> map:list) { // 遍历取出的数据，并保存
			Bom m=new Bom();
			m.set("wlh", map.get(1).toString().substring(8));
			m.set("wlms", map.get(2));
			m.set("wlth", map.get(8));
			m.set("zj", map.get(13).toString().substring(8));
			m.set("zjms", map.get(14));
			m.set("zjsl", map.get(15));
			m.set("zjth", map.get(18));
			m.set("bbh", 1);
			m.set("date", date);
			m.set("fid", fid);
			m.save();
		}
		Db.update("INSERT INTO jcxxbom(wlh,wlms,wlth,zj,zjms,zjsl,zjth,bbh,fid) SELECT b.wlh, " + 
				"b.wlms,b.wlth,b.zj,b.zjms,b.zjsl,b.zjth,b.bbh,b.fid FROM bom  b " + 
				" WHERE b.date=(SELECT MAX(DATE) AS DATE FROM bom ) ");
		toDwzJson(200, "导入成功！", navTabId, "", "closeCurrent");
	}
}


