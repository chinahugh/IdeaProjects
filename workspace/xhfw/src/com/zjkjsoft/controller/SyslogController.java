package com.zjkjsoft.controller;



import java.io.UnsupportedEncodingException;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Sfucn;
import com.zjkjsoft.model.Syslog;
/**
 * 系统日志
 */

@Before(ManagerPowerInterceptor.class)
public class SyslogController extends BaseController {
	private static String path="/xtgl/log/";//jsp路径
	//navTabId
	private static String navTabId="syslog";
	private static String key="mc";//查询关键字字段名
	
	@Override
	public String action() {
                      return  "系统日志";
   }
	
	/**
	 * 系统日志首页
	 * <br/>页面：/xtgl/log/list.jsp
	 */
	@Override
	public void index() {
		setAttr("page", getPageData());
		render(path+"list.jsp");
	}
	/**
	 * 查看日志的信息
	 * <br/>页面：/xtgl/log/view.jsp
	 */
	public void view() {
		setAttr("syslog", Syslog.logDetails(getParaToInt()));
		render(path+"view.jsp");
	}
	public void delete() {
		Syslog.dao.deleteById(getParaToInt());
		toDwzJson( 200, "删除成功！", navTabId);
	}
	
	
	private Page<Syslog> getPageData()
	{
		String keywords=getPara("keywords");
		String sql=Syslog.whereSQL;
		if(keywords!=null&&!keywords.isEmpty())
			sql+=" AND "+key+" like '%"+keywords+"%'";
		sql+=" order by id desc ";
		return Syslog.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), Syslog.selectSQL, sql);
	}
	
	/**
	 * 导出Excel
	 * @throws UnsupportedEncodingException 
	 */
	public void export() throws UnsupportedEncodingException 
	{
		List<Syslog> data=getPageData().getList();
		String[] columns = {"loginname", "username", "mc", "ms", "ctime", "ip"};
		String[] heades = {"帐号", "用户", "模块", "描述", "时间", "IP"};
		String filename = new String("日志管理.xls".getBytes("UTF-8"), "ISO8859-1");
		render(PoiRender.me(data).fileName(filename).sheetName("所有").columns(columns).headers(heades).cellWidth(5000).headerRow(1));
	}
}