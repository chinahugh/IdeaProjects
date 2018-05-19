<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="xm1/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>角色菜单基本信息</legend>
			<dl >
				<dt>编   号：</dt>
				<dd>
				<input name='${xm1.id==null?"add":"xm1.id"}' type="text" size="30"  value="${xm1.id}" readonly="readonly"/>
				</dd>
			</dl>
			<dl >
				<dt>名称：</dt>
				<dd>
				<input name="xm1.mc" class="required" type="text" size="30" value="${xm1.mc}" alt="请输入角色姓名"/>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="60" rows="2" name="xm1.ms">${xm1.ms}</textarea>
				</dd>
			</dl>
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