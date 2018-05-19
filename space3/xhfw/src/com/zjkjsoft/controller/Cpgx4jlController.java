package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jfinal.aop.Before;

import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Cpjcjl;
import com.zjkjsoft.model.Cpjcjlxm;
import com.zjkjsoft.model.Cpjcxm;
import com.zjkjsoft.model.Indbind;
import com.zjkjsoft.model.Product;
import com.zjkjsoft.model.Cpcssz;
import com.zjkjsoft.model.Cpjc;
import com.zjkjsoft.validator.RoleValidator;

/**
 * 产品加工记录
 */

@Before(ManagerPowerInterceptor.class)
public class Cpgx4jlController extends BaseController {
	private static String path="/scxx/cpgx4jl/";//jsp路径
	//navTabId
	private static String navTabId="cpgx4jl";
	private static String key="mc";//查询关键字字段名
	
	@Override
	public String action() {
                      return  "条码绑定记录";
 }
	/**
	 * 产品测试记录首页
	 * <br/>页面：/scxx/cpcs/list.jsp
	 */
	@Override
	public void index() {
		list() ;
	}
	/**
	 * 模糊查询
	 */
	public void list() {
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	/**
	 * 模糊查询
	 */
	public void listw() {
		setAttr("page", getPageDataw());
		render(path+"listw.jsp");
	}
	
	private Page<Cpjcjl> getPageData()
	{
		String keywords=getPara("keywords");
		String sql="from cpjcjl a, cpjcjd b where a.state=1 and a.fid=b.fid and a.lx=b.lx  and  a.lx=5  ";
		//管理员  1
		//部门领导
		//操作者
		if("管理员".equals(getSessionAttr("username"))) {
			
		}else {
			sql+=" and  a.jcry='"+getSessionAttr("username")+"' ";
		}
		if(keywords!=null&&!"".equals(keywords))
			sql+=" and  a."+key+" like '%"+keywords+"%' ";	
		return  Cpjcjl.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select a.*,b.mc mc1 ", sql+" order by id desc");
	}
	private Page<Cpjcjl> getPageDataw()
	{
		String keywords=getPara("keywords");
		String sql="from cpjcjl where lx=4  ";
		//管理员  1
		//部门领导
		//操作者
		if("管理员".equals(getSessionAttr("username"))) {
			
		}else {
			sql+=" and  jcry='"+getSessionAttr("username")+"' ";
		}
		if(keywords!=null&&!"".equals(keywords))
			sql+=" and  "+key+" like '%"+keywords+"%' ";	
		return  Cpjcjl.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc");
	}
	
	/**
	 * 查看
	 * <br/>页面：/xtgl/role/view.jsp
	 */
	public void view() {
		String sql=" select a.*,b.mc mc1 from cpjcjl a, cpjcjd b where a.state=1 and a.fid=b.fid and a.lx=b.lx  and  a.lx=5 and a.id=? ";
		setAttr("cpjcjl", Cpjcjl.dao.findFirst(sql, getParaToInt()));
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
	 * 角色的修改 编辑
	 * <br/>页面：/xtgl/role/add.jsp
	 */
	public void addlx() {
		Cpjcjl m=getModel(Cpjcjl.class);
		
		String txm=m.get("txm");
		// 测试  1000031185
		//long  c=Db.queryLong("select count(1) from cpjcjl  where txm=?",txm);
		//Cpjcjl  jl= Cpjcjl.dao.findFirst("select * from cpjcjl  where state=1 and txm=? order by id desc",txm);
		Cpjc  jl= Cpjc.dao.findFirst("select * from cpjc  where  txm=? order by id desc",txm);
		if(jl!=null) {
		//根据条形码查找物料记录到那个检测点
		//根据检测项目节点及检测项目
			setAttr("cpjcjl", jl);
//			List<Cpjcxm> xmL= Cpjcxm.dao.find("select * from cpjcxm  where "
//					+ "fid=(select id from cpjcjd  where lx=5 and fid=? )",jl.getInt("fid"));
			List<Indbind> xmL= Indbind.dao.find("select wlh from indbind  where dd=? and fwlh=? and fid=?"
					,jl.get("dd"),jl.get("wlh"),jl.get("fid"));
			setAttr("xmL", xmL);
		}else {
			setAttr("msg", "系统没有加工记录");
		}	
		
			render(path+"addLR.jsp");		
	}
	
	/**
	 * 保存数据到数据库
	 */

	public void save() {

		try{
			Cpjcjl m=getModel(Cpjcjl.class);
			m.set("jcry", this.getSessionAttr("username"));
			m.set("jcrq", sfs.format(new Date()));			
			if(m.get("id")!=null){
				m.update();
toDwzJson(200,"修改操作成功",navTabId,"","closeCurrent");
			}else{
				//m.set("id", "js_seq.nextval");
				int xh=m.getInt("xh");

				Cpjc  cpjc=getModel(Cpjc.class);

				
				cpjc.set("xh", 1).set("lx", 5).set("jid", m.getInt("id")).update();
				String[] mc=this.getParaValues("mc");
				if(mc!=null) {
				String[] sz=this.getParaValues("sz");
				int i=0;
				for(String c:mc) {
					m.set("lx", 5).set("state", 1).set("mc", c).set("ms", sz[i++]).save();
					m.remove("id");
				}
				// 绑定ids 修改 记录
				}
toDwzJson(200,"新增操作成功",navTabId,"","closeCurrent");
				
			}
//			String[] mc=this.getParaValues("mc");
//			if(mc!=null) {
//			String[] sz=this.getParaValues("sz");
//			int i=0;
//			//先删后加  db.
//			//Db.update(sql)
//			for(String c:mc) {
//				Cpjcjlxm xm= new Cpjcjlxm();
//				xm.set("fid", m.getInt("fid")).set("xid", c).set("sz", sz[i++]).save();
//			}
//			}
//			toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
		}catch(Exception e){
			toDwzJson( 300, "保存异常！",navTabId);
		}
	}
	
	/**
	 * 角色的修改 编辑
	 * <br/>页面：/xtgl/role/add.jsp
	 */
	public void edit() {
		setAttr("cpjcjl", Cpjcjl.dao.findById(getParaToInt()));
		render(path+"edit.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Cpjcjl.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	/**
	 * 删除
	 */
	public void jiebang() {
		Cpjcjl.dao.findById(getParaToInt()).set("ms", null).update();
		toDwzJson( 200, "解绑成功！", navTabId);
	}
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Cpjcjl> data=getPageData().getList();
		String[] columns = {"txm","wlh","mc1","mc","ms","jcry","jcrq"};
		String[] heades = {"条码","物料","工序","组件","条码","操作人","操作时间"};
		String filename = new String("条码绑定.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

}


