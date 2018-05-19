package com.zjkjsoft.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Sms;
import com.zjkjsoft.util.SMSUtil;
import com.zjkjsoft.util.WxUtil;
import com.zjkjsoft.validator.FucnValidator;

/**
 * 系统菜单
 */

@Before(ManagerPowerInterceptor.class)
public class WxController extends BaseController {
	private static String path="/xtgl/wx/";//jsp路径
	//navTabId
	private static String navTabId="sx";
	private static String key="mc";//查询关键字字段名
	
	@Override
	public String action() {
                      return  "系统菜单";
 }
	
	/**
	 * 系统菜单的首页
	 * <br/>页面 ：/xtgl/fucn/index.jsp
	 */
	@Override
	public void index() {
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	/**
	 * 查看
	 * <br/>页面 ：/xtgl/fucn/view.jsp
	 */
	public void view() {
		setAttr("wx", Sms.dao.findById(getParaToInt()));
		render(path+"view.jsp");
	}
	
	/**
	 * 到 添加 菜单的页面
	 * <br/>页面 ：/xtgl/fucn/add.jsp
	 */
	public void add() {
		redirect(path+"add.jsp");
	}
	
	/**
	 * 保存 添加的菜单到数据库
	 */

	public void save() {
		String mobile="";
		String tstype=getPara("tstype");
		String content=getPara("content");
		if("sms".equals(tstype)){
			System.out.println("短信推送-------->");
			mobile=getPara("mobile");
			//HttpClient 
			try{
				//Sms m=getModel(Sms.class);  //m.getInt("userid")
				if(SMSUtil.dxdf(1, mobile, content))
					toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
				else
					toDwzJson(300,"操作失败",navTabId,"","closeCurrent");
				
			}catch(Exception e){
				e.printStackTrace();
				toDwzJson( 300, "操作异常！",navTabId);
			}
		}
		else {
			System.out.println("微信推送-------->");
			WxUtil.sendRequest(content);
		    toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
			
		}
		
		
		
		
	}
	
	/**
	 * 编辑菜单
	 * <br/>页面：/xtgl/fucn/add.jsp
	 */
	public void edit() {
		setAttr("sms", Sms.dao.findById(getParaToInt()));
		render(path+"add.jsp");
	}
	
	/**
	 * 删除菜单
	 */
	public void delete() {
		Sms.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	
	private Page<Sms> getPageData()
	{
		String keywords=getPara("keywords");
		String sql=" from  sms a, suser b where a.userid=b.id   order by id desc";
		if(keywords!=null&&!keywords.isEmpty())
			sql="  from  sms a, suser b where a.userid=b.id  and  "+key+" like '%"+keywords+"%' order by id desc";	
		return Sms.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select  a.*,b.username  ", sql);
	}
	
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException 
	{
		List<Sms> data=getPageData().getList();
		String[] columns = {"mc", "fid", "link"};
		String[] heades = {"名称", "父编号", "路径"};
		String filename = new String("功能管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}

}


