<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="/users/view" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>用户管理基本信息</legend>
			<dl>		
				<dt>用户帐号：</dt>
				<dd>
				<input name="users.loginname"  type="text" size="30" value="${users.loginname}" readonly="readonly"/>
				</dd>
			</dl>
			
			<dl>
			<dt>员工名称：</dt>
				<dd>
		
				<input type="text"  name="users.username" value="${users.username}" readonly="readonly" size="30" />
				</dd>
			</dl>
			<dl>
				<dt>角色名称：</dt>	
				<dd>			
			
				<input type="text" value="${rolName}" readonly="readonly" size="30"/>
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