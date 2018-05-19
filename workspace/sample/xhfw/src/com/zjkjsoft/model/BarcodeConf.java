package com.zjkjsoft.model;

import java.io.IOException;

import com.jfinal.plugin.activerecord.Model;
import com.zjkjsoft.util.DateUtil;
/**
 * 角色
 */
@SuppressWarnings("serial")
public class BarcodeConf extends Model<BarcodeConf> {
	public static final BarcodeConf dao = new BarcodeConf();
	private String wl;
	
	/**
	 * 通过配置字段使用方法
	 * 
	 * @param msg
	 * @param s
	 * @param c
	 * @return
	 */
	public String getMethed(String msg, int s, int c) throws IOException{
		if (msg.equals("企业编号")) {
			return getQybm();
		}
		if (msg.equals("规格图号")) {
			return JcxxMaterial.dao.getWlth(wl,s, c);
		}
		if (msg.equals("规格型号")) {
			return JcxxMaterial.dao.getGgxh(wl,s, c);
		}
		if (msg.equals("年月日")) {
			return DateUtil.getDateFormat(1);
		}
		if (msg.equals("年月")) {
			return DateUtil.getDateFormat(2);
		}
		if (msg.equals("物料号")) {
			return wl;
		}
		if (!msg.equals("序列") && msg != null && !"".equals(msg) && msg.length() > 0) {
			return msg.substring(0, c - s + 1);
		}
		return "";
	}
	
	/**
	 * 得到字段信息
	 * 
	 * @param barcodeConf
	 * @return
	 */
	public String getZd(String zdm, String zdms, String zdmc)throws IOException {
		String zd = this.getStr(zdm);
		if (zd != null && !"".equals(zd)) {
			int s = Integer.parseInt(this.getStr(zdms));
			int c = Integer.parseInt(this.getStr(zdmc));
			return getMethed(zd, s, c);
		} else {
			return "";
		}
	}
	
	/**
	 * 企业代码
	 * 
	 * @return
	 */
	private String getQybm() {
		return "159732";
	}
	public String getZDT(String wl) throws IOException {
		this.wl=wl;		
		return this.getZd("t1", "t1s", "t1c");
	}
	public String getZDB(String wl) throws IOException {
		this.wl=wl;		
		String bmsg1 = this.getZd("d1", "d1s", "d1c");
		String bmsg2 = this.getZd("d2", "d2s", "d2c");
		String bmsg3 = this.getZd("d3", "d3s", "d3c");
		String bmsg4 = this.getZd("d4", "d4s", "d4c");
		String bmsg5 = this.getZd("d5", "d5s", "d5c");
		String bmsg6 = this.getZd("d6", "d6s", "d6c");
		String bmsg = bmsg1 + bmsg2 + bmsg3 + bmsg4 + bmsg5 + bmsg6;
		return new String(bmsg);
	}
}
