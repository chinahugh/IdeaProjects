<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>部门管理基本信息</legend>
			<dl>
				<dt>名称：</dt>
				<dd>
				<input  value="${sorg.mc}" readonly="readonly"/>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="70" rows="2" readonly="readonly" >${sorg.ms}</textarea>
				</dd>
			</dl>

		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</fieldset>
</div>