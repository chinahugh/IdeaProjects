package com.zjkjsoft.element;


import java.util.List;
import java.util.Set;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.zjkjsoft.model.Sfucn;

import com.zjkjsoft.model.Suser;
import com.zjkjsoft.util.StrUtil;

public class ManageElement {
	/**
	 * 从菜单中取值
	 * 
	 * @param fid
	 * @return
	 */
	public static String getFmcByFid(String fid) {
		return Sfucn.dao.findById(fid).getStr("mc");
	}


	/**
	 * 定制二层树页面组件
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getManageTree(String fid, String jsid) {
		String str = "";
//		String sql = "select * from cd  where id in (select cdid from jscd  where id="
//				+ jsid + ") and fid=" + fid +" order by xh ,id";//用户角色一对一
		//select * from cd  where id in (select cdid from jscd  where id in (1,2.3)) and fid=24 order by xh ,id
		//zk add 20131227 用于用户多角色管理
		String sql = "select * from cd  where id in (select cdid from jscd  where id in ("+ jsid +")) and fid=" + fid +" order by xh ,id";//用户角色一对多	
		List<Sfucn> list = Sfucn.dao.find(sql);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Sfucn cd = list.get(i);
				// <li><a href="" target="">人员信息系统</a>
				if (null == cd.getStr("path") || "".equals(cd.getStr("path"))) {
					str += "<li><a href=\"\" target=\"\">" + cd.getStr("mc")
							+ "</a><ul>";
					str += getManageTree("" + cd.get("id"), jsid);
					str += "</ul>";
				} else {
					str += "<li><a href=\"" + cd.getStr("path")
							+ "\" target=\"navTab\" rel=\""
							+ cd.getStr("path") + "\">" + cd.getStr("mc")
							+ "</a>";
				}
				// <li><a href="organization" target="navTab"
				// target="organization">组织信息系统</a>
				str += "</li>";
			}
		} else {
			str = "<li>请联系管理员，分配此功能权限！</li>";
		}
		return str;
	}

	/**
	 * 定制二层树页面组件评价 用于党、团、工会
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeOrgPJ(String sql, Integer fid) {

		Record record = Db.findById("organization", fid);
		String str = "<li><a href='" + "/yxpj?zzid=" + ""
							+ record.getInt("id") + "&fid=" + fid
							+ "' target='navTab' rel=\"main\">"
							+ record.getStr("mc") + "</a>";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {

				List<Record> list1 = Db.find(sql, list.get(i).getInt(
						"id"));
				if (list1.size() > 0) {
					str += "<li><a href='" + "/yxpj?zzid=" + ""
							+ list.get(i).getInt("id") + "&fid=" + fid
							+ "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a>";
					str += "<ul>";
					for (int j = 0; j < list1.size(); j++) {
						str += "<li><a href='" + "/yxpj?zzid=" + ""
								+ list1.get(j).getInt("id") + "&fid="
								+ fid + "' target='navTab' rel=\"main\">"
								+ list1.get(j).getStr("mc") + "</a></li>";
					}
					str += "</ul>";
				} else {
					str += "<li><a href='" + "/yxpj?zzid=" + ""
							+ list.get(i).getInt("id") + "&fid=" + fid
							+ "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a>";
				}
				str += "</li>";
			}
			str += "</ul>";
		}
		return str + "</li>";
	}
	/**
	 * 定制二层树页面组件评价 用于党总支
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeOrgPJ(String sql, String fid) {
		Record record = Db.findById("organization", 1);
		String str = "<li><a href='" + "/yxpj?zzid=" + ""
							+ record.getInt("id") + "&fid=" + fid
							+ "' target='navTab' rel=\"main\">"
							+ record.getStr("mc") + "</a>";
		List<Record> list = Db.find(sql, 1);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
					str += "<li><a href='" + "/yxpj?zzid=" + ""
							+ list.get(i).getInt("id") + "&fid=" + fid
							+ "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a></li>";
			}
			str += "</ul>";
		}
		return str + "</li>";
	}
	public static String getTreeOrgPJ(String sql,String fid, Integer zzid) {

		Record record = Db.findById("organization", zzid);
		String str = "<li><a href='" + "/yxpj?zzid=" + ""
		+ record.getInt("id") + "&fid=" + fid
		+ "' target='navTab' rel=\"main\">" + record.getStr("mc")
				+ "</a>";
		List<Record> list = Db.find(sql, zzid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {

				List<Record> list1 = Db.find(sql, list.get(i).getInt(
						"id"));
				if (list1.size() > 0) {
					str += "<li><a href=\"\" target=\"\" >"
							+ list.get(i).getStr("mc") + "</a>";
					str += "<ul>";
					for (int j = 0; j < list1.size(); j++) {
						str += "<li><a href='" + "/yxpj?zzid=" + ""
								+ list1.get(j).getInt("id") + "&fid="
								+ fid + "' target='navTab' rel=\"main\">"
								+ list1.get(j).getStr("mc") + "</a></li>";
					}
					str += "</ul>";
				} else {
					str += "<li><a href='" + "/yxpj?zzid=" + ""
							+ list.get(i).getInt("id") + "&fid=" + fid
							+ "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a>";
				}
				str += "</li>";
			}
			str += "</ul>";
		}
		return str + "</li>";
	}
	/**
	 * 用户单位评价
	 * @param fid
	 * @return
	 */
	public static String getTreeDwPJ(String fid) {
		String str = "";

		String sql = "select * from bm where  fid=1 order by id";
		List<Record> list = Db.find(sql);

		for (int i = 0; i < list.size(); i++) {
			str += "<li><a href='" + "/yxpj/?bmid=" + ""
					+ list.get(i).getInt("id") + "&fid=" + fid
					+ "' target='navTab' rel=\"main\">"
					+ list.get(i).getStr("mc") + "</a></li>";
			str += "</li>";
		}

		return str;
	}
	public static String getTreeDwPJ(String fid,Integer bmid) {
		String str = "";

		String sql = "select * from bm where  fid="+bmid+" order by id";
		List<Record> list = Db.find(sql);

		for (int i = 0; i < list.size(); i++) {
			str += "<li><a href='" + "/yxpj/?bmid=" + ""
					+ list.get(i).getInt("id") + "&fid=" + fid
					+ "' target='navTab' rel=\"main\">"
					+ list.get(i).getStr("mc") + "</a></li>";
			str += "</li>";
		}

		return str;
	}

