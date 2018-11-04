<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="cpjcjl/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>产品测试信息</legend>

			<dl >
				<dt>条形码：</dt>
				<dd>
				<input name="cpjcjl.txm" class="required" type="text" size="25" value="${cpjcjl.txm}" />
				<input name="cpjcjl.fid"  type="hidden" size="25" value="${cpjcjl.fid}" />
				<input name="cpjcjl.xh"  type="hidden" size="25" value="${cpjcjl.xh}" />
				</dd>
			</dl>
			<c:forEach items="${xmL}" var="o">	
			    <dl >
				<dt>${o.mc }：</dt>
				<dd>
				<input name="xid"  type="hidden" size="25" value="${o.id }" />
				<input name="sz" class="required" type="text" size="25" value="" />
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