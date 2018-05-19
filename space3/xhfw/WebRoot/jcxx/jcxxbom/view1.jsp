<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="product/view" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
		<fieldset>
			<legend>产品基本信息</legend>
			<dl>
				<dt>物料号：</dt>
				<dd>
				<input name="product.wlh" type="text" size="30" value="${product.wlh}" readonly="readonly" />
				</dd>
			</dl>
			<dl>
				<dt>产品名称：</dt>
				<dd>
				<input name="product.wlm" type="text" size="70" value="${product.wlm}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>版本号：</dt>
				<dd>
				<input name="product.bbh" type="text" size="30" value="${product.bbh}" readonly="readonly"/>
				</dd>
			</dl>
			</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>