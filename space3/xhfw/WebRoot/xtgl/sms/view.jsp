<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="sfucn/view" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<fieldset>
			<legend>查看</legend>	
			<dl>
				<dt>父编号：</dt>
				<dd>
				<input type="text" value="${sfucn.fid}" readonly="readonly" />
				</dd>
			</dl>
			<dl>
				<dt>名称：</dt>
				<dd>
				<input type="text" value="${sfucn.mc}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>路径：</dt>
				<dd>
				<input type="text" value="${sfucn.link}" readonly="readonly" />
				<dd>
			</dl>
			<dl class="nowrap" >
				<dt>描述：</dt>
				<dd>
				<textarea cols="70" rows="2" name="cd.bz" readonly="readonly" >${sfucn.ms}</textarea>
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