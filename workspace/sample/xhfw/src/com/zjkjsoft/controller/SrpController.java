package com.zjkjsoft.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.zjkjsoft.element.PageElement;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Srp;
import com.zjkjsoft.model.Suser;
import com.zjkjsoft.validator.RolfunValidator;

/**
 * 角色管理
 */

@Before(ManagerPowerInterceptor.class)
public class SrpController extends BaseController {
	private static String path="/xtgl/rolpro/";//jsp路径
	//navTabId
	private static String navTabId="rolpro";
	@Override
	public String action() {
                      return  "角色产品";
 }
	
	/**
	 * 到 角色菜单的首页
	 * <br/>页面：/xtgl/rolfun/index.jsp
	 */
	@Override
	public void index() {
		setAttr("treeJSStr", PageElement.getTreeC1("select * from srole where  id>? order by xh ,id ", Integer.valueOf(0), "srp/list/","srpBox", "mc"));
		render(path+"index.jsp");
	}
	
	/**
	 * 到角色菜单的列表
	 * <br/>页面：/xtgl/rolfun/list.jsp
	 */
	public void list() {
		List<Record> list = Db.find("select * from srp where  id="+getParaToInt() +" order by id ");
		Set<Integer> set=new HashSet<Integer>();
		for (int i = 0; i < list.size(); i++) {
			set.add(list.get(i).getInt("pid"));
		}
		setAttr("treeJSCDStr", PageElement.getTreeCheckRP("select * from product where id>? order by id", Integer.valueOf(0), "pid",set));
		setAttr("id",getParaToInt() );
		setAttr("yhmcs",getYhmcsByJsid(getParaToInt()) );
		render(path+"list.jsp");
	}

	/**
	 * 修改、添加角色，保存到数据库
	 */
	@Before(RolfunValidator.class)
	public void save() {

		try{
			Srp m=getModel(Srp.class);
			int id=m.get("id");
			Srp.dao.deleteById(id);
			String[] pids= this.getParaValues("pid");
			if (pids==null) {
				toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
			}else {
				for(int i=0;i<pids.length;i++){
					m.set("id", id).set("pid", pids[i]);
					m.save();
					toDwzJson(200,"新增操作成功",navTabId,"","closeCurrent");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			toDwzJson( 300, "保存异常！",navTabId);
		}
	}
  private String  getYhmcsByJsid(Integer jsid){
	  String str="";
	  List<Suser> list =Suser.dao.find("select username from suser t where rid="+jsid+"");
	  for(int i=0;i<list.size();i++)
		  str+=list.get(i).getStr("username")+"\n";
	  return  str;
  }
}


