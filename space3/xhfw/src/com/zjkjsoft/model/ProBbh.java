package com.zjkjsoft.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;
/**
 * 角色
 */
@SuppressWarnings("serial")
public class ProBbh extends Model<ProBbh> {
	public static final ProBbh dao = new ProBbh();
	/**
	 * 定制一层树页面组件
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTree( String path,String jbsxBox) {
		String str = "";
//产品
		List<Product> list =Product.dao.find("select id,wlh from Product order by id");
		
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a href=''>"
						+ list.get(i).getStr("wlh") + "</a>";
	//版本			
				List<ProBbh> list1 =ProBbh.dao.find("select id,bbh from probbh where fid=? order by id",list.get(i).getInt("id"));
				
				if (list1.size() > 0) {
					str += "<ul>";
					for (int  j= 0; j < list1.size(); j++) {
						str += "<li><a href='" + path + list1.get(j).getInt("id")
								+ "' target='ajax' rel='"+jbsxBox+"'>"
								+ list.get(i).getStr("wlh")+"-" +list1.get(j).getStr("bbh")+ "</a>";
																		
						str += "</li>";
					}
					str += "</ul>";				
				}
				str += "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
}
