<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="xm1/view" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
		<fieldset>
			<legend>角色菜单基本信息</legend>
			<dl>
				<dt>编   号：</dt>
				<dd>
				<input name="xm1.id" type="text" size="30"  value="${xm1.id}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>名称：</dt>
				<dd>
				<input name="xm1.mc" class="required" type="text" size="30" value="${xm1.mc}" readonly="readonly"/>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="70" rows="2" name="role.ms" readonly="readonly" >${role.ms}</textarea>
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