	/**
	 * 定制二层树页面组件 用于党、团、工会 上报员
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeOrg( String fid,Integer zzid) {

		Record record = Db.findById("organization", zzid);
		System.out.println("====230============getTreeOrg==record={"+record+"}==");
		String str = "<li><a href='" + "/yxjl?zzid=" + ""
					+ record.getInt("id") + "&fid=" + fid
					+ "' target='navTab' rel=\"main\">" + record.getStr("mc")
				+ "</a>";

		return str + "</li>";
	}
	/**
	 * 定制二层树页面组件 用于党、团、工会
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeOrg(String sql, String fid,Integer zzid) {

		Record record = Db.findById("organization", zzid);
		String str = "<li><a href='" + "/yxjl?zzid=" + ""
					+ record.getInt("id") + "&fid=" + fid
					+ "' target='navTab' rel=\"main\">" + record.getStr("mc")
				+ "</a>";
		List<Record> list = Db.find(sql, zzid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {

				List<Record> list1 = Db.find(sql, list.get(i).getInt(
						"id"));
				if (list1.size() > 0) {
					str += "<li><a href='" + "/yxjl?zzid=" + ""
					+ list.get(i).getInt("id") + "&fid=" + fid
					+ "' target='navTab' rel=\"main\">"
					+ list.get(i).getStr("mc") + "</a>";
					str += "<ul>";
					for (int j = 0; j < list1.size(); j++) {
						str += "<li><a href='" + "/yxjl?zzid=" + ""
								+ list1.get(j).getInt("id") + "&fid="
								+ fid + "' target='navTab' rel=\"main\">"
								+ list1.get(j).getStr("mc") + "</a></li>";
					}
					str += "</ul>";
				} else {
					str += "<li><a href='" + "/yxjl?zzid=" + ""
							+ list.get(i).getInt("id") + "&fid=" + fid
							+ "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a>";
				}
				str += "</li>";
			}
			str += "</ul>";
		}
		return str + "</li>";
	}
	/**
	 * 定制二层树页面组件 用于党总支
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeOrg(String sql, String fid) {

		Record record = Db.findById("organization", 1);
		String str = "<li><a href='" + "/yxjl?zzid=" + ""
					+ record.getInt("id") + "&fid=" + fid
					+ "' target='navTab' rel=\"main\">" + record.getStr("mc")
				+ "</a>";
		List<Record> list = Db.find(sql, 1);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {		
					str += "<li><a href='" + "/yxjl?zzid=" + ""
					+ list.get(i).getInt("id") + "&fid=" + fid
					+ "' target='navTab' rel=\"main\">"
					+ list.get(i).getStr("mc") + "</a></li>";
			}
			str += "</ul>";
		}
		return str + "</li>";
	}
	public static String getTreeOrg( Integer zzid, String fid) {

		Record record = Db.findById("organization", zzid);
		String str = "<li><a href='" + "/yxjl?zzid=" + ""
					+ record.getInt("id") + "&fid=" + fid
					+ "' target='navTab' rel=\"main\">" + record.getStr("mc")
				+ "</a>";

		return str + "</li>";
	}
	/**
	 * 定制二层树页面组件 用于党、团、工会 用于 管理员或处级领导 组织 --总支--支部 --小组
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeOrg(String sql, Integer fid, String path) {

		Record record = Db.findById("organization", fid);
		String str = "<li><a  href='" + "/" + path + "?zzid=" + ""
							+ record.getInt("id") + "&fid=" + fid
							+ "' target='navTab' rel=\"main\">" + record.getStr("mc")
				+ "</a>";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {

				List<Record> list1 = Db.find(sql, list.get(i).getInt(
						"id"));
				if (list1.size() > 0) {
					str += "<li><a href='" + "/" + path + "?zzid=" + ""
							+ list.get(i).getInt("id") + "&fid=" + fid
							+ "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a>";
					str += "<ul>";
					for (int j = 0; j < list1.size(); j++) {
						List<Record> list2 = Db.find(sql, list1.get(j)
								.getInt("id"));
						if (list2.size() > 0) {
							str += "<li><a href='" + "/" + path + "?zzid=" + ""
									+ list1.get(j).getInt("id") + "&fid="
									+ fid + "' target='navTab' rel=\"main\">"
									+ list1.get(j).getStr("mc") + "</a>";
							str += "<ul>";
							for (int h = 0; h < list2.size(); h++) {
								str += "<li><a href='" + "/" + path + "?zzid="
										+ "" + list2.get(h).getInt("id")
										+ "&fid=" + fid
										+ "' target='navTab' rel=\"main\">"
										+ list2.get(h).getStr("mc")
										+ "</a></li>";

							}
							str += "</ul>";
						} else {
							str += "<li><a href='" + "/" + path + "?zzid=" + ""
									+ list1.get(j).getInt("id")
									+ "&fid=" + fid
									+ "' target='navTab' rel=\"main\">"
									+ list1.get(j).getStr("mc") + "</a>";
						}					
						str += "</li>";
					}
					str += "</ul>";
				} else {
					str += "<li><a href='" + "/" + path + "?zzid=" + ""
							+ list.get(i).getInt("id") + "&fid=" + fid
							+ "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a>";
				}
				str += "</li>";
			}
			str += "</ul>";
		}
		return str + "</li>";
	}
	/**
	 * 定制二层树页面组件 用于党、团、工会 用于 管理员或处级领导 组织 --总支--支部 --小组
	 * 组员
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeOrger(String sql, Integer fid, String path) {

		Record record = Db.findById("organization", fid);
		String str = "<li><a  href='" + "/" + path + "1/" + fid+"-"+ record.getInt("id") + 
							 "' target='navTab' rel=\"main\">" + record.getStr("mc")
				+ "</a>";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {

				List<Record> list1 = Db.find(sql, list.get(i).getInt(
						"id"));
				if (list1.size() > 0) {
					str += "<li><a href='" + "/" + path + "2/" + fid+"-"+ list.get(i).getInt("id") + "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a>";
					str += "<ul>";
					for (int j = 0; j < list1.size(); j++) {
						List<Record> list2 = Db.find(sql, list1.get(j)
								.getInt("id"));
						if (list2.size() > 0) {
							str += "<li><a href='" + "/" + path +"3/" + fid+"-"+
									 list1.get(j).getInt("id") + "' target='navTab' rel=\"main\">"
									+ list1.get(j).getStr("mc") + "</a>";
//							str += "<ul>";
//							for (int h = 0; h < list2.size(); h++) {
//								str += "<li><a href='" + "/" + path + "/" + fid+"-"+  list2.get(h).getInt("id")										
//										+ "' target='navTab' rel=\"main\">"
//										+ list2.get(h).getStr("mc")
//										+ "</a></li>";
//
//							}
//							str += "</ul>";
						} else {
							str += "<li><a href='" + "/" + path + "3/" + fid+"-"
									+ list1.get(j).getInt("id")
									+ "' target='navTab' rel=\"main\">"
									+ list1.get(j).getStr("mc") + "</a>";
						}					
						str += "</li>";
					}
					str += "</ul>";
				} else {
					str += "<li><a href='" + "/" + path +"3/" + fid+"-"+
					list.get(i).getInt("id")+ "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a>";
				}
				str += "</li>";
			}
			str += "</ul>";
		}
		return str + "</li>";
	}
	public static String getTreeOrger2(String sql, Integer fid, String path) {

		Record record = Db.findById("organization", fid);
		String str = "<li><a  href='" + "/" + path + "2/" + fid+"-"+ record.getInt("id") + 
							 "' target='navTab' rel=\"main\">" + record.getStr("mc")
				+ "</a>";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
					str += "<li><a href='" + "/" + path +"3/" + fid+"-"+
					list.get(i).getInt("id")+ "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a></li>";

			}
			str += "</ul>";
		}
		return str + "</li>";
	}
	public static String getTreeOrger3(String sql, Integer fid, String path) {

		Record record = Db.findById("organization", fid);
		String str = "<li><a  href='" + "/" + path + "3/" + fid+"-"+ record.getInt("id") + 
							 "' target='navTab' rel=\"main\">" + record.getStr("mc")
				+ "</a>";	
		return str + "</li>";
	}
	/**
	 * 定制二层树页面组件 用于 管理员或处级领导 行政组织
	 * 组员
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeOrger0(String sql, Integer fid, String path) {

		Record record = Db.findById("bm", fid);
		String str = "<li><a  href='" + "/" + path + "1/" + fid+"-"+ record.getInt("id") + 
							 "' target='navTab' rel=\"main\">" + record.getStr("mc")
				+ "</a>";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {

				List<Record> list1 = Db.find(sql, list.get(i).getInt(
						"id"));
				if (list1.size() > 0) {
					str += "<li><a href='" + "/" + path + "2/" + fid+"-"+ list.get(i).getInt("id") + "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a>";
					str += "<ul>";
					for (int j = 0; j < list1.size(); j++) {
						List<Record> list2 = Db.find(sql, list1.get(j)
								.getInt("id"));
						if (list2.size() > 0) {
							str += "<li><a href='" + "/" + path +"3/" + fid+"-"+
									 list1.get(j).getInt("id") + "' target='navTab' rel=\"main\">"
									+ list1.get(j).getStr("mc") + "</a>";
							str += "<ul>";
							for (int h = 0; h < list2.size(); h++) {
								str += "<li><a href='" + "/" + path + "/" + fid+"-"+  list2.get(h).getInt("id")										
										+ "' target='navTab' rel=\"main\">"
										+ list2.get(h).getStr("mc")
										+ "</a></li>";

							}
							str += "</ul>";
						} else {
							str += "<li><a href='" + "/" + path + "3/" + fid+"-"
									+ list1.get(j).getInt("id")
									+ "' target='navTab' rel=\"main\">"
									+ list1.get(j).getStr("mc") + "</a>";
						}					
						str += "</li>";
					}
					str += "</ul>";
				} else {
					str += "<li><a href='" + "/" + path +"3/" + fid+"-"+
					list.get(i).getInt("id")+ "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a>";
				}
				str += "</li>";
			}
			str += "</ul>";
		}
		return str + "</li>";
	}
	public static String getTreeOrger01(String sql, Integer fid, String path) {

		Record record = Db.findById("bm", fid);
		String str = "<li><a  href='" + "/" + path + "3/" + fid+"-"+ record.getInt("id") + 
							 "' target='navTab' rel=\"main\">" + record.getStr("mc")
				+ "</a>";
		return str + "</li>";
	}
	/**
	 * 定制一层树页面组件 用于党、团、工会 用于总支领导 总支到支部
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeOrg1(String sql, Integer fid, String path) {

		Record record = Db.findById("organization", fid);
		String str = "<li><a href=\"\" target=\"\">" + record.getStr("mc")
				+ "</a>";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {

				List<Record> list1 = Db.find(sql, list.get(i).getInt(
						"id"));
				if (list1.size() > 0) {
					str += "<li><a href=\"\" target=\"\" >"
							+ list.get(i).getStr("mc") + "</a>";
					str += "<ul>";
					for (int j = 0; j < list1.size(); j++) {
						str += "<li><a href='" + "/" + path + "?zzid=" + ""
								+ list1.get(j).getInt("id") + "&fid="
								+ fid + "' target='navTab' rel=\"main\">"
								+ list1.get(j).getStr("mc") + "</a></li>";
					}
					str += "</ul>";
				} else {
					str += "<li><a href='" + "/" + path + "?zzid=" + ""
							+ list.get(i).getInt("id") + "&fid=" + fid
							+ "' target='navTab' rel=\"main\">"
							+ list.get(i).getStr("mc") + "</a>";
				}
				str += "</li>";
			}
			str += "</ul>";
		}
		return str + "</li>";
	}

	public static String getTreeZZDw(String fid) {
		String str = "";

		String sql = "select * from bm where  fid=1 order by id";
		List<Record> list = Db.find(sql);

		for (int i = 0; i < list.size(); i++) {
			str += "<li><a href='" + "/yxjl/?bmid=" + ""
					+ list.get(i).getInt("id") + "&fid=" + fid
					+ "' target='navTab' rel=\"main\">"
					+ list.get(i).getStr("mc") + "</a></li>";
			str += "</li>";
		}

		return str;
	}
	public static String getTreeZZDw(String fid,Integer bmid) {
		String str = "";

		String sql = "select * from bm where  fid="+bmid+" order by id";
		List<Record> list = Db.find(sql);

		for (int i = 0; i < list.size(); i++) {
			str += "<li><a href='" + "/yxjl/?bmid=" + ""
					+ list.get(i).getInt("id") + "&fid=" + fid
					+ "' target='navTab' rel=\"main\">"
					+ list.get(i).getStr("mc") + "</a></li>";
			str += "</li>";
		}

		return str;
	}


	/**
	 * 基础信息 组织树
	 * 
	 * @author Administrator
	 * 
	 */

