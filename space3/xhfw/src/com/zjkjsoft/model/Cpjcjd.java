package com.zjkjsoft.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

/**
 * 产品检测工序节点
 */
@SuppressWarnings("serial")
public class Cpjcjd extends Model<Cpjcjd> {
	public static final Cpjcjd dao = new Cpjcjd();

	/**
	 * 定制一层树页面组件
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTree(String path, String jbsxBox, String name) {
		String str = "";

		List<Cpjcgx> list = Cpjcgx.dao.find("select id ,mc from cpjcgx order by xh");

		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a href='#' >" + list.get(i).getStr(name) + "</a>";
				List<Cpjcjd> listd = Cpjcjd.dao.find("select id ,mc from cpjcjd  where fid=? order by xh",
						list.get(i).getInt("id"));

				if (listd.size() > 0) {
					str += "<ul>";
					for (int id = 0; id < listd.size(); id++) {
						str += "<li><a href='" + path + listd.get(id).getInt("id") + "' target='ajax' rel='" + jbsxBox
								+ "'>" + listd.get(id).getStr(name) + "</a>";

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
	/**
	 * 定制一层树页面组件
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTree2(String path, String jbsxBox, String name) {
		String str = "";
		List<Product> list0 = Product.dao.find("select id ,mc from product order by id desc");
		if (list0.size() > 0) {
			str += "<ul>";
			for (int a = 0; a < list0.size(); a++) {
				str += "<li><a href='#' >" + list0.get(a).getStr(name) + "</a>";
				List<Cpjcgx> list = Cpjcgx.dao.find("select id ,mc from cpjcgx where fid=? order by xh",list0.get(a).getInt("id"));

				if (list.size() > 0) {
					str += "<ul>";
					for (int i = 0; i < list.size(); i++) {
						str += "<li><a href='" + path + list.get(i).getInt("id")  + "' target='ajax' rel='" + jbsxBox
								+ "'>" + list.get(i).getStr(name) + "</a></li>";
					}
					str += "</ul>";
				}
				str += "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	/**
	 * 定制一层树页面组件
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTree3(String path, String jbsxBox, String name) {
		String str = "";
		List<Product> list0 = Product.dao.find("select id ,mc from product order by id desc");
		if (list0.size() > 0) {
			str += "<ul>";
			for (int a = 0; a < list0.size(); a++) {
				str += "<li><a href='#' >" + list0.get(a).getStr(name) + "</a>";
				List<Cpjcgx> list = Cpjcgx.dao.find("select id ,mc from cpjcgx where fid=? order by xh",list0.get(a).getInt("id"));

				if (list.size() > 0) {
					str += "<ul>";
					for (int i = 0; i < list.size(); i++) {
						str += "<li><a href='#' >" + list.get(i).getStr(name) + "</a>";
						List<Cpjcjd> listd = Cpjcjd.dao.find("select id ,mc from cpjcjd  where fid=? order by xh",
								list.get(i).getInt("id"));

						if (listd.size() > 0) {
							str += "<ul>";
							for (int id = 0; id < listd.size(); id++) {
								str += "<li><a href='" + path + listd.get(id).getInt("id") + "' target='ajax' rel='"
										+ jbsxBox + "'>" + listd.get(id).getStr(name) + "</a>";

								str += "</li>";
							}
							str += "</ul>";
						}

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
	//测试工序树
	public static String getCSGXLookUp(String a,String b,String c ,String d) {
		String str = "";
		List<Product> list0 = Product.dao.find("select id ,wlh from product order by id ");
		if (list0.size() > 0) {
			str += "<ul>";
			for (int j = 0; j < list0.size(); j++) {
				str += "<li><a href=''>"
						+ list0.get(j).getStr("wlh") + "</a>";
	//版本			
				List<ProBbh> list =ProBbh.dao.find("select id,bbh from probbh where fid=? order by id",list0.get(j).getInt("id"));

				if (list.size() > 0) {
					str += "<ul>";
					for (int i = 0; i < list.size(); i++) {
						str += "<li><a href='#' >" + list0.get(j).getStr("wlh")+"-" +list.get(i).getStr("bbh")+ "</a>";
						List<Cpjcjd> listd = Cpjcjd.dao.find("select id ,mc from cpjcjd  where lx=2 and fid=? order by xh",
								list.get(i).getInt("id"));

						if (listd.size() > 0) {
							str += "<ul>";
							for (int id = 0; id < listd.size(); id++) {
								str += "<li><a href=\"javascript:\" onclick=\"$.bringBack({" +a+":'"+list.get(i).getInt("id")+"',"+ b+":'"+list0.get(j).getStr("wlh")+"',"+ c+":'"+listd.get(id).getStr("mc")+"',"+ d+":'"+listd.get(id).getInt("id")+"'";
								str += "})\">" + listd.get(id).getStr("mc") + "</a></li>";
								
							}
							str += "</ul>";
						}

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
	
	/**
	 * 定制一层树页面组件
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreex(String path, String jbsxBox) {
		String str = "";
		List<Product> list0 = Product.dao.find("select id ,wlh from product order by id ");
		if (list0.size() > 0) {
			str += "<ul>";
			for (int j = 0; j < list0.size(); j++) {
				str += "<li><a href=''>"
						+ list0.get(j).getStr("wlh") + "</a>";
	//版本			
				List<ProBbh> list =ProBbh.dao.find("select id,bbh from probbh where fid=? order by id",list0.get(j).getInt("id"));
				if (list.size() > 0) {
					str += "<ul>";
					for (int i = 0; i < list.size(); i++) {
						str += "<li><a href='#' >" + list0.get(j).getStr("wlh")+"-" +list.get(i).getStr("bbh")+ "</a>";
						List<Cpjcjd> listd = Cpjcjd.dao.find("select id ,mc from cpjcjd  where lx>1 and fid=? order by xh",
								list.get(i).getInt("id"));
						if (listd.size() > 0) {
							str += "<ul>";
							for (int id = 0; id < listd.size(); id++) {
								str += "<li><a href='" + path + listd.get(id).getInt("id") + "' target='ajax' rel='"
										+ jbsxBox + "'>" + listd.get(id).getStr("mc") + "</a>";

								str += "</li>";
							}
							str += "</ul>";
						}
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
	/**
	 * 定制一层树页面组件
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeByRid(String path, String jbsxBox, String name,int rid) {
		String str = "";
		List<Product> list = Product.dao.find("select id ,mc from product where id in "
				+ "(select pid from srp where id=? ) order by id desc",rid);
        String rmc=Db.queryStr("select mc from srole where id=?",rid);
				if (list.size() > 0) {
					str += "<ul>";
					for (int i = 0; i < list.size(); i++) {
						str += "<li><a href='#' >" + list.get(i).getStr(name) + "</a>";
						List<Cpjcjd> listd = Cpjcjd.dao.find("select id ,mc from cpjcjd  where lx>1 and fid=? "
								+ "and jsmcs1 like '%"+rmc+"%' order by xh",
								list.get(i).getInt("id"));

						if (listd.size() > 0) {
							str += "<ul>";
							for (int id = 0; id < listd.size(); id++) {
								str += "<li><a href='" + path + listd.get(id).getInt("id") + "' target='ajax' rel='"
										+ jbsxBox + "'>" + listd.get(id).getStr(name) + "</a>";

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
