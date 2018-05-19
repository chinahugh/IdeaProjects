package com.zjkjsoft.controller;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.zjkjsoft.element.PageElement;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Srcd;
import com.zjkjsoft.model.Suser;
import com.zjkjsoft.validator.RolfunValidator;

/**
 * 角色管理
 */

@Before(ManagerPowerInterceptor.class)
public class SrcdController extends BaseController {
	private static String path="/xtgl/rolfun/";//jsp路径
	//navTabId
	private static String navTabId="rolfun";
	@Override
	public String action() {
                      return  "角色菜单";
 }
	
	/**
	 * 到 角色菜单的首页
	 * <br/>页面：/xtgl/rolfun/index.jsp
	 */
	@Override
	public void index() {
		setAttr("treeJSStr", PageElement.getTreeC1("select * from srole where  id>? order by xh ,id ", Integer.valueOf(0), "srcd/list/","jscdBox", "mc"));
		render(path+"index.jsp");
	}
	
	/**
	 * 到角色菜单的列表
	 * <br/>页面：/xtgl/rolfun/list.jsp
	 */
	public void list() {
		List<Record> list = Db.find("select * from srcd where  id="+getParaToInt() +" order by id ");
		Set<Integer> set=new HashSet<Integer>();
		for (int i = 0; i < list.size(); i++) {
			set.add(list.get(i).getInt("fid"));
		}
		setAttr("treeJSCDStr", PageElement.getTreeCheck("select * from sfucn where  fid=? order by xh ,id", Integer.valueOf(0),  "fid",set));
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
			Srcd m=getModel(Srcd.class);
			Integer id=m.get("id");
			Srcd.dao.deleteById(id);
			String[] fids= this.getParaValues("fid");
			for(int i=0;i<fids.length;i++){
				m.set("id", id).set("fid", fids[i]);
				m.save();
//toDwzJson(200,"新增操作成功",navTabId,"","closeCurrent");
			}
			toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
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


