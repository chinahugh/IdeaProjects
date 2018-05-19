package com.zjkjsoft.controller;
import java.io.UnsupportedEncodingException;
import java.util.List;
import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.JcxxMaterial;
import com.zjkjsoft.model.Productkey;
import com.zjkjsoft.validator.RoleValidator;

/**
 * ProductkeyController
 * 关键件管理
 */

@Before(ManagerPowerInterceptor.class)
public class ProductkeyCXController extends BaseController {
	private static String path="/zhcx/productkey/";//jsp路径
	//navTabId
	private static String navTabId="productkeyCX";
	
	@Override
	public String action() {
                      return  "物料查询";
 }
	/**
	 * 关键件管理首页
	 * <br/>页面：/jcxx/productkey/list.jsp
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
	
	private Page<JcxxMaterial> getPageData()
	{
		String wlms=getPara("wlms");
		String sql=" from jcxxmaterial where 1=1 ";
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and wlms like '%"+wlms+"%' ";	
		String wlh=getPara("wlh");
		if(wlh!=null&&!"".equals(wlh))
			sql+=" and wlh like '%"+wlh+"%' ";	
		String wlth=getPara("wlth");
		if(wlth!=null&&!"".equals(wlth))
			sql+=" and wlth like '%"+wlth+"%' ";	
		String ggxh=getPara("ggxh");
		if(ggxh!=null&&!"".equals(ggxh))
			sql+=" and ggxh like '%"+ggxh+"%' ";	
		return JcxxMaterial.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	/**
	 * 查看
	 * <br/>页面：/jcxx/productkey/view.jsp
	 */
	public void view() {
		setAttr("jcxxmaterial", JcxxMaterial.dao.findById(getParaToInt()));
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
		List<JcxxMaterial> data=getPageData().getList();
		String[] columns = {"gc","wlh","wlms","wlth","ggxh"};
		String[] heades = {"工厂","物料号","物料描述","物料图号","规格型号"};
		String filename = new String("物料信息.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

}
