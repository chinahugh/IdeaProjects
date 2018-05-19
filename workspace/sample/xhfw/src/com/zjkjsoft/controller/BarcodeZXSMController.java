package com.zjkjsoft.controller;

import java.util.Date;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.common.IndexController;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Barcode;
import com.zjkjsoft.model.Barcodeprint;

/**
 * BarcodeController 装箱扫描 tmxx
 */

@Before(ManagerPowerInterceptor.class)
public class BarcodeZXSMController extends BaseController {
	private static String path = "/tmgl/barcodezxsm/";// jsp路径
	// navTabId
	private static String navTabId = "barcodezxsm";
	private static String key = "mc";// 查询关键字字段名

	@Override
	public String action() {
		return "装箱扫描";
	}

	/**
	 * 条码管理首页 <br/>
	 * 页面：tmgl/barcodezxsm/list.jsp
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

	private Page<Barcode> getPageData() {
		String sql=" from barcode where 1=1 ";
		String wlh=getPara("wlh");
		if(wlh!=null&&!"".equals(wlh))
			sql+=" and wlh like '%"+wlh+"%' ";	
		return Barcode.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}
	
	/**
	 * 查看 <br/>
	 * 页面：tmgl/barcodezxsm/view.jsp
	 */
	public void view() {
		setAttr("barcode", Barcode.dao.findById(getParaToInt()));
		render(path + "view.jsp");
	}

	/**
	 * 添加订单 <br/>
	 * 页面：tmgl/barcodezxsm/add.jsp
	 */
	public void add() {
		redirect(path + "add.jsp");
	}

	/**
	 * 删除
	 */
	public void delete() {
		Barcode.dao.deleteById(getPara());
		toDwzJson(200, "删除成功！", navTabId);
	}

	/**
	 * 保存数据到数据库
	 */
	public void save() {
		String tompath = this.getSession().getServletContext().getRealPath("/");
		try {
			Barcode m = getModel(Barcode.class);
			if (m.get("id") != null) {
				m.update();
				toDwzJson(200, "修改操作成功", navTabId, "", "closeCurrent");
			} else {
				// m.set("id", "js_seq.nextval");
				String b=Barcodeprint.isEncasement(m);
				if (b==null) {
					m.set("wlh", Barcodeprint.findWlhByTm(m.getStr("tm1")));
					m.set("czr", this.getSessionAttr("username"));
					m.set("date", IndexController.sfymdhms.format(new Date()));
					m.save();
					int id=m.getInt("id");
					setAttr("path", Barcodeprint.print(id,tompath));
					render(path + "print.jsp");
				} else {
					//toDwzJson(200, b, navTabId);
					setAttr("msg", b);
					setAttr("barcode", m);
					render(path+"add.jsp");
				}
			}
			// toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
		} catch (Exception e) {
			e.printStackTrace();
			toDwzJson(300, "保存异常！", navTabId);
		}
	}
	
	/**
	 * 打印
	 */
	public void print1() {	
		String tompath = this.getSession().getServletContext().getRealPath("/");
		setAttr("path", Barcodeprint.print(getParaToInt(), tompath));
		render(path + "print.jsp");
	}
	
	
	/**
	 * 订单的修改 编辑 <br/>
	 * 页面：tmgl/barcodezxsm/add.jsp
	 */
	public void edit() {
		setAttr("barcode", Barcode.dao.findById(getParaToInt()));
		render(path + "add.jsp");
	}

}
