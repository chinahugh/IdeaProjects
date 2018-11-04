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
import com.zjkjsoft.common.IndexController;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Indent;
import com.zjkjsoft.model.Material;
import com.zjkjsoft.util.ImportExcel;
import com.zjkjsoft.validator.RoleValidator;

/**
 * IndentController
 * 订单抬头
 */

@Before(ManagerPowerInterceptor.class)
public class IndentController extends BaseController {
	private static String path="/jcxx/indent/";//jsp路径
	//navTabId
	private static String navTabId="indent";
	
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
	
	private Page<Indent> getPageData()
	{
		String sql;
		String status=getPara("status1");
		long count=Db.queryLong("select count(*) as count from indent where state=1");
		if(status!=null&&!"".equals(status)) {
			if (count!=0) {
				sql=" from indent where 1=1 and state=1";
			} else {
				sql=" from indent where 1=1 ";
			}
			sql+=" and status like '%"+status+"%' ";	
		}else {
			if (count!=0) {
				sql=" from indent where status='未完成' and state=1";
			} else {
				sql=" from indent where status='未完成' ";
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
		return Indent.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	/**
	 * 查看
	 * <br/>页面：/jcxx/indent/view.jsp
	 */
	public void view() {
		setAttr("indent", Indent.dao.findById(getParaToInt()));
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
		List<Indent> data=getPageData().getList();
		String[] columns = {"dd","wl","ddlx","ddsl","jbksrq","jbwcrq","xtzt","wlms"};
		String[] heades = {"订单","物料","订单类型","订单数量","基本开始日期","基本完成日期","系统状态","物料描述"};
		String filename = new String("订单抬头.xlsx".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}
	
	/**
	 * 导入文件页面
	 * <br/>页面：/jcxx/indent/importFile.jsp
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
		List<Indent> data=new ArrayList<Indent>();
		for(Map<Integer,Object> map:list) { // 遍历取出的数据，并保存
			Indent m=new Indent();
			m.set("dd", map.get(0));
			m.set("wl", map.get(1));
			m.set("ddlx", map.get(3));
			m.set("mrpkzz", map.get(4));
			m.set("ddsl", map.get(7));
			m.set("jbksrq", map.get(9));
			m.set("jbwcrq", map.get(10));
			m.set("xtzt", map.get(12));
			m.set("wlms", map.get(14));
			m.set("date", date);
			m.set("state", 1);
			m.set("status", "未完成");
			
			//判断导入的某条数据与数据库中的某条数据是否完全一致,如有，则不做处理
			long num1=Db.queryLong(" select count(*) as num from indent where dd=? and wl=? and ddlx=? and "
					+ " ddsl=? and jbksrq=? and jbwcrq=? and xtzt=? and wlms=? ",m.get("dd"),m.get("wl"),
					m.get("ddlx"),m.get("ddsl"),m.get("jbksrq"),m.get("jbwcrq"),m.get("xtzt"),m.get("wlms"));
			if (num1!=0) {
				continue;
			}
			//判断导入的某条数据与数据库中的某条数据不完全一致，如有，需记录，
			long num2=Db.queryLong(" select count(*) as num from indent where dd=? ",m.get("dd"));
			if (num2!=0) {
				data.add(m);
			}
			m.save();
		}
		
		//判断indent有没有新数据加入
		long num3=Db.queryLong(" select count(*) as num from indent where date=? ", date);
		if (num3!=0) {
		//把最新的数据复制到jcxxindent表中
			Db.update("INSERT INTO jcxxindent(dd,wl,ddlx,ddsl,jbksrq,jbwcrq,xtzt,wlms,date,state,mrpkzz,status) SELECT i.dd, " + 
					"i.wl,i.ddlx,i.ddsl,i.jbksrq,i.jbwcrq,i.xtzt,i.wlms,i.date,i.state,i.mrpkzz,i.status FROM indent i " + 
					"WHERE i.date=(SELECT MAX(DATE) AS DATE FROM indent )");
		}
		
		//把indent,jcxxindent表中的就旧数据状态改为0
		for (Indent mate : data) {
		Db.update(" update jcxxindent set state=0 where dd=? and date!=? ", mate.get("dd"),mate.get("date"));
		Db.update(" update indent set state=0 where dd=? and date!=? ", mate.get("dd"),mate.get("date"));
		}
		
		//如果存在重复数据，将数据导出
		try {
			String[] columns = {"dd","wl","ddlx","ddsl","jbksrq","jbwcrq","xtzt","wlms","date"};
			String[] heades = {"订单","物料","订单类型","订单数量","基本开始日期","基本完成日期","系统状态","物料描述","导入日期"};
			String filename = new String("生产订单重复数据.xlsx".getBytes("UTF-8"), "ISO8859-1");
			render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * 取消覆盖文件页面
	 * <br/>页面：/jcxx/indent/importCancelFile.jsp
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
			Indent m=new Indent();
			m.set("dd", map.get(0));
			m.set("date", map.get(8));
			//将indent表中的最新覆盖数据删除
			Db.update(" DELETE FROM indent WHERE dd = ? and date = ? ", m.get("dd"),m.get("date"));
			//将jcxxindent表中的最新覆盖数据删除
			Db.update(" DELETE FROM jcxxindent WHERE dd = ? and date = ? ", m.get("dd"),m.get("date"));
			//把jcxxindent,indent表中原先的最新数据状态改为1
			String date=Db.queryStr(" SELECT MAX(DATE) AS DATE FROM indent where date!=? ",m.get("date"));
			Db.update(" update jcxxindent set state=1 where dd=? and date=?",m.get("dd"),date);
			Db.update(" update indent set state=1 where dd=? and date=?",m.get("dd"),date);
		}
		toDwzJson(200, "取消覆盖成功！", navTabId, "", "closeCurrent");
	}
	

}


