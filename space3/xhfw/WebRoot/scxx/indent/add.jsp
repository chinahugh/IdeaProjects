<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="indent/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>订单基本信息</legend>
			<dl >
				<dt>编   号：</dt>
				<dd>
				<input name='${indent.id==null?"add":"indent.id"}' type="text" size="30"  value="${indent.id}" readonly="readonly"/>
				</dd>
			</dl>
			<dl >
				<dt>名称：</dt>
				<dd>
				<input name="indent.mc" class="required" type="text" size="30" value="${indent.mc}" />
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="60" rows="2" name="indent.ms">${indent.ms}</textarea>
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