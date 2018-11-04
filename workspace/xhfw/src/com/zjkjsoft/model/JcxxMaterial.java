package com.zjkjsoft.model;

import java.io.IOException;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;

/**
 * 角色
 */
@SuppressWarnings("serial")
public class JcxxMaterial extends Model<JcxxMaterial> {
	public static final JcxxMaterial dao = new JcxxMaterial();

	/**
	 * 规格图号
	 * 
	 * @param wlh
	 * @param ds
	 * @param dc
	 * @return
	 */
	public String getWlth(String wl, int s, int c) throws IOException {
		String sql = "select * from jcxxmaterial where state=1 and wlh=?";
		JcxxMaterial material = JcxxMaterial.dao.findFirst(sql, wl);
		if (material!=null&&material.getStr("wlth") != null) {
			return material.getStr("wlth").substring(0, c - s + 1);
		} else {
			return "*";
		}
	}

	/**
	 * 规格型号
	 * 
	 * @param wlh
	 * @param ds
	 * @param dc
	 * @return
	 */
	public String getGgxh(String wl, int s, int c) throws IOException {
		String sql = "select * from jcxxmaterial where state=1 and wlh=?";
		JcxxMaterial material = JcxxMaterial.dao.findFirst(sql, wl);
		if (material!=null&&material.getStr("ggxh") != null) {
			return material.getStr("ggxh").substring(0, c - s + 1);
		} else {
			return "*";
		}
	}

	public boolean findWL(String wlh) {
		return Db.queryLong("select count(1) from jcxxmaterial where state=1 and wlh=?", wlh) <= 0;
	}
}
