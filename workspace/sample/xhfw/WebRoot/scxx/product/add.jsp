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
				<a class="btnLook" href="listWLLoop?a=wlh&b=wlm&c=with" lookupGroup="product">查找带回</a>
				</dd>
			</dl>	
			 <dl >
				<dt>产品名称：</dt>
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
			<dl >
				<dt>版本：</dt>
				<dd>
				<input name="product.bbh"  type="text" size="30" value="${product.bbh}" />
				</dd>
			</dl>
			<dl >
				<dt>铁道部码：</dt>
				<dd>
				<input name="product.cpxlh"  type="text" size="30" value="${product.cpxlh}" />
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