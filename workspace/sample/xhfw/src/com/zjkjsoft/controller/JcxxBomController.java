package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;


import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.JcxxBom;
import com.zjkjsoft.model.JcxxMaterial;
import com.zjkjsoft.model.ProBbh;
import com.zjkjsoft.model.Product;
import com.zjkjsoft.model.Suser;

/**
 * JcxxBomController
 * bom信息
 */

@Before(ManagerPowerInterceptor.class)
public class JcxxBomController extends BaseController {
	private static String path="/jcxx/jcxxbom/";//jsp路径
	//navTabId
	private static String navTabId="jcxxbom";
	
	@Override
	public String action() {
                      return  "BOM管理";
 }
	/**
	 * BOM信息首页
	 * <br/>页面：/jcxx/jcxxbom/list.jsp
	 */
	@Override
	public void index() {
		
		Suser suser=this.getSessionAttr("user");
		setAttr("flag", suser.getInt("rid"));
		
		String wlh=getPara("wlh");
		 if (wlh!=null&&!"".equals(wlh)) {
			List<Product>list=Product.dao.find(" select id,wlh,wlms from product where wlh=? order by id desc ",wlh);
			if (list.size()>0) {
				setAttr("list",JcxxBom.getList(list));
			} else {
				List<Product>list1=Product.dao.find(" SELECT  DISTINCT p.id,p.wlh,p.wlms FROM product p INNER JOIN jcxxbom jb ON p.id=jb.fid AND jb.zj=? order by p.id desc ",wlh);
				setAttr("list",JcxxBom.searchList(list1, wlh));
			}
		}else {
			List<Product>list=Product.dao.find(" select id,wlh,wlms from product order by id desc ");
			setAttr("list",JcxxBom.getList(list));
		}
		render(path+"index.jsp");
	}
	
	
	/**
	 * 组件列表
	 */
	public void list() {
		Suser suser=this.getSessionAttr("user");
		setAttr("flag", suser.getInt("rid"));
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	
	/**
	 * 产品列表
	 */
	public void list1() {
		Suser suser=this.getSessionAttr("user");
		setAttr("flag", suser.getInt("rid"));
		setAttr("page", getPageData1());
		render(path+"list1.jsp");
	}
	
	private Page<Product> getPageData1()
	{
		String wlh=getPara(0);
		String id=getPara(1);
		setAttr("wlh", wlh);
		setAttr("id", id);
		String sql=" FROM product p left join probbh pb on p.id=pb.fid  where p.wlh='"+wlh+"' and p.id="+id;
		String selectSQL=" SELECT p.wlh,p.wlms,pb.id,pb.fid,pb.bbh ";
		String wlm=getPara("wlm");
		if(wlm!=null&&!"".equals(wlm))
			sql+=" and wlm like '%"+wlm+"%' ";	
		String wlh1=getPara("wlh");
		if(wlh1!=null&&!"".equals(wlh1))
			sql+=" and wlh like '%"+wlh1+"%' ";		
		return Product.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), selectSQL , sql+" order by id desc ");
	}
	
	private Page<JcxxBom> getPageData()
	{
		String wlh=getPara(0);
		String fid=getPara(1);
		String bbh=getPara(2);
		setAttr("wlh", wlh);
		setAttr("fid", fid);
		setAttr("bbh", bbh);
		String sql=" FROM jcxxbom  where wlh='"+wlh+"' and fid="+fid+" and bbh="+bbh;
		String selectSQL=" SELECT * ";
		String zjms=getPara("zjms");
		if(zjms!=null&&!"".equals(zjms))
			sql+=" and zjms like '%"+zjms+"%' ";		
		String zj=getPara("zj");
		if(zj!=null&&!"".equals(zj))
			sql+=" and zj like '%"+zj+"%' ";		
		return JcxxBom.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), selectSQL , sql+" order by id desc ");
	}
	
	/**
	 * 查看jcxxbom
	 * <br/>页面：/jcxx/bom/view.jsp
	 */
	public void view() {
		setAttr("jcxxbom", JcxxBom.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}
	
	/**
	 * 查看一个产品中有多少个版本
	 * <br/>页面：/jcxx/bom/view1.jsp
	 */
	public void view1() {
		int id=Db.queryInt("select fid from probbh where id=?", getParaToInt());
		String sql=" select p.wlh,p.wlm,pb.id,pb.fid,pb.bbh FROM product p left join probbh pb on p.id=pb.fid where p.id=?";
		setAttr("product", Product.dao.findFirst(sql, id));
		render(path+"view1.jsp");
	}

	/**
	 * 添加
	 * <br/>页面：/jcxx/bom/add.jsp
	 */
	public void add() {
		String sql=" SELECT wlh,wlms,wlth,fid,bbh FROM jcxxbom where wlh=? and fid=? and bbh=?";
		JcxxBom jcxxbom=JcxxBom.dao.findFirst(sql, getPara(0),getPara(1),getPara(2));
		if (jcxxbom==null){
			JcxxMaterial jm=JcxxMaterial.dao.findFirst("select * from jcxxmaterial where state=1 and wlh=?", getPara(0));
			if (jm==null) {
				setAttr("msg", "该物料信息不存在");
				render(path+"add.jsp");
				return;
			}
			jcxxbom=new JcxxBom();
			jcxxbom.set("wlh", jm.get("wlh"));
			jcxxbom.set("wlms", jm.get("wlms"));
			jcxxbom.set("wlth", jm.get("wlth"));
			jcxxbom.set("fid", getPara(1));
			jcxxbom.set("bbh", getPara(2));
		}
		setAttr("jcxxBom", jcxxbom);
		render(path+"add.jsp");
	}
	
	/**
	 * 添加产品中的一个子产品
	 * <br/>页面：/jcxx/bom/add1.jsp
	 */
	public void add1() {
		String sql=" select * from product where id=? ";
		Product pro=Product.dao.findFirst(sql, getPara(1));
		setAttr("product", pro);
		setAttr("id", getPara(0));
		render(path+"add1.jsp");
	}
	 
	 
	/**
	 * 保存jcxxbom到数据库
	 */ 
	public void save() {

		try{
			//Material material=getModel(Material.class);
			//Material m=Material.dao.findFirst("select * from naterial where wl=?", material.get("wl"));
			JcxxBom b=getModel(JcxxBom.class);
			if(b.get("id")!=null){
				b.update(); 
				toDwzJson(200,"修改操作成功",navTabId,"","closeCurrent");
			}else{
				//m.set("id", "js_seq.nextval");
				JcxxBom jcxxbom=JcxxBom.dao.findFirst("select * from jcxxbom where zj=? and bbh=? and fid=?",b.get("zj"),b.get("bbh"),b.get("fid"));
				if (jcxxbom!=null) {
					toDwzJson(200,"不能添加该组件",navTabId);
				}else {
					b.save();
					toDwzJson(200,"新增操作成功",navTabId,"","closeCurrent");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			toDwzJson( 300, "保存异常！",navTabId);
		}
	}
	
	/**
	 * 保存probbh到数据库,给某产品添加一个有版本号的产品
	 */ 
	public void save1() {
		
		try{
			Product b=getModel(Product.class);
			ProBbh p=getModel(ProBbh.class);
			int id=getParaToInt("id");
			if(b.get("id")!=null&&p.get("id")!=null){
				Db.update(" update probbh set bbh=? where id=? ", p.get("bbh"),p.get("id"));
				toDwzJson(200,"修改操作成功",navTabId,"","closeCurrent");
			}else{
				//m.set("id", "js_seq.nextval");
				//被复制产品的bbh
				String bbh=Db.queryStr(" select bbh from probbh where id=?", id);
				p.set("fid", b.get("id"));
				Db.update(" INSERT INTO jcxxbom (wlh,wlms,wlth,zj,zjms,zjsl,zjth) " + 
						" SELECT b.wlh,b.wlms,b.wlth,b.zj,b.zjms,b.zjsl,b.zjth " + 
						" FROM jcxxbom b WHERE b.fid=? and b.bbh=? ",b.get("id"),bbh);
				Db.update(" update jcxxbom set fid=?,bbh=? where fid is null and bbh is null", b.get("id"),p.get("bbh"));
				p.save();
				toDwzJson(200,"新增操作成功",navTabId,"","closeCurrent");
			}
			//toDwzJson(200,"操作成功",navTabId,"","closeCurrent"); 
		}catch(Exception e){
			e.printStackTrace();
			toDwzJson( 300, "保存异常！",navTabId);
		}
	}
	
	/**
	 * BOM的修改 编辑
	 * <br/>页面：/jcxx/bom/add.jsp
	 */
	public void edit() {
		setAttr("jcxxBom", JcxxBom.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	
	
	/**
	 * 删除jcxxbom
	 */
	public void delete() {
		JcxxBom.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	/**
	 * 删除子产品
	 */
	public void delete1() {
		int id=getParaToInt();
		ProBbh probbh=ProBbh.dao.findById(id);
		Db.update(" delete from jcxxbom where fid=? and bbh=? ",probbh.get("fid"),probbh.get("bbh"));
		ProBbh.dao.deleteById(id);
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<JcxxBom> data=getPageData().getList();
		String[] columns = {"wl","zj","zjms","zjsl","zjth"};
		String[] heades = {"物料","组件","组件描述","组件数量","组件图号"};
		String filename = new String("BOM信息.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

	
}


