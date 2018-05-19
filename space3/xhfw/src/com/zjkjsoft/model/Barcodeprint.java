package com.zjkjsoft.model;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.zjkjsoft.util.BarcodeUtil;
/**
 * 角色
 */
@SuppressWarnings("serial")
public class Barcodeprint extends Model<Barcodeprint> {
	public static final Barcodeprint dao = new Barcodeprint();
	
	public Integer state(String ids ) {
		String sql="update barcodeprint set state=1 where id ="+ids;
		System.out.println("sql "+sql);
		return Db.update(sql);
	}
	
	/**
	 *
	 *判断是否有5个条码的产品是否一致
	 *
	 */
	public static String isEncasement(Barcode b) {
		String wlh1=findWlhByTm(b.getStr("tm1"));
		for(int i=2;i<6;i++) {
			if ("0".equals(b.getStr("tm"+i))) {
				continue;
			}
			if (!wlh1.equals(findWlhByTm(b.getStr("tm"+i)))) {
				return "条码1与条码"+i+"产品类型不符！";
			}
		}
		return null;
	}
	
	/**
	 *根据tm查找wlh
	 */
	public static String findWlhByTm(String tm) {
		String wlh=null;
		wlh=Db.queryStr(" select wlh from cpjc where txm=? ", tm);
		return wlh;
	}
	
	/**
	 * 
	 * 判断有几个有效条码
	 * 
	 */
	public static int getNum(Barcode b) {
		int num=0;
		if (!"0".equals(b.getStr("tm1"))) {
			num++;
		}
		if (!"0".equals(b.getStr("tm2"))) {
			num++;
		}
		if (!"0".equals(b.getStr("tm3"))) {
			num++;
		}
		if (!"0".equals(b.getStr("tm4"))) {
			num++;
		}
		if (!"0".equals(b.getStr("tm5"))) {
			num++;
		}
		return num;
	}
	
	/**
	 * 打印
	 */
	public static List<String> print(int id,String tompath) {
	
		String filpath = "tmgl/barcode/imag/";
		
		String fontname = "黑体";
		Font gfont = new Font(fontname, Font.PLAIN, 3);
		Font tfont = new Font(fontname, Font.BOLD, 3);

		String tm[]=new String[5];
		Barcode barcode=Barcode.dao.findById(id);
		int num=getNum(barcode);
		for (int i = 0; i < num; i++) {
			tm[i]=barcode.getStr("tm"+(i+1));
		}
		String ggxh=Db.queryStr(" select ggxh from jcxxmaterial where wlh=?", barcode.get("wlh"));
		
		List<String> fpath =new ArrayList<String>();
		try {
			 //获得条形码文件
			for(int i=0;i<num;i++) {
				File file = BarcodeUtil.getGenerate(tm[i], ggxh,tompath+filpath, gfont, tfont,  100,900);//得到图片	
				fpath.add(new String("tmgl/barcode/imag/"+file.getName()));
				//fpath.add(new String("../tmgl/barcode/imag/"+tm[i]+".png"));
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fpath;
	 }
}
