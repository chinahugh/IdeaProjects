<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="suser/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
		<fieldset>
			<legend>用户管理基本信息</legend>
			<dl>		
				<dt>用户帐号：</dt>
				<dd>
				<input name='${suser.id==null?"add":"suser.id"}' type="hidden"  value="${suser.id}" readonly="readonly"/>			
				<input name="suser.loginname" class="required alphanumeric" type="text"  value="${suser.loginname}" alt="请输入员工帐号"size="25"/>
				</dd>
			</dl>
			<dl>
				
				<dt>员工姓名：</dt>
				<dd>
                <input name="suser.username" class="required" type="text"  value="${suser.username}" alt="请输入员工姓名"size="25"/>
				</dd>
			</dl>
			<dl>
				
				<dt>登录密码：</dt>
				<dd>
                <input name="suser.password" class="required alphanumeric" minlength="4" type="password"  value="${suser.password}" alt="请输入登录密码"size="25"/>
				</dd>
			</dl>
			<dl>
				
				<dt>角色名称：</dt>
				<dd>
				<select name="suser.rid">
					<c:forEach items="${roles}" var="o" >
						<option value="${o.id}">${o.mc}</option>
					</c:forEach>
				</select>
				</dd>
			</dl>
			<dl>
				
				<dt>部门名称：</dt>
				<dd>
				
				<input type="hidden" name="suser.bmid" value="${suser.bmid}"size="25"/>			
				<input type="text" class="required" name="suser.bmmc" value="${suser.bmmc}"size="25"/>
				<a class="btnLook" href="treeBMLoop?a=bmid&b=bmmc" lookupGroup="suser">查找带回</a>	

				</dd>
			</dl>
				

			
			<!-- <dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="75" rows="2" name="suser.ms">${suser.ms}</textarea>
				</dd>
			</dl> -->
			
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