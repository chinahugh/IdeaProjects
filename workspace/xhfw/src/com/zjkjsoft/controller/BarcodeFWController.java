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
import com.zjkjsoft.model.BarcodeConf;
import com.zjkjsoft.model.Cpjc;
import com.zjkjsoft.model.Fcpjc;
import com.zjkjsoft.model.JcxxIndent;
import com.zjkjsoft.model.JcxxMaterial;
import com.zjkjsoft.util.BarcodeUtil;
import com.zjkjsoft.util.DateUtil;

/**
 * BarcodeController 防伪条码
 */

@Before(ManagerPowerInterceptor.class)
public class BarcodeFWController extends BaseController {
	private static String path = "/tmgl/barcodefw/";// jsp路径
	// navTabId
	private static String navTabId = "barcodefw";

	@Override
	public String action() {
		return "防伪条码";
	}

	/**
	 * 条码管理首页 <br/>
	 * 页面：/xtgl/role/list.jsp
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

	private Page<JcxxIndent> getPageData()
	{
		String sql;
		String status=getPara("status1");
		long count=Db.queryLong("select count(*) as count from jcxxindent where state=1");
		if(status!=null&&!"".equals(status)) {
			if (count!=0) {
				sql=" from jcxxindent where 1=1 and state=1";
			} else {
				sql=" from jcxxindent where 1=1 ";
			}
			sql+=" and status like '%"+status+"%' ";	
		}else {
			if (count!=0) {
				sql=" from jcxxindent where status='未完成' and state=1";
			} else {
				sql=" from jcxxindent where status='未完成' ";
			}
		}
		String wlms=getPara("wlms");
		if(wlms!=null&&!"".equals(wlms))
			sql+=" and wlms like '%"+wlms+"%' ";	
		String dd=getPara("dd");
		if(dd!=null&&!"".equals(dd))
			sql+=" and dd like '%"+dd+"%' ";	
		String mrpkzz=getPara("mrpkzz");
		if(mrpkzz!=null&&!"".equals(mrpkzz))
			sql+=" and mrpkzz like '%"+mrpkzz+"%' ";
		return JcxxIndent.dao.paginate(getParaToInt("pageNum", 1),
				getParaToInt("numPerPage", 20), " select * ", sql+" order by id desc ");
	}

	/**
	 * 查看 <br/>
	 * 页面：/jcxx/indent/view.jsp
	 */
	public void view() {
		setAttr("jcxxindent", JcxxIndent.dao.findById(getParaToInt()));
		render(path + "view.jsp");
	}

	/**
	 * 打印
	 */
	public void print() {
		try {
			String date =DateUtil.getDateTime();
			JcxxIndent jc = JcxxIndent.dao.findById(getParaToInt("id"));
			int ddsl = Integer.parseInt(jc.getStr("ddsl"));// 订单数
			List<String> files = new ArrayList<>(ddsl);

			int width = Integer.parseInt(getPara("width"));
			int height = Integer.parseInt(getPara("height"));

			BarcodeConf barcodeConf = BarcodeConf.dao.findFirst("select * from barcodeconf where mc=?",
					getPara("cpjcjd.mc"));// 获取条码生成方式
			String tmsg = barcodeConf.getZDT(jc.getStr("wl"));
			String bmsg = barcodeConf.getZDB(jc.getStr("wl"));
			if(bmsg.contains("*")||tmsg.contains("*")) {
				setAttr("msg", "该物料" + jc.getStr("wl") + "无图号或规格型号！");
				render(path + "list.jsp");
				return;
			}
			int xl = barcodeConf.getInt("cd") - bmsg.length();

			String tompath = this.getSession().getServletContext().getRealPath("/");
			String filpath = "tmgl/barcodefw/imag/";

			Font gfont = new Font(getPara("bf"), Font.BOLD, 2);
			Font tfont = new Font(getPara("tf"), Font.BOLD, 2);
			// 获得条形码文件
			for (int i = 0; i < ddsl; i++) {
				int j = i;
				String msg = bmsg + BarcodeUtil.getXlm(xl, j + 1);
				while (Fcpjc.dao.findBarcode(msg)) {
					if ((j++ + "").length() > xl) {
						setAttr("msg", "该物料" + jc.getStr("wl") + "序号超出界限！");
						render(path + "list.jsp");
						return;
					}
					msg = bmsg + BarcodeUtil.getXlm(xl, j + 1);
				}
				File file = BarcodeUtil.getGenerate(msg, tmsg, tompath + filpath, gfont, tfont, height, width);
				// 得到图片
				files.add(new String(filpath + file.getName()));
				Fcpjc.dao.toSave(msg, jc.getStr("dd"),jc.getStr("wl"), getPara("cpjcjd.mc"), getParaToInt("cpjcjd.fid"),date);
			}
			setAttr("ids", BarcodeUtil.display1(files));
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
		JcxxIndent dd = JcxxIndent.dao.findById(getParaToInt());
		if (Fcpjc.dao.findDd(dd.getStr("dd"), dd.getStr("wl"))) {
			setAttr("msg", "该订单" + dd.getStr("dd") + "物料" + dd.getStr("wl") + "防伪条码已生成！");
			render(path + "list.jsp");
			return;
		}		
		if (JcxxMaterial.dao.findWL(dd.getStr("wl"))) {
			setAttr("msg", "物料" + dd.getStr("wl") + "在物料信息表不存在！");
			render(path + "list.jsp");
			return;
		}
		setAttr("jcxxindent",dd);
		render(path + "confprint.jsp");
	}
	public void state() {		
		System.out.println("ids"+getPara("ids"));
		Fcpjc.dao.state(getPara("ids"));
		this.renderText("{\"statusCode\":\"200\"}");
	}

	
}
