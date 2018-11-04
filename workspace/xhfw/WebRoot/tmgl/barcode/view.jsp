<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="role/view" class="pageForm required-validate" 
	onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
		<fieldset>
			<legend>角色菜单基本信息</legend>
			<dl>
				<dt>编   号：</dt>
				<dd>
				<input name="role.id" type="text" size="30"  value="${role.id}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>名称：</dt>
				<dd>
				<input name="role.mc" class="required" type="text" size="30" value="${role.mc}" readonly="readonly"/>
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