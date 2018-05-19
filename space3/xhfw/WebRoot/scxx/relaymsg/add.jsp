<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="relaymsg/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>检测台信息</legend>
			<dl >
				<dt>编   号：</dt>
				<dd>
				<input name='${relaymsg.id==null?"add":"relaymsg.id"}' type="text" size="30"  value="${relaymsg.id}" readonly="readonly"/>
				</dd>
			</dl>
			<dl >
				<dt>产品编号：</dt>
				<dd>
				<input name="relaymsg.bh" class="required" type="text" size="30" value="${relaymsg.bh}" />
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>检测项目1：</dt>
				<dd>
				<input name="relaymsg.bh" class="required" type="text" size="30" value="${relaymsg.bh}" />
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>检测项目1描述：</dt>
				<dd>
				<textarea cols="70" rows="2" name="role.ms" readonly="readonly" >${role.ms}</textarea>
				</dd>
			</dl>
			<dl >
				<dt>检测项目2：</dt>
				<dd>
				<input name="relaymsg.bh" class="required" type="text" size="30" value="${relaymsg.bh}" />
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>检测项目2描述：</dt>
				<dd>
				<textarea cols="70" rows="2" name="role.ms" readonly="readonly" >${role.ms}</textarea>
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