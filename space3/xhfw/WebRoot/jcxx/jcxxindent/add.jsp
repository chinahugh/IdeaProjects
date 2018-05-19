<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="jcxxindent/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>生产订单信息</legend>
			<dl >
				<dt>订单：</dt>
				<dd>
				<input name="jcxxIndent.dd" readonly="readonly" type="text" size="30" value="${jcxxIndent.dd}" />
				</dd>
			</dl>
			<dl >
				<dt>物料：</dt>
				<dd>
				<input name="jcxxIndent.wl" readonly="readonly" type="text" size="30" value="${jcxxIndent.wl}" />
				</dd>
			</dl>
			<dl >
				<dt>订单类型：</dt>
				<dd>
				<input name="jcxxIndent.ddlx" readonly="readonly" type="text" size="30" value="${jcxxIndent.ddlx}" />
				</dd>
			</dl>
			<dl >
				<dt>订单数量：</dt>
				<dd>
				<input name="jcxxIndent.ddsl" class="required" type="text" size="30" value="${jcxxIndent.ddsl}" />
				</dd>
			</dl>
			<dl >
				<dt>基本开始日期：</dt>
				<dd>
				<input name="jcxxIndent.jbksrq" readonly="readonly" type="text" size="30" value="${jcxxIndent.jbksrq}" />
				</dd>
			</dl>
			<dl >
				<dt>基本完成日期：</dt>
				<dd>
				<input name="jcxxIndent.jbwcrq" readonly="readonly" type="text" size="30" value="${jcxxIndent.jbwcrq}" />
				</dd>
			</dl>
			<dl >
				<dt>系统状态：</dt>
				<dd>
				<input name="jcxxIndent.xtzt" readonly="readonly" type="text" size="30" value="${jcxxIndent.xtzt}" />
				</dd>
			</dl>
			<dl >
				<dt>物料描述：</dt>
				<dd>
				<input name="jcxxIndent.wlms" readonly="readonly" type="text" size="70" value="${jcxxIndent.wlms}" />
				</dd>
			</dl>
			<dl >
				<dt>订单完成状态：</dt>
				<dd>
				<select class="combox" name="jcxxIndent.status">
							<option value="${jcxxIndent.status}"></option>
							<option value="已完成">已完成</option>
							<option value="未完成">未完成</option>
					</select>
				</dd>
			</dl>
				<input name='${jcxxIndent.id==null?" ":"jcxxIndent.id"}' type="hidden" size="30"  value="${jcxxIndent.id}" />
				<input name='${jcxxIndent.mrpkzz==null?" ":"jcxxIndent.mrpkzz"}' type="hidden" size="30"  value="${jcxxIndent.mrpkzz}" />
			</fieldset>

		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>