	public static String getTreeS(String sql, Integer fid, String path,
			String jbsxBox, String name) {
		String str = "";

		// str +=
		// "<li><a href=\""+cd.getStr("path")+"\" target=\"navTab\" target=\""+cd.getStr("path")+"\">"+cd.getStr("mc")+"</a>";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {

				str += "<li><a href='" + path + list.get(i).getInt("id")
						+ "' target='main' rel='" + jbsxBox + "'>"
						+ list.get(i).getStr(name) + "</a>";
				str += getTreeS(sql, list.get(i).getInt("id"), path,
						jbsxBox, name)
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	public static String getTreeS(String sql, Integer fid, String path,
			String target,String rel, String name) {
		String str = "";

		// str +=
		// "<li><a href=\""+cd.getStr("path")+"\" target=\"navTab\" target=\""+cd.getStr("path")+"\">"+cd.getStr("mc")+"</a>";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {

				str += "<li><a href='" + path + list.get(i).getInt("id")
						+ "' target='"+target+"' rel='" + rel + "'>"
						+ list.get(i).getStr(name) + "</a>";
				str += getTreeS(sql, list.get(i).getInt("id"), path,target,
						rel, name)
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}


	/**
	 * 运行记录工会工作
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeYcjl2( String fid, Suser user0,String ycml) {
//		System.out.println("--1-----"+ycml+"（2级）");
//		System.out.println("--工会运行记录（2级)-----"+"工会运行记录（2级)".equals(ycml+"（2级）"));
		Set s = StrUtil.getSetByStrs(user0.getStr("jsmcs"), ",");
		if (s.contains("处工会主席")||s.contains(ycml+"（1级）")) {
			return getTreeOrg("select * from organization where fid=? order by xh,id",fid, Integer.valueOf(2));
		}else if (s.contains("基层工会主席")||s.contains(ycml+"（2级）")) {// 党总支书记,
			Integer zzid=user0.getInt("gzzfid");
			if(new Integer(2).equals(zzid))
				return getTreeOrg(fid, user0.getInt("ghzzid"));
			else 
				return getTreeOrg("select * from organization where fid=? order by xh,id",
		    			fid, zzid);
		} else  if (s.contains("基层组织工会主席")||s.contains(ycml+"（3级）")){// 党支部书记if (s.contains("26"))  、上报员
			return getTreeOrg(fid, user0.getInt("ghzzid"));
		 }else{
				return null;
			}
	}


}
