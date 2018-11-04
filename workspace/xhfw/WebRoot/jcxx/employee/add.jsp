<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="employee/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>人员基本信息</legend>
			<dl >
				<dt>编号：</dt>
				<dd>
				<input name="employee.bh" class="required" type="text" size="30" value="${employee.bh}" />
				</dd>
			</dl>
			<dl >
				<dt>姓名：</dt>
				<dd>
				<input name="employee.xm" class="required" type="text" size="30" value="${employee.xm}" />
				</dd>
			</dl>
			<dl >
				<dt>组织单位：</dt>
				<dd>
				<input name="employee.zzdw" class="required" type="text" size="30" value="${employee.zzdw}" />
				</dd>
			</dl>
			<dl >
				<dt>职位：</dt>
				<dd>
				<input name="employee.zw" class="required" type="text" size="30" value="${employee.zw}" />
				</dd>
			</dl>
				<input name='${employee.id==null?"add":"employee.id"}' type="hidden" size="30"  value="${employee.id}" />
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