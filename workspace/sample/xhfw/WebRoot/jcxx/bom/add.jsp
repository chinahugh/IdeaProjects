<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="material/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>BOM基本信息</legend>
			<dl>
				<dt>物料：</dt>
				<dd>
				<input name="bom.wl" type="text" size="30" class="required" value="${bom.wl}" />
				</dd>
			</dl>
			<dl>
				<dt>物料描述：</dt>
				<dd>
				<input name="material.wlms" type="text" size="70" class="required" value="${material.wlms}" />
				</dd>
			</dl>
			<dl>
				<dt>物料图号：</dt>
				<dd>
				<input name="material.wlth" type="text" size="30" class="required" value="${material.wlth}" />
				</dd>
			</dl>
			<dl>
				<dt>组件：</dt>
				<dd>
				<input name="bom.zj" type="text" size="30" class="required" value="${bom.zj}" />
				</dd>
			</dl>
			<dl>
				<dt>组件数量：</dt>
				<dd>
				<input name="bom.zjsl" type="text" size="30" class="required" value="${bom.zjsl}" />
				</dd>
			</dl>
			<dl>
				<dt>组件描述：</dt>
				<dd>
				<input name="bom.zjms" type="text" size="70" class="required" value="${bom.zjms}" />
				</dd>
			</dl>
			<dl>
				<dt>组件图号：</dt>
				<dd>
				<input name="bom.zjth" type="text" size="30" class="required" value="${bom.zjth}" />
				</dd>
			</dl>
				<input name='${bom.id==null?"":"bom.id"}' type="hidden"  value="${bom.id}" />
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