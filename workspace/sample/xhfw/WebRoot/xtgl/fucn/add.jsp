<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="sfucn/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<fieldset>
			<legend>菜单基本信息</legend>
			<input name= '${sfucn.id==null?"add":"sfucn.id"}' type="hidden"   value="${sfucn.id}" size="30"/>
			<dl>
				<dt>父编号：</dt>
				<dd>
				<input name="sfucn.fid" class="required digits" type="text"   value="${sfucn.fid}" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>名称：</dt>
				<dd>
				<input name="sfucn.mc" class="required" type="text"  value="${sfucn.mc}" alt="请输入菜单名称" size="30"/>
				</dd>
			</dl>
			<dl>
				<dt>路径：</dt>
				<dd>
				<input name="sfucn.link" type="text" class="required" value="${sfucn.link}" size="30"/>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				  <textarea cols="60" rows="2" name="sfucn.ms"  >${sfucn.ms}</textarea>
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