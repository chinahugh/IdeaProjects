<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="barcode/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>条码菜单基本信息</legend>
			<dl >
				<dt>编   号：</dt>
				<dd>
				<input name='${barcode.id==null?"add":"barcode.id"}' type="text" size="30"  value="${barcode.id}" readonly="readonly"/>
				</dd>
			</dl>


			<dl >
				<dt>产品序列号：</dt>
				<dd>
				<input name="barcode.bh" class="required" type="text" size="30" value="${barcode.bh}" />
				</dd>
			</dl>
			<dl >
				<dt>关键件1：</dt>
				<dd>
				abc
				已绑定</dd>
			</dl>
			<dl >
				<dt>关键件1：</dt>
				<dd>
				cdb
				已绑定</dd>
			</dl>
			<dl >
				<dt>关键件3：</dt>
				<dd>
				<input name="barcode.dm4" class="required" type="text" size="20" value="${barcode.dm4}" />
				<input name="barcode.dm4"  type="button" size="10" value="绑定" />
				</dd>
			</dl>
									
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="60" rows="2" name="barcode.ms">${barcode.ms}</textarea>
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