<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="cpjgjl/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>产品加工基本信息</legend>
			<dl >
				<dt>条码编号：</dt>
				<dd>
				<input name='${cpjgjl.id==null?"add":"cpjgjl.id"}' type="hidden"  value="${cpjgjl.id}"/>
				<input name='cpjgjl.txm' size="30"  value="${cpjgjl.txm}" />
				</dd>
			</dl>
			<dl >
				<dt>设备名称：</dt>
				<dd>
				<input name="cpjgjl.mc" class="required" type="text" size="30" value="${cpjgjl.mc}" alt="请输入设备"/>
				</dd>
			</dl>
			<dl >
				<dt>数量：</dt>
				<dd>
				<input name="cpjgjl.num" class="required" type="text" size="30" value="${cpjgjl.num}" alt="请输入设备"/>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="60" rows="2" name="cpjgjl.ms">${cpjgjl.ms}</textarea>
				</dd>
			</dl>
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