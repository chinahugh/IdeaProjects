package com.zjkjsoft.controller;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Barcode;
import com.zjkjsoft.model.BarcodeConf;
import com.zjkjsoft.model.Barcodeprint;
import com.zjkjsoft.model.Cpjc;
import com.zjkjsoft.model.JcxxIndent;
import com.zjkjsoft.model.JcxxMaterial;
import com.zjkjsoft.util.BarcodeUtil;
import com.zjkjsoft.util.DateUtil;

/**
 * BarcodeController 条码打印
 */

@Before(ManagerPowerInterceptor.class)
public class BarcodeprintController extends BaseController {
	private static String path = "/tmgl/barcodeprint/";// jsp路径
	// navTabId
	private static String navTabId = "barcodeprint";
	private static String key = "mc";// 查询关键字字段名

	@Override
	public String action() {
		return "条码打印";
	}

	/**
	 * 条码管理首页 <br/>
	 * 页面：tmgl/barcodeprint/list.jsp
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

	private Page<Barcodeprint> getPageData() {
		String sql = " from barcodeprint where 1=1 ";
		String wlh = getPara("wlh");
		if (wlh != null && !"".equals(wlh))
			sql += " and wlh like '%" + wlh + "%' ";
		return Barcodeprint.dao.paginate(getParaToInt("pageNum", 1), getParaToInt("numPerPage", 20), " select * ",
				sql + " order by id desc ");
	}

	/**
	 * 查看 <br/>
	 * 页面：tmgl/barcodeprint/view.jsp
	 */
	public void view() {
		setAttr("barcodeprint", Barcodeprint.dao.findById(getParaToInt()));
		render(path + "view.jsp");
	}

	/**
	 * 添加订单 <br/>
	 * 页面：tmgl/barcodeprint/add.jsp
	 */
	public void add() {
		redirect(path + "add.jsp");
	}

	/**
	 * 删除
	 */
	public void delete() {
		Barcodeprint.dao.deleteById(getParaToInt());
		toDwzJson(200, "删除成功！", navTabId);
	}

	/**
	 * 保存数据到数据库
	 */
	public void save() {
		try {
			Barcodeprint m = getModel(Barcodeprint.class);
			if (m.get("id") != null) {
				m.update();
				toDwzJson(200, "修改操作成功", navTabId, "", "closeCurrent");
			} else {
				// m.set("id", "js_seq.nextval");
				/*
				 * m.set("czr", this.getSessionAttr("username")); m.set("date", IndexController.sfymdhms.format(new Date()));
				 */
				m.save();
				toDwzJson(200, "新增操作成功", navTabId, "", "closeCurrent");
			}
			// toDwzJson(200,"操作成功",navTabId,"","closeCurrent");
		} catch (Exception e) {
			e.printStackTrace();
			toDwzJson(300, "保存异常！", navTabId);
		}
	}

	/**
	 * 配置打印
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public void confprint() throws UnsupportedEncodingException {
		Barcodeprint barcodeprint = Barcodeprint.dao.findById(getParaToInt());
		if (Cpjc.dao.findDd(barcodeprint.getStr("dd"), barcodeprint.getStr("wlh"))) {
			setAttr("msg", "该物料" + barcodeprint.getStr("dd") + "物料" + barcodeprint.getStr("wlh") + "条码已打印！");
			render(path + "list.jsp");
			return;
		}
		if (JcxxMaterial.dao.findWL(barcodeprint.getStr("wlh"))) {
			setAttr("msg", "物料" + barcodeprint.getStr("wlh") + "在物料信息表不存在！");
			render(path + "list.jsp");
			return;
		}
		
	
		setAttr("barcodeprint", barcodeprint);
		render(path + "confprint.jsp");
	}

	/**
	 * 打印
	 */
	public void print() {
		try {
			String date = DateUtil.getDateTime();
			Barcodeprint jc = Barcodeprint.dao.findById(getParaToInt("id"));
			int ddsl = jc.getInt("value");// 订单数
			List<String> files = new ArrayList<>(ddsl);

			int width = Integer.parseInt(getPara("width"));
			int height = Integer.parseInt(getPara("height"));

			BarcodeConf barcodeConf = BarcodeConf.dao.findFirst("select * from barcodeconf where mc=?",
					getPara("cpjcjd.mc"));// 获取条码生成方式
			String tmsg = barcodeConf.getZDT(jc.getStr("wlh"));
			String bmsg = barcodeConf.getZDB(jc.getStr("wlh"));
			if(bmsg.contains("*")||tmsg.contains("*")) {
				setAttr("msg", "该物料" + jc.getStr("wlh") + "无图号或规格型号！");
				render(path + "list.jsp");
				return;
			}
			int xl = barcodeConf.getInt("cd") - bmsg.length();

			String tompath = this.getSession().getServletContext().getRealPath("/");
			String filpath = "tmgl/barcode/imag/";

			Font gfont = new Font(getPara("bf"), Font.BOLD, 2);
			Font tfont = new Font(getPara("tf"), Font.BOLD, 2);
			// 获得条形码文件
			for (int i = 0; i < ddsl; i++) {
				int j = i;
				String msg = bmsg + BarcodeUtil.getXlm(xl, j + 1);
				while (Cpjc.dao.findBarcode(msg)) {
					if ((j++ + "").length() > xl) {
						setAttr("msg", "该物料" + jc.getStr("wl") + "序号超出界限！");
						render(path + "list.jsp");
						return;
					}
					msg = bmsg + BarcodeUtil.getXlm(xl, j + 1);
				}
				File file = BarcodeUtil.getGenerate(msg, tmsg, tompath + filpath, gfont, tfont, height, width);
				// 得到图片
				files.add(new String(msg));

				Cpjc.dao.toSave(msg, jc.getStr("dd"), jc.getStr("wlh"), getPara("cpjcjd.mc"),null,date);
			}
			setAttr("ids", BarcodeUtil.display1(files));// 条码 
			setAttr("id", getParaToInt("id"));// id
			setAttr("path", files);
			render(path + "print.jsp");
		} catch (IOException e) {
			e.printStackTrace();
			toDwzJson(300, "保存异常！", navTabId);
		}
	}

	/**
	 * 订单的修改 编辑 <br/>
	 * 页面：tmgl/barcodezxsm/add.jsp
	 */
	public void edit() {
		setAttr("barcode", Barcode.dao.findById(getParaToInt()));
		render(path + "add.jsp");
	}
	
	/**
	 * 订单的修改 编辑 <br/>
	 * 页面：tmgl/barcodezxsm/add.jsp
	 */
	public void state() {
		Cpjc.dao.state(getPara("ids"));
		Barcodeprint.dao.state(getPara("id"));
		this.renderText("{\"statusCode\":\"200\"}");
	}
}
