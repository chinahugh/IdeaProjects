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
import com.zjkjsoft.model.SendList;
import com.zjkjsoft.util.ImportExcel;
import com.zjkjsoft.validator.RoleValidator;

/**
 * SendListController
 * 发货清单
 */

@Before(ManagerPowerInterceptor.class)
public class SendListController extends BaseController {
	private static String path="/jcxx/sendlist/";//jsp路径
	//navTabId
	private static String navTabId="sendlist";
	
	@Override
	public String action() {
                      return  "发货清单";
 }
	/**
	 * 发货清单首页
	 * <br/>页面：/jcxx/sendlist/list.jsp
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
	
	private Page<SendList> getPageData()
	{
		String sql=" FROM sendlist ";
		String selectSQL=" SELECT * ";
		String wlms=getPara("wlms");
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and wlms like '%"+wlms+"%'";	
		String jhdh=getPara("jhdh");
		if(jhdh!=null&&!"".equals(jhdh))
			sql+=" and jhdh like '%"+jhdh+"%'";	
		return SendList.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), selectSQL, sql+" order by id desc ");
	}
	/**
	 * 查看
	 * <br/>页面：/jcxx/sendlist/view.jsp
	 */
	public void view() {
		String sql=" select * from sendlist where id=? ";
		setAttr("sendlist", SendList.dao.findFirst(sql, getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加
	 * <br/>页面：/jcxx/sendlist/add.jsp
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
			SendList m=getModel(SendList.class);
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
	 * 发货清单的修改 编辑
	 * <br/>页面：/jcxx/sendlist/add.jsp
	 */
	public void edit() {
		setAttr("sendlist", SendList.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		SendList.dao.deleteById(getPara());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<SendList> data=getPageData().getList();
		String[] columns = {"jhdh","sdfmc","wl","wlms","jhdsl","tm","sbh","sbms","tmrq"};
		String[] heades = {"交货单号","送达方名称","物料","物料描述","交货单数量","条码","设备号","设备描述","条码日期"};
		String filename = new String("发货清单.xlsx".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

	
	/**
	 * 导入文件页面
	 * <br/>页面：/jcxx/sendlist/importFile.jsp
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
		List<SendList> data=new ArrayList<SendList>();
		for(Map<Integer,Object> map:list) { // 遍历取出的数据，并保存
			SendList m=new SendList();
			m.set("jhdh", map.get(1));
			m.set("sdfmc", map.get(3));
			m.set("wlh", map.get(5).toString().substring(8));
			m.set("wlms", map.get(6));
			m.set("jhdsl", map.get(7));
			m.set("tm", map.get(8));
			m.set("sbh", map.get(9).toString().substring(9));
			m.set("sbms", map.get(10));
			m.set("tmrq", map.get(11));
			m.set("date", date);
			m.set("state", 1);
			
			//判断导入的某条数据与数据库中的某条数据是否完全一致,如有，则不做处理
			long num1=Db.queryLong(" select count(*) as num from sendlist where jhdh=? and sdfmc=? and wlh=? and "
					+ " wlms=? and jhdsl=? and tm=? and sbh=? and sbms=? and tmrq=?",m.get("jhdh"),m.get("sdfmc"),
					m.get("wlh"),m.get("wlms"),m.get("jhdsl"),m.get("tm"),m.get("sbh"),m.get("sbms"),m.get("tmrq"));
			if (num1!=0) {
				continue;
			}
			
			//判断导入的某条数据与数据库中的某条数据不完全一致，如有，需记录，
			long num2=Db.queryLong(" select count(*) as num from sendlist where tm=? ",m.get("tm"));
			if (num2!=0) {
				data.add(m);
			}
			
			m.save();
		}
		
		//把sendlist表中的就旧数据状态改为0
		for (SendList mate : data) {
			Db.update(" update sendlist set state=0 where tm=? and date!=? ", mate.get("tm"),mate.get("date"));
			}
		
		//如果存在重复数据，将数据导出
		try {
			String[] columns = {"jhdh","sdfmc","wl","wlms","jhdsl","tm","sbh","sbms","tmrq","date"};
			String[] heades = {"交货单号","送达方名称","物料","物料描述","交货单数量","条码","设备号","设备描述","条码日期","导入日期"};
			String filename = new String("发货清单重复数据.xlsx".getBytes("UTF-8"), "ISO8859-1");
			render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 取消覆盖文件页面
	 * <br/>页面：/jcxx/sendlist/importCancelFile.jsp
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
			SendList m=new SendList();
			m.set("tm", map.get(5));
			m.set("date", map.get(10));
			//将sendlist表中的最新覆盖数据删除
			Db.update(" DELETE FROM sendlist WHERE tm = ? and date = ? ", m.get("tm"),m.get("date"));
			//把sendlist表中原先的最新数据状态改为1
			String date=Db.queryStr(" SELECT MAX(DATE) AS DATE FROM jcxxindent where date!=? ",m.get("date"));
			Db.update(" update sendlist set state=1 where tm=? and date=?",m.get("tm"),date);
		}
		toDwzJson(200, "取消覆盖成功！", navTabId, "", "closeCurrent");
	}
}


