<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="material/view" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
		<fieldset>
			<legend>物料基本信息</legend>
			<dl>
				<dt>工厂：</dt>
				<dd>
				<input name="material.gc" type="text" type="text" size="30" value="${material.gc}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料号：</dt>
				<dd>
				<input name="material.wlh" type="text" size="30"  value="${material.wlh}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料图号：</dt>
				<dd>
				<input name="material.wlth" type="text" size="30" value="${material.wlth}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>规格型号：</dt>
				<dd>
				<input name="material.ggxh" type="text" size="30" value="${material.ggxh}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料描述：</dt>
				<dd>
				<input name="material.wlms" type="text" size="70" value="${material.wlms}" readonly="readonly"/>
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