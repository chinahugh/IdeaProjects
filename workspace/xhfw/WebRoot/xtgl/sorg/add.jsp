<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="sorg/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>部门管理基本信息</legend>
			<dl>
				<dt>名称：</dt>
				<dd>
				<input name='${sorg.id==null?"add":"sorg.id"}' type="hidden"  value="${sorg.id}" />
				<input name="sorg.fid" type="hidden"   value="${param.fid}" />
				<input name="sorg.mc" class="required" type="text" size="30" value="${sorg.mc}" alt="请输入部门名称"/>
				</dd>
			</dl>
			<dl>
				<dt>序号：</dt>
				<dd>
				<input name="sorg.xh" class="required digits" onclick="func1()" type="text" size="30" value="${sorg.xh}" />
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="70" rows="2" name="sorg.ms" >${sorg.ms}</textarea>
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
	</fieldset>
</div>