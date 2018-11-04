<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="supplier/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>工作中心基本信息</legend>
			<dl >
				<dt>类别：</dt>
				<dd>
				<input name="supplier.lb" class="required" type="text" size="30" value="${supplier.lb}" />
				</dd>
			</dl>
			<dl >
				<dt>工厂：</dt>
				<dd>
				<input name="supplier.gc" class="required" type="text" size="30" value="${supplier.gc}" />
				</dd>
			</dl>
			<dl >
				<dt>工作中心：</dt>
				<dd>
				<input name="supplier.gzzx" class="required" type="text" size="30" value="${supplier.gzzx}" />
				</dd>
			</dl>
			<dl >
				<dt>短描述：</dt>
				<dd>
				<input name="supplier.dms" class="required" type="text" size="30" value="${supplier.dms}" />
				</dd>
			</dl>
			<input name='${supplier.id==null?"":"supplier.id"}' type="hidden"  value="${supplier.id}" />
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