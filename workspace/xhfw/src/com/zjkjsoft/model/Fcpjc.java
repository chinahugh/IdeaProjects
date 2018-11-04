package com.zjkjsoft.model;

import java.io.IOException;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
/**
 * 角色
 */
@SuppressWarnings("serial")
public class Fcpjc extends Model<Fcpjc> {
	public static final Fcpjc dao = new Fcpjc();
	
	public Integer state(String ids ) {
		String sql="update fcpjc set state=1 where ftxm in("+ids+")";
		System.out.println("sql"+sql);
		return Db.update(sql);
	}
	public Integer stateid(String ids ) {
		String sql="update fcpjc set state=1 where id in("+ids+")";
		System.out.println("sql "+sql);
		return Db.update(sql);
	}
	
	/**
	 * 
	 * @param dd
	 * @param wlh
	 * @return
	 */
	public boolean findDd(String dd, String wlh) {
		return Db.queryLong("select count(1) from fcpjc where dd='" + dd + "'  and wlh='" + wlh+"'") > 0;
	}
	public boolean findBarcode(String txm) {
		return Db.queryLong("select count(1) from fcpjc where ftxm=?", txm) > 0;
	}
	/**
	 * 保存条码信息
	 * @param txm
	 * @param id
	 * @param fs
	 * @param fid
	 * @throws IOException
	 */
	public void toSave(String ftxm, String dd,String wl, String fs, Integer fid,String scrq) throws IOException {
		Fcpjc fcpjc = new Fcpjc();
		fcpjc.set("ftxm", ftxm);// 条码信息
		fcpjc.set("wlh", wl);// 物料号
		fcpjc.set("fs", fs); // 条码方式
		fcpjc.set("fid", fid);// 版本id
		fcpjc.set("dd", dd);// 订单号
		JcxxMaterial mat = JcxxMaterial.dao.findFirst("select * from jcxxmaterial where wlh=?",wl);
		fcpjc.set("wlm", mat.getStr("wlms")); // 物料述
		fcpjc.set("state", "0"); // 条码状态
		fcpjc.set("scrq", scrq);
		fcpjc.save();
	}
}
