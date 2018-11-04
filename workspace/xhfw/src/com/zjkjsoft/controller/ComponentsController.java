package com.zjkjsoft.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Components;
import com.zjkjsoft.model.Indent;
import com.zjkjsoft.util.ImportExcel;
import com.zjkjsoft.validator.RoleValidator;

/**
 * ComponentsController
 * 订单组件
 */

@Before(ManagerPowerInterceptor.class)
public class ComponentsController extends BaseController {
	private static String path="/jcxx/components/";//jsp路径
	//navTabId
	private static String navTabId="components";
	
	@Override
	public String action() {
                      return  "订单组件";
 }
	/**
	 * 订单组件首页
	 * <br/>页面：/jcxx/components/list.jsp
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
	
	private Page<Components> getPageData()
	{
		String selectSQL=" SELECT * ";
		String sql;
		long count=Db.findFirst("select count(*) as count from components").getLong("count");
		if (count!=0) {
			sql=" from components where 1=1 and state=1";
		} else {
			sql=" from components where 1=1 ";
		}
		String wlms=getPara("wlms");
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and wlms like '%"+wlms+"%' ";	
		String wlh=getPara("wlh");
		if(wlh!=null&&!"".equals(wlh))
			sql+=" and wlh like '%"+wlh+"%' ";	
		return Components.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), selectSQL, sql+" order by id desc ");
	}
	/**
	 * 查看
	 * <br/>页面：/jcxx/components/view.jsp
	 */
	public void view() {
		setAttr("components", Components.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加订单
	 * <br/>页面：/jcxx/components/add.jsp
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
	 * <br/>页面：/scxx/components/add.jsp
	 */
	public void edit() {
		setAttr("indent", Indent.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Components.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Components> data=getPageData().getList();
		String[] columns = {"dd","wl","xmzj","xqrq","xqsl","chsl","wlms","syxq"};
		String[] heades = {"订单","物料","项目组件","需求日期","需求数量","撤回数量","物料描述","溯源需求"};
		String filename = new String("订单组件.xlsx".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}
	
	/**
	 * 导入文件页面
	 * <br/>页面：/jcxx/components/importFile.jsp
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
		String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String fileName=getPara("attachment.fileName");
		String realPath= this.getRequest().getSession().getServletContext().getRealPath("/");
		String path=realPath+getPara("attachment.attachmentPath").substring(1);
		String excel=fileName.substring(fileName.lastIndexOf(".")+1);
		List<Map<Integer,Object>> list = ImportExcel.importExce(path, excel);
		List<Components> data=new ArrayList<Components>();
		for(Map<Integer,Object> map:list) { // 遍历取出的数据，并保存
			Components m=new Components();
			m.set("dd", map.get(0));
			m.set("wl", map.get(1));
			m.set("xmzj", map.get(2));
			m.set("xqrq", map.get(3));
			m.set("xqsl", map.get(4));
			m.set("chsl", map.get(5));
			m.set("wlms", map.get(7));
			m.set("syxq", map.get(8));
			m.set("date", date);
			m.set("state", 1);
			
			//判断导入的某条数据与数据库中的某条数据是否完全一致,如有，则不做处理
			long num1=Db.queryLong(" select count(*) as num from components where dd=? and wl=? and xmzj=? and "
					+ " xqrq=? and xqsl=? and chsl=? and wlms=? and syxq=? ",m.get("dd"),m.get("wl"),
					m.get("xmzj"),m.get("xqrq"),m.get("xqsl"),m.get("chsl"),m.get("wlms"),m.get("syxq"));
			if (num1!=0) {
				continue;
			}
			
			//判断导入的某条数据与数据库中的某条数据不完全一致，如有，需记录，
			long num2=Db.queryLong(" select count(*) as num from components where dd=? and wl=? and xmzj=?",m.getStr("dd"),m.getStr("wl"),m.getStr("xmzj"));
			if (num2!=0) {
				data.add(m);
			}
			
			m.save();
		}
		
		//判断components有没有新数据加入
		long num3=Db.queryLong(" select count(*) as num from components where date=? ", date);
		if (num3!=0) {
		//把最新的数据复制到jcxxcomponents表中
		Db.update("INSERT INTO jcxxcomponents(dd,wl,xmzj,xqrq,xqsl,chsl,wlms,syxq,date,state) " + 
				"SELECT i.dd,i.wl,i.xmzj,i.xqrq,i.xqsl,i.chsl,i.wlms,i.syxq,i.date,i.state  " + 
				"FROM components  i WHERE i.date=(SELECT MAX(DATE) AS DATE FROM components )");
		}
		
		//把components,jcxxcomponents表中的就旧数据状态改为0
		for (Components mate : data) {
		Db.update(" update jcxxcomponents set state=0 where dd=? and wl=? and xmzj=? and date!=? ",mate.get("dd"),mate.get("wl"),mate.get("xmzj"),mate.get("date"));
		Db.update(" update components set state=0 where dd=? and wl=? and xmzj=? and date!=? ",mate.get("dd"),mate.get("wl"),mate.get("xmzj"),mate.get("date"));
		}
		
		//如果存在重复数据，将数据导出
		try {
			String[] columns = {"dd","wl","xmzj","xqrq","xqsl","chsl","wlms","syxq","date"};
			String[] heades = {"订单","物料","项目组件","需求日期","需求数量","撤回数量","物料描述","溯源需求","导入时间"};
			String filename = new String("订单组件重复数据.xlsx".getBytes("UTF-8"), "ISO8859-1");
			render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 取消覆盖文件页面
	 * <br/>页面：/jcxx/components/importCancelFile.jsp
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
			Components m=new Components();
			m.set("dd", map.get(0));
			m.set("wl", map.get(1));
			m.set("xmzj", map.get(2));
			m.set("date", map.get(8));
			//将components表中的最新覆盖数据删除
			Db.update(" DELETE FROM components WHERE dd=? and wl=? and xmzj=? and date=? ",m.getStr("dd"),m.getStr("wl"),m.getStr("xmzj"),m.getStr("date"));
			//将jcxxcomponents表中的最新覆盖数据删除
			Db.update(" DELETE FROM jcxxcomponents WHERE dd=? and wl=? and xmzj=? and date=? ",m.getStr("dd"),m.getStr("wl"),m.getStr("xmzj"),m.getStr("date"));
			//把jcxxcomponents,components表中原先的最新数据状态改为1
			String date=Db.queryStr(" SELECT MAX(DATE) AS DATE FROM components where date!=? ",m.getStr("date"));
			Db.update(" update jcxxcomponents set state=1 where dd=? and wl=? and xmzj=? and date=?",m.getStr("dd"),m.getStr("wl"),m.getStr("xmzj"),date);
			Db.update(" update components set state=1 where dd=? and wl=? and xmzj=? and date=?",m.getStr("dd"),m.getStr("wl"),m.getStr("xmzj"),date);
		}
		toDwzJson(200, "取消覆盖成功！", navTabId, "", "closeCurrent");
	}
}


