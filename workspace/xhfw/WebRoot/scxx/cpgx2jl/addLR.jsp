<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pageContent">
	<form method="post" action="cpgx2jl/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<fieldset>
			<legend>产品基本信息</legend>

		    <dl >
				<dt>物料号：</dt>
				<dd>
				<input name="product.wlh" class="required" type="text" size="30" readonly="readonly" value="${product.wlh}" />
				
				</dd>
			</dl>	
			 <dl >
				<dt>物料名：</dt>
				<dd>
				<input name="product.wlm" class="required" type="text" size="30" readonly="readonly" value="${product.wlm}" />
				</dd>
			</dl>
					    <dl >
				<dt>图号：</dt>
				<dd>
				<input name="product.with" class="required" type="text" size="30" readonly="readonly" value="${product.with}" />
				</dd>
			</dl>


			
			</fieldset>
			<fieldset>
			<legend>产品测试信息</legend>

			<dl >
				<dt>条形码：</dt>
				<dd>
				<input name="cpjcjl.txm" class="required" type="text" size="25" value="${cpjcjl.txm}" />
				<input name="cpjcjl.fid"  type="hidden" size="25" value="${product.id}" />
				<input id="xh" name="cpjc.xh"  type="hidden" size="25" value="${cpjc.xh==null?1:cpjc.xh}" />
				<input  name="cpjc.txm"  type="hidden" size="25" value="${cpjc.txm}" />
				<input  name="cpjc.fid"  type="hidden" size="25" value="${cpjc.fid}" />
				<input  name="cpjc.id"  type="hidden" size="25" value="${cpjc.id}" />
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
									
			</c:forEach>	

			
			</fieldset>

		</div>
		<div class="formBar">
			<ul>
			   <li><div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="$('#xh').val(parseInt($('#xh').val())+1)">下一步</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">暂存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
