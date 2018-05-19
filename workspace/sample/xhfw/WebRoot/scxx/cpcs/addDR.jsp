<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">

	<form method="post" action="cpcssz/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>产品测试信息</legend>
			<dl >
				<dt>测试模版：</dt>
				<dd>
				
				<input name='cpcssz.wlh' type="hidden"  value="${cpcssz.wlh}" readonly="readonly"/>
				<input name="cpcssz.wlm" class="required" type="text" size="25"  value="${cpcssz.wlm}" readonly="readonly"/>
								<a class="btnLook" href="listWLLoop?a=wlh&b=wlm" lookupGroup="cpcssz">查找带回</a>	
				</dd>
			</dl>
			<dl >
				<dt>条形码：</dt>
				<dd>
				<input name="cpcssz.txm" class="required" type="text" size="25" value="${cpcssz.txm}" />
				</dd>
			</dl>
		<dl >
				<dt>上传文件：</dt>
				<dd>
				<input name="cpcssz.mc" class="required" type="text" size="25" value="${cpcssz.mc}" />
				</dd>
			</dl>
			
			</fieldset>
		<div class="divider"></div>
		<h3 class="contentTitle">测试项目</h3>
					<table class="list" width="100%">
						<thead>
							<tr>
							<c:forEach items="${list}" var="o">											
								<td>${o }</td>			
							</c:forEach>																					
							</tr>
						</thead>
					</table>

	
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