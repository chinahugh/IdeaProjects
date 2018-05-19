package com.zjkjsoft.controller;
import java.io.UnsupportedEncodingException;
import java.util.List;
import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Productkey;
import com.zjkjsoft.validator.RoleValidator;

/**
 * ProductkeyController
 * 关键件管理
 */

@Before(ManagerPowerInterceptor.class)
public class ProductkeyController extends BaseController {
	private static String path="/scxx/productkey/";//jsp路径
	//navTabId
	private static String navTabId="productkey";
	private static String key="mc";//查询关键字字段名
	
	@Override
	public String action() {
                      return  "关键件管理";
 }
	/**
	 * 关键件管理首页
	 * <br/>页面：/jcxx/productkey/list.jsp
	 */
	@Override
	public void index() {
		String keywords=getPara("keywords");
		String sql="from productkey  order by id desc";
		if(keywords!=null&&!"".equals(keywords))
			sql="from productkey where "+key+" like '%"+keywords+"%' order by id desc";	
		setAttr("page", Productkey.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql));
		render(path+"list.jsp");
	}
	/**
	 * 模糊查询
	 */
	public void list() {
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	
	private Page<Productkey> getPageData()
	{
		String keywords=getPara("keywords");
		String sql="from productkey  order by id desc";
		if(keywords!=null&&!"".equals(keywords))
			sql="from productkey where "+key+" like '%"+keywords+"%' order by id desc";	
		return Productkey.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql);
	}
	/**
	 * 查看
	 * <br/>页面：/jcxx/productkey/view.jsp
	 */
	public void view() {
		setAttr("productkey", Productkey.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}

	/**
	 * 添加关键件
	 * <br/>页面：/jcxx/productkey/add.jsp
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
			Productkey m=getModel(Productkey.class);
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
	 * 关键件的修改 编辑
	 * <br/>页面：/jcxx/productkey/add.jsp
	 */
	public void edit() {
		setAttr("productkey", Productkey.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除
	 */
	public void delete() {
		Productkey.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Productkey> data=getPageData().getList();
		String[] columns = {"mc","ms"};
		String[] heades = {"名称","描述"};
		String filename = new String("关键件管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

}
