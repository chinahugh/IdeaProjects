<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="material/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>物料基本信息</legend>
			<dl>
				<dt>工厂：</dt>
				<dd>
				<input name="material.gc" class="required" type="text" size="30" value="${material.gc}" />
				</dd>
			</dl>
			<dl>
				<dt>物料：</dt>
				<dd>
				<input name="material.wl" class="required" size="30"  value="${material.wl}" />
				</dd>
			</dl>
			<dl>
				<dt>物料图号：</dt>
				<dd>
				<input name="material.wlth" class="required" type="text"  size="30" value="${material.wlth}" />
				</dd>
			</dl>
			<dl>
				<dt>物料描述：</dt>
				<dd>
				<input name="material.wlms" class="required" type="text" size="70" value="${material.wlms}" />
				</dd>
			</dl>
				<input name='${material.id==null?"":"material.id"}' type="hidden"  value="${material.id}" />
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