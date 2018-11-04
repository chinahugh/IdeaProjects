<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="bom/view" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
		<fieldset>
			<legend>BOM基本信息</legend>
			<dl>
				<dt>物料号：</dt>
				<dd>
				<input name="bom.wlh" type="text" size="30"  value="${bom.wlh}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料描述：</dt>
				<dd>
				<input name="bom.wlms" type="text" size="70" value="${bom.wlms}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料图号：</dt>
				<dd>
				<input name="bom.wlth" type="text" size="30" value="${bom.wlth}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>组件：</dt>
				<dd>
				<input name="bom.zj" type="text" size="30" value="${bom.zj}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>组件数量：</dt>
				<dd>
				<input name="bom.zjsl" type="text" size="30" value="${bom.zjsl}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>组件描述：</dt>
				<dd>
				<input name="bom.zjms" type="text" size="70" value="${bom.zjms}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>组件图号：</dt>
				<dd>
				<input name="bom.zjth" type="text" size="30" value="${bom.zjth}" readonly="readonly"/>
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