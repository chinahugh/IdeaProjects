package com.zjkjsoft.controller;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.ext.render.excel.PoiRender;
import com.jfinal.plugin.activerecord.Page;
import com.zjkjsoft.interceptor.ManagerPowerInterceptor;
import com.zjkjsoft.model.Barcode;
import com.zjkjsoft.model.BarcodeConf;
import com.zjkjsoft.model.Cpjc;
import com.zjkjsoft.model.JcxxComponents;
import com.zjkjsoft.model.JcxxIndent;
import com.zjkjsoft.model.JcxxMaterial;
import com.zjkjsoft.model.Material;
import com.zjkjsoft.util.BarcodeUtil;
import com.zjkjsoft.util.DateUtil;
import com.zjkjsoft.util.ImportExcel;
import com.zjkjsoft.validator.RoleValidator;

/**
 * BarcodeZJController 订单组件
 */

@Before(ManagerPowerInterceptor.class)
public class BarcodeZJController extends BaseController {
	private static String path = "/tmgl/barcodezj/";// jsp路径
	// navTabId
	private static String navTabId = "barcodezj";
	private static int id;

	@Override
	public String action() {
		return "订单组件";
	}

	/**
	 * 订单组件首页 <br/>
	 * 页面：/jcxx/components/list.jsp
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

	private Page<JcxxComponents> getPageData() {
		id = getParaToInt();
		String idd = JcxxIndent.dao.findFirst(" select * from jcxxindent where id=?", id).get("dd");
		String selectSQL = " SELECT *";
		String sql = "FROM jcxxcomponents where dd=" + idd;
		String wlms = getPara("wlms");
		if (wlms != null && !"".equals(wlms))
			sql += " and wlms like '%" + wlms + "%' ";
		String dd = getPara("dd");
		if (dd != null && !"".equals(dd))
			sql += " and dd like '%" + dd + "%' ";
		return JcxxComponents.dao.paginate(getParaToInt("pageNum", 1), getParaToInt("numPerPage", 20), selectSQL,
				sql + " order by id desc ");
	}

	/**
	 * 查看 <br/>
	 * 页面：/jcxx/components/view.jsp
	 */
	public void view() {
		setAttr("jcxxcomponents", JcxxComponents.dao.findById(getParaToInt()));
		render(path + "view.jsp");
	}

	/**
	 * 添加订单 <br/>
	 * 页面：/jcxx/components/add.jsp
	 */
	public void add() {
		redirect(path + "add.jsp");
	}

	public void print() {
		try {
			String date=DateUtil.getDateTime();
			String id = getPara("id");
			JcxxComponents jc = JcxxComponents.dao.findById(id);
			System.out.println("jcxxcomponents :" + id);
			int xqsl = Integer.parseInt(jc.getStr("xqsl"));// 需求数量
			int ddsl = Integer.parseInt(JcxxIndent.dao.findFirst("select * from jcxxindent where dd=?", jc.getStr("dd")).getStr("ddsl"));
			List<String> files = new ArrayList<>(ddsl * xqsl);

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
			for (int i = 0; i < ddsl * xqsl; i++) {
				int j = i;
				String msg = bmsg + BarcodeUtil.getXlm(xl, j + 1);
				while (Cpjc.dao.findBarcode(msg)) {	
					if ((j++ + "").length() > xl) {
						setAttr("msg", "该物料" + jc.getStr("wlh") + "序号超出界限！");
						render(path + "list.jsp");
						return;
					}
					msg = bmsg + BarcodeUtil.getXlm(xl, j + 1);
				}
				File file = BarcodeUtil.getGenerate(msg, tmsg, tompath + filpath, gfont, tfont, height, width);
				// 得到图片
				files.add(msg);

				String sqll="select * from cpjc where dd='"+jc.getStr("dd")+"'  and wlh='"+jc.getStr("syxq")+"'" ;
				System.out.println("sqll  "+sqll);
				 Cpjc.dao.toSave(msg,jc.getStr("dd"),jc.getStr("wlh"), getPara("cpjcjd.mc"), 
						 Cpjc.dao.findFirst(sqll).getInt("fid"),date);				 
			}
			setAttr("ids",BarcodeUtil.display1(files));
			setAttr("path", files);
			render(path + "print.jsp");
		} catch (IOException e) {
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
		JcxxComponents jc = JcxxComponents.dao.findById(getParaToInt());
		if (Cpjc.dao.findDd(jc.getStr("dd"), jc.getStr("wlh"))) {
			setAttr("msg", "该物料组件" + jc.getStr("wlh") + "条码已生成！");
			render(path + "list.jsp");
			return;
		}
		if (JcxxMaterial.dao.findWL(jc.getStr("wlh"))) {
			setAttr("msg", "物料组件" + jc.getStr("wlh") + "在物料信息表不存在！");
			render(path + "list.jsp");
			return;
		}
		if (!Cpjc.dao.findDd(jc.getStr("dd"), jc.getStr("syxq"))) {
			setAttr("msg", "请先生成此物料组件" + jc.getStr("wlh") + "订单"+jc.getStr("dd")+"的条码！");
			render(path + "list.jsp");
			return;
		}
		setAttr("jcxxcomponents", JcxxComponents.dao.findById(getParaToInt()));
		System.out.println("jcxxcomponents  " + JcxxComponents.dao.findById(getParaToInt()));
		render(path + "confprint.jsp");
	}
	
	public void state() {		
		Cpjc.dao.state(getPara("ids"));
		this.renderText("{\"statusCode\":\"200\"}");
	}

	

}
