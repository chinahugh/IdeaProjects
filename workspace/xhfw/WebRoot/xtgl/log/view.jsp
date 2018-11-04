<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="pageContent">
	<form method="post" action="syslog/view" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
		<fieldset>
			<legend>日志基本信息</legend>
			<dl>
				<dt>帐号：</dt>
				<dd>
				<input name="syslog.uid" type="text" size="30"  value="${syslog.loginname}" readonly="readonly"/>
				</dd>
			</dl>

						<dl>
				<dt>时间：</dt>
				<dd>
				<input name="syslog.id" type="text" size="30"  value="<fmt:formatDate value="${syslog.ctime}" pattern="yyyy-MM-dd HH:mm:ss"/>" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>模块：</dt>
				<dd>
				<input name="syslog.mc" class="required" type="text" size="30" value="${syslog.mc}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>IP：</dt>
				<dd>
				<input name="syslog.mc" class="required" type="text" size="30" value="${syslog.ip}" readonly="readonly"/>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="70" rows="2" name="syslog.ms" readonly="readonly" >${syslog.ms}</textarea>
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