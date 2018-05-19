package com.zjkjsoft.controller;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.zjkjsoft.element.PageElement;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Product;
import com.zjkjsoft.model.Srcs;
import com.zjkjsoft.model.Suser;
import com.zjkjsoft.validator.RoleValidator;
import com.zjkjsoft.validator.RolfunValidator;

/**
 * ProductController
 * 产品管理
 */

@Before(ManagerPowerInterceptor.class)
public class ProductPZController extends BaseController {
	private static String path="/xtgl/cppz/";//jsp路径
	//navTabId
	private static String navTabId="productPZ";
	@Override
	public String action() {
                      return  "角色参数";
 }
	
	/**
	 * 到 角色菜单的首页
	 * <br/>页面：/xtgl/rolfun/index.jsp
	 */
	@Override
	public void index() {
		setAttr("treeJSStr", PageElement.getTreeC1("select * from scode where  fid=? order by xh ,id ", Integer.valueOf(3), "productPZ/list/","cppzBox", "mc"));
		render(path+"index.jsp");
	}
	
	/**
	 * 到角色菜单的列表
	 * <br/>页面：/xtgl/rolfun/list.jsp
	 */
	public void list() {
		List<Record> list = Db.find("select * from srcs where  id="+getParaToInt() +" order by id ");
		Set<Integer> set=new java.util.HashSet();
		for (int i = 0; i < list.size(); i++) {
			set.add(list.get(i).getInt("fid"));
		}
		setAttr("treeJSCDStr", PageElement.getTreeCheck("select * from scode where  fid=? order by xh ,id", Integer.valueOf(4),  "fid",set));
		setAttr("id",getParaToInt() );
		setAttr("yhmcs",getYhmcsByJsid(getParaToInt()) );
		render(path+"list.jsp");
	}

  private String  getYhmcsByJsid(Integer jsid){
	  String str="";
	  List<Suser> list =Suser.dao.find("select username from suser t where rid="+jsid+"");
	  for(int i=0;i<list.size();i++)
		  str+=list.get(i).getStr("username")+"\n";
	  return  str;
  }


	
	private Page<Product> getPageData()
	{
		String keywords=getPara("keywords");
		String sql="from product  order by id desc";
		if(keywords!=null&&!"".equals(keywords))
			sql="from product where MC like '%"+keywords+"%' order by id desc";	
		return Product.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql);
	}
	/**
	 * 查看
	 * <br/>页面：/jcxx/product/view.jsp
	 */
	public void view() {
		setAttr("product", Product.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加产品
	 * <br/>页面：/jcxx/product/add.jsp
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
			Product m=getModel(Product.class);
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
	 * 产品的修改 编辑
	 * <br/>页面：/jcxx/product/add.jsp
	 */
	public void edit() {
		setAttr("product", Product.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Product.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Product> data=getPageData().getList();
		String[] columns = {"mc","ms"};
		String[] heades = {"名称","描述"};
		String filename = new String("产品管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

}