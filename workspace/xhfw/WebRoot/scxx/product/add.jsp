<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="product/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>产品基本信息</legend>
		    <dl >
				<dt>物料编号：</dt>
				<dd>
				<input name='${product.id==null?"add":"product.id"}' type="hidden" size="30"  value="${product.id}" readonly="readonly"/>
				<input name="product.wlh" class="required" type="text" size="25" readonly="readonly" value="${product.wlh}" />
				<a class="btnLook" href="listWLLoop?a=wlh&b=wlms&c=wlth&d=ggxh" lookupGroup="product">查找带回</a>
				</dd>
			</dl>	
			<dl >
				<dt>图号：</dt>
				<dd>
				<input name="product.wlth" class="required" type="text" size="30" readonly="readonly" value="${product.wlth}" />
				</dd>
			</dl>		
			 <dl >
				<dt>产品名称：</dt>
				<dd>
				<input name="product.wlms" class="required" type="text" size="70" readonly="readonly" value="${product.wlms}" />
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