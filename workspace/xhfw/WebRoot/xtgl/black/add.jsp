<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="blacklist/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<fieldset>
			<legend>黑名单基本信息</legend>
			<input name= '${blacklist.id==null?"add":"blacklist.id"}' type="hidden"   value="${blacklist.id}" size="30"/>
			<dl>
				<dt>企业名称：</dt>
				<dd>
				<input name="blacklist.entity" class="required" type="text"   value="${blacklist.entity}" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>证件类型：</dt>
				<dd>
				<input name="blacklist.codetype" class="required" type="text"  value="${blacklist.codetype}" alt="请输入菜单名称" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>证件编号：</dt>
				<dd>
				<input name="blacklist.code" type="text" class="required" value="${blacklist.code}" size="30"/>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				  <textarea cols="60" rows="2" name="blacklist.ms"  >${blacklist.ms}</textarea>
				</dd>
			</dl>
			</fieldset>

		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>