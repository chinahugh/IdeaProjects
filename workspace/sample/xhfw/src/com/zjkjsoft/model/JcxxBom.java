package com.zjkjsoft.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Model;
import com.zjkjsoft.element.PageElement;
/**
 * 角色
 */
@SuppressWarnings("serial")
public class JcxxBom extends Model<JcxxBom> {
	public static final JcxxBom dao = new JcxxBom();
	
	public static List<Product> getList(List<Product> list){
		for (Product product : list) {
			List<ProBbh> probbhList=ProBbh.dao.find("select fid,bbh from probbh where fid=?", product.get("id"));
			for (ProBbh proBbh : probbhList) {
				proBbh.set("tree", PageElement.getTreeBom("select wlh,wlms,zj,zjms,bbh,fid from jcxxbom where fid="+proBbh.get("fid")+" and bbh='"+proBbh.get("bbh")+"' and wlh=? order by id",product.getStr("wlh"), "jcxxbom/list/", "jcxxbomBox","zj","bbh","zjms"));
				proBbh.set("wlh", product.get("wlh"));
			}
			product.set("tree", probbhList);
		}
		return list;
	}
	
	public static List<Product> searchList(List<Product> list1,String wlh){
		for (Product product : list1) {
			List<ProBbh> probbhList=ProBbh.dao.find("SELECT  pb.fid,pb.bbh FROM probbh pb,jcxxbom jb WHERE  pb.bbh=jb.bbh AND pb.fid=jb.fid AND jb.zj=? and pb.fid=?", wlh,product.get("id"));
			for (ProBbh probbh : probbhList) {
				String str1="",str2="",str3="";
				str3=PageElement.getTreeBom("select wlh,wlms,zj,zjms,bbh,fid from jcxxbom where fid="+probbh.get("fid")+" and bbh="+probbh.get("bbh")+" and wlh=? order by id",wlh, "jcxxbom/list/", "jcxxbomBox","zj","bbh","zjms");
				String strs[]=new String[10];
				int j=0;
				String wlh1=wlh;
				for (int i = 0; i < strs.length; i++,j++) {
					JcxxBom jcxxbom=JcxxBom.dao.findFirst("select wlh,wlms,zj,zjms,bbh,fid from jcxxbom where fid=? and zj=? and bbh=?",probbh.get("fid"),wlh1,probbh.get("bbh"));
					if (jcxxbom==null) {
						break;
					}
					strs[j]= "<a href='jcxxbom/list/" + jcxxbom.get("zj")+"-"+jcxxbom.get("fid")+"-"+jcxxbom.get("bbh")
							+ "' target='ajax' rel='jcxxbomBox'>"
							+ jcxxbom.getStr("zj")+"-"+jcxxbom.getStr("bbh")+"-"+jcxxbom.getStr("zjms")+ "</a> ";			
					wlh1=jcxxbom.get("wlh");
				}
				for(int i=0;i<j;i++) {
					 str1+="<ul><li>"+strs[j-i-1];
					 str2+="</li></ul>";
				}
				probbh.set("tree",str1+str3+str2);
				probbh.set("wlh", product.get("wlh"));
			}
			product.set("tree", probbhList);
		}
		return list1;
	}
}
