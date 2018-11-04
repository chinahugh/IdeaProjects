<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="indent/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>订单抬头信息</legend>
			<dl >
				<dt>订单：</dt>
				<dd>
				<input name="indent.dd" class="required" type="text" size="30" value="${indent.dd}" />
				</dd>
			</dl>
			<dl >
				<dt>物料：</dt>
				<dd>
				<input name="indent.wl" class="required" type="text" size="30" value="${indent.wl}" />
				</dd>
			</dl>
			<dl >
				<dt>订单类型：</dt>
				<dd>
				<input name="indent.ddlx" class="required" type="text" size="30" value="${indent.ddlx}" />
				</dd>
			</dl>
			<dl >
				<dt>订单数量：</dt>
				<dd>
				<input name="indent.ddsl" class="required" type="text" size="30" value="${indent.ddsl}" />
				</dd>
			</dl>
			<dl >
				<dt>基本开始日期：</dt>
				<dd>
				<input name="indent.jbksrq" class="required" type="text" size="30" value="${indent.jbksrq}" />
				</dd>
			</dl>
			<dl >
				<dt>基本完成日期：</dt>
				<dd>
				<input name="indent.jbwcrq" class="required" type="text" size="30" value="${indent.jbwcrq}" />
				</dd>
			</dl>
			<dl >
				<dt>系统状态：</dt>
				<dd>
				<input name="indent.xtzt" class="required" type="text" size="30" value="${indent.xtzt}" />
				</dd>
			</dl>
			<dl >
				<dt>物料描述：</dt>
				<dd>
				<input name="indent.wlms" class="required" type="text" size="70" value="${indent.wlms}" />
				</dd>
			</dl>
				<input name='${indent.id==null?" ":"indent.id"}' type="hidden" size="30"  value="${indent.id}" />
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