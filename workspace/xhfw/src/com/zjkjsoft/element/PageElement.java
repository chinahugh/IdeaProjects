package com.zjkjsoft.element;


import java.util.List;
import java.util.Set;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.zjkjsoft.model.JcxxBom;
import com.zjkjsoft.model.ProBbh;
import com.zjkjsoft.model.Product;


/**
 * 页面组件 递归树
 * 
 * @author Administrator
 * 
 */
public class PageElement {
	/**
	 * 栏目组织配置
	 * 
	 * @author Administrator
	 * 
	 */	
	
	public static String getTreeCheckLMPZ(String sql, Integer fid, 
			String mc,String tabid, String name) {
//		String str = "";
//		List<Record> list = Db.find(sql, fid);
//		if (list.size() > 0) {
//			str += "<ul>";
//			for (int i = 0; i < list.size(); i++) {
//				str += "<li><a href=\"javascript:\" onclick=\"$.bringBack({" + tabid+":'"+list.get(i).getInt("id")+"',"+ name+":'"+list.get(i).getStr("mc")+"'";
//				str += "})\">" + list.get(i).getStr("mc") + "</a>";
//				str += getTreeCheckLMPZ(sql, list.get(i).getInt("id"),
//						mc,tabid, name)
//						+ "</li>";
//			}
//			str += "</ul>";
//		}
//		return str;
		String str = "";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a tname=\""+mc+"\" tvalue=\""+list.get(i).getInt("id")+"\" >"+list.get(i).getStr("mc")+"</a>";
				str += getTreeCheck(sql, list.get(i).getInt("id"),
						mc)
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	/**
	 * 页面组件 复选框 递归树
	 * 
	 * @author Administrator
	 * 
	 */	
	
	public static String getTreeCheck(String sql, Integer fid, 
			String mc) {
		String str = "";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a tname=\""+mc+"\" tvalue=\""+list.get(i).getInt("id")+"\" >"+list.get(i).getStr("mc")+"</a>";
				str += getTreeCheck(sql, list.get(i).getInt("id"),
						mc)
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	
	/**
	 * 页面组件 复选框 递归树  栏目
	 * 
	 * @author Administrator
	 * 
	 */	
	
	public static String getTreeCheck(String sql, Integer fid, 
			String mc,String lmid) {
		String str = "";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a tname=\""+mc+"\" tvalue=\""+list.get(i).getInt(lmid)+"\" >"+list.get(i).getStr(mc)+"</a>";
				str += getTreeCheck(sql, list.get(i).getInt("id"),
						mc,lmid)
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	/**
	 * 页面组件 复选框 递归树
	 * 
	 * @author Administrator
	 * 
	 */	
	
	public static String getTreeCheckForLmzz(String sql, Integer fid) {
		String str = "";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a tname=\"ids\" tvalue=\"{zzid:'"+list.get(i).getInt("id")+"',zzmc:'$"+list.get(i).getStr("mc")+"'}\" >"+list.get(i).getStr("mc")+"</a>";
				str += getTreeCheckForLmzz(sql, list.get(i).getInt("id"))
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	/**
	 * 页面组件 复选框 递归树
	 * 
	 * @author Administrator
	 * 
	 */	
	
	public static String getTreeCheck(String sql, Integer fid, 
			String mc,Set set) {
		String str = "";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				Integer id=list.get(i).getInt("id");
				str += "<li><a tname=\""+mc+"\" tvalue=\""+id+"\" "+(set.contains(id)?"checked=\"true\"":"")+">"+list.get(i).getStr("mc")+"</a>";
				str += getTreeCheck(sql, id,
						mc,set)
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	
	public static String getTreeCheckRP(String sql, Integer fid, 
			String mc,Set set) {
		String str = "";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a href=''>"
						+ list.get(i).getStr("wlh") + "</a>";
				List<ProBbh> list1=ProBbh.dao.find(" select * from probbh where fid=? ", list.get(i).getInt("id"));
				if (list1.size()>0) {
					str += "<ul>";
					for (ProBbh probbh : list1) {
						Integer pid=probbh.getInt("id");
						str += "<li><a tname=\""+mc+"\" tvalue=\""+pid+"\" "+(set.contains(pid)?"checked=\"true\"":"")+">"+list.get(i).getStr("wlh")+"-"+probbh.getStr("bbh")+"</a></li>";
					}
					str += "</ul>";
				}
				str += "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	
	public static String getTreeCheckLM(String sql, Integer fid, 
			String mc,Set set) {
		String str = "";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				Integer id=list.get(i).getInt("lmid");
				str += "<li><a tname=\""+mc+"\" tvalue=\""+id+"\" "+(set.contains(id)?"checked=\"true\"":"")+">"+list.get(i).getStr("mc")+"</a>";
				str += getTreeCheckLM(sql, id,
						mc,set)
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	/**
	 * 页面组件 递归树
	 * 
	 * @author Administrator
	 * 
	 */	
	

	public static String getTreeS(String sql, Integer fid, String path,String jbsxBox,
			String name) {
		String str = "";
		// <li><a href='reported/list/1' target='ajax' rel='jbsxBox'>test</a>
		// <ul>
		// <li><a href='reported/list/1' target='ajax'
		// rel='jbsxBox'>test</a></li>
		// </ul>
		// </li>
		// <li><a href='demo/pagination/list1.html' target='ajax'
		// rel='jbsxBox'>HIV检测</a></li>

		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a href='" + path + list.get(i).getInt("id")
						+ "' target='ajax' rel='"+jbsxBox+"'>"
						+ list.get(i).getStr(name) + "</a>";
				str += getTreeS(sql, list.get(i).getInt("id"), path,jbsxBox,
						name)
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	
	
	/**
	 * BOM 递归树
	 * 
	 * @author Administrator
	 * 
	 */	
	public static String getTreeBom(String sql, Object wlh, String path,String jbsxBox,
			String name,String name1,String name2) {
		String str = "";
		List<Record> list = Db.find(sql, wlh);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a href='" + path + list.get(i).get("zj")+"-"+list.get(i).get("fid")+"-"+list.get(i).get("bbh")
						+ "' target='ajax' rel='"+jbsxBox+"'>"
						+ list.get(i).getStr(name)+"-"+list.get(i).getStr(name1)+"-"+list.get(i).getStr(name2)+"</a>";
				str += getTreeBom(sql, list.get(i).get("zj"), path,jbsxBox,
						name,name1,name2)
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	
	
	/**
	 * 
	 * @param sql
	 * @param fid
	 * @param path
	 * @param jbsxBox
	 * @param name
	 * @param idmc
	 * @return
	 */
	public static String getTreeS(String sql, Integer fid, String path,String jbsxBox,
			String name,String idmc) {
		String str = "";
		// <li><a href='reported/list/1' target='ajax' rel='jbsxBox'>test</a>
		// <ul>
		// <li><a href='reported/list/1' target='ajax'
		// rel='jbsxBox'>test</a></li>
		// </ul>
		// </li>
		// <li><a href='demo/pagination/list1.html' target='ajax'
		// rel='jbsxBox'>HIV检测</a></li>

		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				List<Record> listz = Db.find(sql,  list.get(i).getInt(idmc));
				if (listz.size() > 0){
					str += "<li><a href='"+path+list.get(i).getInt(idmc)+ "' target='ajax' rel='"+jbsxBox+"'>";
				
				}else{
					str += "<li><a href='" + path + list.get(i).getInt(idmc)
							+ "' target='ajax' rel='"+jbsxBox+"'>";
				}
						str += list.get(i).getStr(name) + "</a>";
				str += getTreeS(sql, list.get(i).getInt(idmc), path,jbsxBox,
						name,idmc)
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}

	/**
	 * 定制二层树页面组件
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeC2(String sql, Integer fid, String path,String jbsxBox,
			String name) {
		String str = "";

		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a href='" + path + list.get(i).getInt("id")
						+ "' target='ajax' rel='"+jbsxBox+"'>"
						+ list.get(i).getStr(name) + "</a>";
				List<Record> list1 = Db.find(sql, list.get(i).getInt(
						"id"));
				if (list1.size() > 0) {
					str += "<ul>";
					for (int j = 0; j < list1.size(); j++) {
						str += "<li><a href='" + path+""
								+ list1.get(j).getInt("id")
								+ "' target='ajax' rel='"+jbsxBox+"'>"
								+ list1.get(j).getStr(name) + "</a></li>";
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
	public static String getTreeC1(String sql, Integer fid, String path,String jbsxBox,
			String name) {
		String str = "";

		List<Record> list = Db.find(sql, fid);

		
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a href='" + path + list.get(i).getInt("id")
						+ "' target='ajax' rel='"+jbsxBox+"'>"
						+ list.get(i).getStr(name) + "</a>";
				str += "</li>";
			}
			str += "</ul>";
		}
		return str;
	}

	/**
	 * 页面组件 递归树
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeLookUp(String sql, Integer fid,
			String[] strs, String name) {
		String str = "";
		// <li><a href=\"javascript:\">北京</a>
		// <ul>
		// <li><a href=\"javascript:\" onclick=\"$.bringBack({id:'1',
		// districtName:'东城',
		// cityName:'北京'})\">东城</a></li>
		// <li><a href=\"javascript:\" onclick=\"$.bringBack({id:'2',
		// districtName:'西城',
		// cityName:'北京'})\">西城</a></li>
		// </ul>
		// </li>
		// <li><a href=\"javascript:\">上海</a>
		// <ul>
		// <li><a href=\"javascript:\" onclick=\"$.bringBack({id:'1',
		// districtName:'崇明',
		// cityName:'上海'})\">崇明</a></li>
		// <li><a href=\"javascript:\" onclick=\"$.bringBack({id:'2',
		// districtName:'黄浦',
		// cityName:'上海'})\">黄浦</a></li>
		// </ul>
		// </li>

		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a href=\"javascript:\" onclick=\"$.bringBack({";
				if (strs.length == 1) {
					str += strs[1]+":'"+list.get(i).getStr(strs[1])+"'";
				} else if (strs.length > 1) {
					for (int j = 1; j < strs.length; j++) {
						str += strs[j]+":'"+list.get(i).getStr(strs[1])+"',";
					}
					str += strs[strs.length]+":'"+list.get(i).getStr(strs[1])+"'";
				}
				str += "})\">" + list.get(i).getStr(name) + "</a>";
				str += getTreeLookUp(sql, list.get(i).getInt("id"),
						strs, name)
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	/**
	 * 页面组件 递归树
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getTreeLookUp(String sql, Integer fid,
			String tabid, String name) {
		String str = "";
		List<Record> list = Db.find(sql, fid);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a href=\"javascript:\" onclick=\"$.bringBack({" + tabid+":'"+list.get(i).getInt("id")+"',"+ name+":'"+list.get(i).getStr("mc")+"'";
				str += "})\">" + list.get(i).getStr("mc") + "</a>";
				str += getTreeLookUp(sql, list.get(i).getInt("id"),
						tabid, name)
						+ "</li>";
			}
			str += "</ul>";
		}
		return str;
	}
	public static String getTreeLookUpi(String sql, Integer fid,
			String tabid, String name) {
		String str = "";
		List<Record> list = Db.find(sql, fid);
		for (int i = 0; i < list.size(); i++) {
				str += "<li><a href=\"javascript:\" onclick=\"$.bringBack({" + tabid+":'"+list.get(i).getInt("id")+"',"+ name+":'"+list.get(i).getStr("mc")+"'";
				str += "})\">" + list.get(i).getStr("mc") + "</a>";
				str += getTreeLookUp(sql, list.get(i).getInt("id"),
						tabid, name)
						+ "</li>";
		}
		return str;
	}
/**
 * 下啦菜单 组件
 * @param sql
 * @param fid
 * @param ov
 * @param ot
 * @param tid
 * @return
 */
	public static String getSelectOptions(int fid) {
		String str = "";
		List<Record> list =  Db.find("  select id, mc from code where fid=? order by xh ,id  ", fid);
		for (int i = 0; i < list.size(); i++) {		
				str += "<option value='"+list.get(i).get("id")+"' >"+list.get(i).get("mc")+"</option>";	
		}
		return str;  
	}
	public static String getSelectOptions(String sql) {
		String str = "";
		List<Record> list = Db.find(sql);
		for (int i = 0; i < list.size(); i++) {		
				str += "<option value='"+list.get(i).get("id")+"' >"+list.get(i).get("mc")+"</option>";	
		}
		return str;  
	}
	public static String getSelectOptionsT(String tab) {
		String str = "";
		String sql="  select id, mc from "+tab+" order by xh ,id  ";
		List<Record> list = Db.find(sql);
		for (int i = 0; i < list.size(); i++) {		
				str += "<option value='"+list.get(i).get("id")+"' >"+list.get(i).get("mc")+"</option>";	
		}
		return str;  
	}
	public static String getSelectOptionsT(String tab,Integer tid) {
		String str = "";
		String sql="  select id, mc from "+tab+" order by xh ,id  ";
		List<Record> list = Db.find(sql);
		for (int i = 0; i < list.size(); i++) {		
			Integer vid=list.get(i).getInt("id");
			if(tid==vid)
				str += "<option value='"+vid+"' selected>"+list.get(i).get("mc")+"</option>";
			else
				str += "<option value='"+vid+"' >"+list.get(i).get("mc")+"</option>";	
		}
		return str;  
	}
	
	/**
	 * @param fid 要查询的Code的 父亲 Id
	 * @param tid @link {@link Proinfo}中记录的Code表中的ID
	 * @return
	 */
	public static String getSelectOptions(int fid,Integer tid) {
        String sql="  select id, mc from code where fid="+fid+" order by xh ,id  ";
		return getSelectOptions( sql, tid);  
	}
	public static String getSelectOptions(String sql,Integer tid) {
		String str = "";
		List<Record> list = Db.find(sql);
		for (int i = 0; i < list.size(); i++) {	
			Integer vid=list.get(i).getInt("id");
			if(tid.intValue()==vid.intValue())
				str += "<option value='"+vid+"' selected=\"selected\">"+list.get(i).get("mc")+"</option>";
			else
				str += "<option value='"+vid+"' >"+list.get(i).get("mc")+"</option>";	
		}
		return str;  
	}
	public static String getSelectOptions(String sql, Integer fid,
			String ov, String ot,Integer tid) {
		String str = "";
		List<Record> list = Db.find(sql, fid);
		for (int i = 0; i < list.size(); i++) {
			Integer vid=list.get(i).getInt(ov);
			if(tid==vid)
				str += "<option value='"+vid+"' selected>"+list.get(i).get(ot)+"</option>";
			else
				str += "<option value='"+vid+"'>"+list.get(i).get(ot)+"</option>";
	
		}
		return str;  
	}
	public static String getSelectOptions(String sql, Integer fid,
			String ov, String ot,String tid) {
		String str = "";
		List<Record> list = Db.find(sql, fid);
		for (int i = 0; i < list.size(); i++) {
			String vid=list.get(i).getStr(ov);
			if(tid.equals(vid))
				str += "<option value='"+vid+"' selected>"+list.get(i).get(ot)+"</option>";
			else
				str += "<option value='"+vid+"'>"+list.get(i).get(ot)+"</option>";
	
		}
		return str;  
	}
	
	//栏目树
	public static String getLMLookUp(String a,String b ) {
		String str ="";
		String sql ="select * from lm  order by fid ,xh,id ";
		List<Record> list = Db.find(sql);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a href=\"javascript:\" onclick=\"$.bringBack({" +a+":'"+list.get(i).getInt("lmid")+"',"+ b+":'"+list.get(i).getStr("mc")+"'";
				str += "})\">" + list.get(i).getStr("mc") + "</a></li>";
			}
			str += "</ul>";
		}			
		return str;
	}
	//部门树
	public static String getBMLookUp(String a,String b ) {
		String str ="";
		String sql ="select * from sorg  order by fid ,xh,id ";
		List<Record> list = Db.find(sql);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a href=\"javascript:\" onclick=\"$.bringBack({" +a+":'"+list.get(i).getInt("id")+"',"+ b+":'"+list.get(i).getStr("mc")+"'";
				str += "})\">" + list.get(i).getStr("mc") + "</a></li>";
			}
			str += "</ul>";
		}			
		return str;
	}
	/**
	 * 产品版本
	 * 
	 * @author Administrator
	 * 
	 */
	public static String getCpbbTree( String wlh) {
		String str = "";
//产品
		Product product =Product.dao.findFirst("select id,wlh from product where wlh=?",wlh);
		
		if (product!=null) {
			str += "<ul>";
		
				str += "<li><a href=''>"
						+wlh + "</a>";
	//版本			
				List<ProBbh> list1 =ProBbh.dao.find("select id,bbh from probbh where fid=? order by id",product.getInt("id"));
				
				if (list1.size() > 0) {
					str += "<ul>";
					for (int j = 0; j < list1.size(); j++) {
						str += "<li><a href=\"javascript:\" onclick=\"$.bringBack({fid:'"+list1.get(j).getInt("id");
						str += "'})\">" + wlh+"-" +list1.get(j).getStr("bbh")+ "</a></li>";
					}
					str += "</ul>";		
				}
				str += "</li>";
			
			str += "</ul>";
		}
		return str;
	}
	//物料
	public static String getWLLookUp(String a,String b ) {
		String str ="";
		String sql ="select * from materia  order by fid ,xh,id ";
		List<Record> list = Db.find(sql);
		if (list.size() > 0) {
			str += "<ul>";
			for (int i = 0; i < list.size(); i++) {
				str += "<li><a href=\"javascript:\" onclick=\"$.bringBack({" +a+":'"+list.get(i).getInt("id")+"',"+ b+":'"+list.get(i).getStr("mc")+"'";
				str += "})\">" + list.get(i).getStr("mc") + "</a></li>";
			}
			str += "</ul>";
		}			
		return str;
	}

	public static String getCheckTree(String sql, int fid)
	{
		List<Record> list=Db.find(sql, fid);
		String str="";
		str+="<ul class='tree treeFolder treeCheck expand' oncheck='kkk'>";
		for(int i=0; i<list.size(); i++)
		{
			str+="<li><a>"+list.get(i).getStr("mc")+"</a>";
			List<Record> childList=Db.find(sql, list.get(i).get("id"));
			if(childList.size()>0)
			{
				str+="<ul>";
				for(int j=0; j<childList.size(); j++)
				{
					str+="<li><a tvalue=\""+childList.get(j).get("id")+"\" >"+childList.get(j).getStr("mc")+"</a></li>";   
				}
				str+="</ul>";
			}
			str+="</li>";
		}
		str+="</ul>";
		
		System.out.println(str);
		
		return str;
	}
}
