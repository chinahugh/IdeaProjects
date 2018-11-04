<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="supplier/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>工作中心基本信息</legend>
			<dl >
				<dt>类别：</dt>
				<dd>
				<input name="supplier.lb" readonly="readonly" type="text" size="30" value="${supplier.lb}" />
				</dd>
			</dl>
			<dl >
				<dt>工厂：</dt>
				<dd>
				<input name="supplier.gc" readonly="readonly" type="text" size="30" value="${supplier.gc}" />
				</dd>
			</dl>
			<dl >
				<dt>工作中心：</dt>
				<dd>
				<input name="supplier.gzzx" readonly="readonly" type="text" size="30" value="${supplier.gzzx}" />
				</dd>
			</dl>
			<dl >
				<dt>短描述：</dt>
				<dd>
				<input name="supplier.dms" readonly="readonly" type="text" size="30" value="${supplier.dms}" />
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