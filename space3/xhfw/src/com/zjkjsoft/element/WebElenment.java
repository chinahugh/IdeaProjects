package com.zjkjsoft.element;

import java.text.SimpleDateFormat;
import java.util.List;



import com.zjkjsoft.model.Sfucn;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.zjkjsoft.model.Scatlog;

/**
 * 前台组件
 * @author Administrator
 *
 */
public class WebElenment {
	public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static SimpleDateFormat sfnmd = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sfmd = new SimpleDateFormat("MM-dd");
	public static SimpleDateFormat sfynmdCN = new SimpleDateFormat("yyyy年MM月dd日");
	/**
	 * 返回权限树
	 * @param c
	 * @return
	 */
	public static  String getCdtreeNew(int c){
		List<Sfucn> cdL0;
		
		String str="";	
		if(c==1){
			cdL0=Sfucn.dao.find(" select id,mc from sfucn where  fid=0  order by xh");
		}else{
			
			 cdL0=Sfucn.dao.find(" select id,mc from sfucn where  fid=0 and id in( select fid from srcd where id="+c+") order by xh");
		}
		
		for(Sfucn n0:cdL0){
			List<Sfucn> cdL1;
			str+="<li><a>"+n0.getStr("mc")+"</a><ul>";
			 
			if(c==1){
				cdL1=Sfucn.dao.find(" select mc,link,rel from sfucn where  fid="+n0.getInt("id")+"  order by xh");
			}else{
				cdL1=Sfucn.dao.find(" select mc,link,rel from sfucn where  fid="+n0.getInt("id")+" and id in( select fid from srcd where id="+c+") order by xh");
			}
			for(Sfucn n1:cdL1){
				String rel=n1.getStr("rel");
				if(rel!=null&&"fr".equals(rel.substring(0,2))){
				    str+="<li><a href='"+n1.getStr("link")+"' target='navTab' rel='"+rel+"' external='true'>"+n1.getStr("mc")+"</a></li>	";
				}else{
					str+="<li><a href='"+n1.getStr("link")+"' target='navTab' rel='"+rel+"'>"+n1.getStr("mc")+"</a></li>	";
				}
			}
			str+="</ul></li>";
		}		
		return str;
	}
	/**
	 * 返回权限树
	 * @param c
	 * @return
	 */
	public static  String getCdtree(int c){
		int lmid=0;
		List<Sfucn> cdL0;
		
		String str="";	
		if(c==1){
			cdL0=Sfucn.dao.find(" select id,mc from sfucn where  fid=0  order by xh");
		}else{
			 cdL0=Sfucn.dao.find(" select id,mc from sfucn where  fid=0 and id in( select fid from srcd where id="+c+") order by xh");
		}
		
		String ztlm="";
		for(Sfucn n0:cdL0){
			List<Sfucn> cdL1;
			//<li><a title="招商动态" href="zsdt/index.htm" >招商动态</a></li>
			str+="<div class='accordionHeader'><h2><span>Folder</span>"+n0.getStr("mc")+"</h2></div><div class='accordionContent'><ul class='tree treeFolder'>";
			 
			if(c==1){
				cdL1=Sfucn.dao.find(" select mc,link,rel from sfucn where  fid="+n0.getInt("id")+"  order by xh");
			}else{
				cdL1=Sfucn.dao.find(" select mc,link,rel from sfucn where  fid="+n0.getInt("id")+" and id in( select fid from srcd where id="+c+") order by xh");
			}
			for(Sfucn n1:cdL1){
				String rel=n1.getStr("rel");
				if(rel!=null&&"fr".equals(rel.substring(0,2))){
				    str+="<li><a href='"+n1.getStr("link")+"' target='navTab' rel='"+rel+"' external='true'>"+n1.getStr("mc")+"</a></li>	";
				}else{
					str+="<li><a href='"+n1.getStr("link")+"' target='navTab' rel='"+rel+"'>"+n1.getStr("mc")+"</a></li>	";
				}
			}
			str+="</ul></div>";
		}		
		return str;
	}

	  public static String getFileml(int bh){
		  Scatlog catlog=Scatlog.dao.findFirst("select fh,mc from Scatlog where bh=?",bh);
		  Integer fh=catlog.getInt("fh");
		  if(fh==0){
			 return "项目文档>>"+catlog.getStr("mc"); 
		  }else{
			  return getFileml(fh)+">>"+catlog.getStr("mc");
		  }
		  
	  }


}
