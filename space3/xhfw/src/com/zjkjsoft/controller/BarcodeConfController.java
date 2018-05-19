package com.zjkjsoft.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.BarcodeConf;
import com.zjkjsoft.model.Cpjc;
import com.zjkjsoft.util.DateUtil;

/**
 * BarcodeController 条码配置
 */

@Before(ManagerPowerInterceptor.class)
public class BarcodeConfController extends BaseController {
	private static String path = "/tmgl/barcodeconf/";// jsp路径
	// navTabId
	private static String navTabId = "barcodeconf";
	private static String key = "mc";// 查询关键字字段名

	@Override
	public String action() {
		return "条码配置";
	}

	/**
	 * 条码管理首页 <br/>
	 * 页面：tmgl/barcodeconf/list.jsp
	 */
	@Override
	public void index() {
		setAttr("page", getPageData());
		render(path + "list.jsp");
	}

	/**
	 * 模糊查询
	 */
	public void list() {
		setAttr("page", getPageData());
		render(path + "list.jsp");
	}

	private Page<BarcodeConf> getPageData() {
		String sql = "from barcodeconf where 1=1 ";
		String mc = getPara("mc");
		if (mc != null && !"".equals(mc))
			sql += " and mc like '%" + mc + "%' ";
		return BarcodeConf.dao.paginate(getParaToInt("pageNum", 1), getParaToInt("numPerPage", 20), " select * ",
				sql + " order by id desc ");
	}

	/**
	 * 查看 <br/>
	 * 页面：tmgl/barcodeconf/view.jsp
	 */
	public void view() {
		setAttr("barcodeConf", BarcodeConf.dao.findById(getParaToInt()));
		setAttr("xzrq", DateUtil.getDateTime());
		render(path + "view.jsp");
	}

	/**
	 * 添加订单 <br/>
	 * 页面：tmgl/barcodeconf/add.jsp
	 */
	public void add() {
		setAttr("xzrq", DateUtil.getDateTime());
		render(path + "add.jsp");
	}

	/**
	 * 删除
	 */
	public void delete() {
		BarcodeConf.dao.deleteById(getPara());
		toDwzJson(200, "删除成功！", navTabId);
	}

	/**
	 * 保存数据到数据库
	 */
	public void save() {

		try {
			BarcodeConf m = getModel(BarcodeConf.class);
			m.set("xzrq", DateUtil.getDateTime());
			if (m.get("id") != null) {
				m.update();
				toDwzJson(200, "修改操作成功", navTabId, "", "closeCurrent");
			} else {
				System.out.println("m.getStr(\"mc\").trim() "+m.getStr("mc").trim());
				if (Db.queryLong("select count(1) from barcodeconf where mc=?", m.getStr("mc").trim()) <1) {
					m.save();
					toDwzJson(200, "新增操作成功", navTabId, "", "closeCurrent");
					return;
				} else {
					toDwzJson(300, "条码方式名称重复！", navTabId);
					return;
				}
			}
			// toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
		} catch (Exception e) {
			e.printStackTrace();
			toDwzJson(300, "保存异常！", navTabId);
		}
	}

	/**
	 * 订单的修改 编辑 <br/>
	 * 页面：tmgl/barcodeconf/add.jsp
	 */
	public void edit() {
		setAttr("barcodeConf", BarcodeConf.dao.findById(getParaToInt()));
		render(path + "add.jsp");
	}
}
