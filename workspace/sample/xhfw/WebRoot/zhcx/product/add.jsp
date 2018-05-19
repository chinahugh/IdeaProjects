<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="product/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>产品基本信息</legend>
			<dl >
				<dt>编   号：</dt>
				<dd>
				<input name='${product.id==null?"add":"product.id"}' type="text" size="30"  value="${product.id}" readonly="readonly"/>
				</dd>
			</dl>
			<dl >
				<dt>名称：</dt>
				<dd>
				<input name="product.mc" class="required" type="text" size="30" value="${product.mc}" />
				</dd>
			</dl>
			<dl >
				<dt>第二名称：</dt>
				<dd>
				<input name="product.nc" class="required" type="text" size="30" value="${product.nc}" />
				</dd>
			</dl>
		    <dl >
				<dt>产品编码：</dt>
				<dd>
				<input name="product.bm" class="required" type="text" size="30" value="${product.bm}" />
				</dd>
			</dl>			
			<dl >
				<dt>数量：</dt>
				<dd>
				<input name="product.num" class="required" type="text" size="30" value="${product.num}" />
				</dd>
			</dl>
			<dl >
				<dt>是否定做：</dt>
				<dd>
				<input name="product.isc" class="required" type="text" size="30" value="${product.isc}" />
				</dd>
			</dl>
			<dl >
				<dt>客户：</dt>
				<dd>
				<input name="product.cid" class="required" type="text" size="30" value="${product.cid}" />
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="60" rows="2" name="product.ms">${product.ms}</textarea>
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