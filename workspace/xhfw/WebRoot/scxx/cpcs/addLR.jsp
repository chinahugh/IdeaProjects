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
				
				<input name='cpcsjl.fid' type="hidden"  value="${cpcsjl.fid}" readonly="readonly"/>
				<input name="cpcsjl.fmc" class="required" type="text" size="25"  value="${cpcsjl.fmc}" readonly="readonly"/>
							
				</dd>
			</dl>
			<dl >
				<dt>条形码：</dt>
				<dd>
				<input name="cpcsjl.txm" class="required" type="text" size="25" value="${cpcsjl.txm}" />
				</dd>
			</dl>
			<c:forEach items="${list}" var="o">	
			    <dl >
				<dt>${o }：</dt>
				<dd>
				<input name="cpcssz.c" class="required" type="text" size="25" value="" />
				</dd>
			</dl>										
								<td></td>			
			</c:forEach>	

			
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