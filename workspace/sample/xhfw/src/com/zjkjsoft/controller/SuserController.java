package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;



import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Srole;
import com.zjkjsoft.model.Suser;
import com.zjkjsoft.util.MD5;
import com.zjkjsoft.validator.UsersValidator;

/**
 * UserController
 * 用户管理
 */

@Before(ManagerPowerInterceptor.class)
public class SuserController extends BaseController {
	private static String path="/xtgl/yh/";//jsp路径
	//navTabId
	private static String navTabId="suser";
	private static String key="mc";//查询关键字字段名
	
	@Override
	public String action() {
                      return  "用户帐号表";
 }
	
	/**
	 * 用户管理首页
	 * <br/>页面：/xtgl/yh/list.jsp
	 */
	@Override
	public void index()
	{
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
		
	/**
	 * 查看用户的详细信息
	 * <br/>页面：/xtgl/yh/view.jsp
	 */
	public void view() {
		Suser user=Suser.dao.findById(getParaToInt());
		setAttr("suser", user);
		setAttr("rolName", Srole.dao.findById(user.getInt("rid")).get("mc"));
		render(path+"view.jsp");
	}
	

	/**
	 * 新建用户
	 * <br/>页面：/xtgl/yh/add.jsp
	 */
	public void add() {
		setAttr("roles", Srole.dao.find("select * from srole"));
		render(path+"add.jsp");
	}
	
	/**
	 * 保存用户信息到数据库
	 */
	public void save()
	{
		try
		{
			Suser m=getModel(Suser.class);
			if(m.get("id")!=null)
			{
				if(m.passwordIsChanged())
					m.convertPasswordToMD5();
				m.update();
				toDwzJson(200, "修改操作成功", navTabId, "", "closeCurrent");
			}
			else
			{
				if(m.hasUser())
					toDwzJson(300, "用户已经存在", navTabId, "", "closeCurrent");
				else
				{
					m.convertPasswordToMD5();
					m.save();
					toDwzJson(200, "新增操作成功", navTabId, "", "closeCurrent");
				}
			}
		}
		catch(Exception e)
		{
			toDwzJson( 300, "保存异常！",navTabId);
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改用户的信息
	 * <br/>页面：/xtgl/yh/add.jsp
	 */
	public void edit() {
		setAttr("suser", Suser.dao.findById(getParaToInt()));
		add();
	}
	
	/**
	 * 删除yonghu
	 */
	public void delete() {
		Suser.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	private Page<Suser> getPageData()
	{
		String keywords=getPara("keywords");
		String selectSQL=" SELECT u.id, u.loginname, u.username, r.mc ";
		String fromSQL=" FROM suser u, srole r WHERE u.rid=r.id ";
		if(keywords!=null&&!keywords.isEmpty())
			fromSQL+=" where u."+key+" like '%"+keywords+"%' ";	
		fromSQL+=" order by u.id desc ";
		return Suser.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), selectSQL, fromSQL);
	}
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException {
		List<Suser> data=getPageData().getList();
		String[] columns = {"loginname","username","mc"};
		String[] heades = {"帐号","员工姓名","角色"};
		String filename = new String("用户管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

}


