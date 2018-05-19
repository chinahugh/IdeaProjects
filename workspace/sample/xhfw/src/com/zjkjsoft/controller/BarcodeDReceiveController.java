package com.zjkjsoft.controller;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.BarcodeReceive;
import com.zjkjsoft.util.DateUtil;
import com.zjkjsoft.validator.RoleValidator;

/**
 * RoleController 条码领取
 */

@Before(ManagerPowerInterceptor.class)
public class BarcodeDReceiveController extends BaseController {
	private static String path = "/tmgl/barcodedreceive/";// jsp路径
	// navTabId
	private static String navTabId = "barcodedreceive";
	private static String key = "mc";// 查询关键字字段名

	@Override
	public String action() {
		return "条码领取";
	}

	/**
	 * 二维码管理首页 <br/>
	 * 页面：/tmgl/barcodereceive/list.jsp
	 */
	@Override
	public void index() {
		setAttr("page", getPageData());
		setAttr("fid", getParaToInt());
		render(path + "list.jsp");
	}

	/**
	 * 模糊查询
	 */
	public void list() {		
		setAttr("page", getPageData());
		render(path + "list.jsp");
	}

	private Page<BarcodeReceive> getPageData() {
		String sql = " from barcodeReceive where tag=3 and fid= '" + getPara()+"'";
		String ygh = getPara("ygh");
		if (ygh != null && !"".equals(ygh))
			sql += " and ygh like '%" + ygh + "%' order by id desc";
		return BarcodeReceive.dao.paginate(getParaToInt("pageNum", 1), getParaToInt("numPerPage", 20), " select * ",
				sql);
	}

	/**1517560644624
	 * 查看 <br/>
	 * 页面：/tmgl/barcode1517560644624receive/view.jsp
	 */
	public void view() {
		setAttr("barcodeReceive", BarcodeReceive.dao.findById(getParaToInt()));
		render(path + "view.jsp");
	}

	/**
	 * 添加二维码 <br/>
	 * 页面：/tmgl/barcodereceive/add.jsp
	 */
	public void add() {
		setAttr("fid", getPara());
		render(path + "add.jsp");
	}

	/**
	 * 保存数据到数据库
	 */
	@Before(RoleValidator.class)
	public void save() {
		try {			
			BarcodeReceive m = getModel(BarcodeReceive.class);
			m.set("date", DateUtil.getDateTime());
		
			if (m.get("id") != null) {
				m.update();
				toDwzJson(200, "修改操作成功", navTabId, "", "closeCurrent");
			} else {
				// m.set("id", "js_seq.nextval");
				System.out.println(m);
				m.set("tag", "3");
				m.save();
				System.out.println(m);
				toDwzJson(200, "新增操作成功", navTabId, "", "closeCurrent");
			}
			// toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
		} catch (Exception e) {
			e.printStackTrace();
			toDwzJson(300, "保存异常！", navTabId);
		}
	}

	/**
	 * 二维码的修改 编辑 <br/>
	 * 页面：/tmgl/barcodereceive/add.jsp
	 */
	public void edit() {
		setAttr("barcodereceive", BarcodeReceive.dao.findById(getParaToInt()));
		render(path + "add.jsp");
	}

	/**
	 * 删除
	 */
	public void delete() {
		BarcodeReceive.dao.deleteById(getParaToInt());
		toDwzJson(200, "删除成功！", navTabId);
	}
}
