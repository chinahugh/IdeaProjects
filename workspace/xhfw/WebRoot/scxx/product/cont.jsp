<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="product/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>产品配置模版信息</legend>


		    <dl >
				<dt>物料编号：</dt>
				<dd>
				<input name='${product.id==null?"add":"product.id"}' type="hidden" size="30"  value="${product.id}" readonly="readonly"/>
				<input name="product.wlh" class="required" type="text" size="25" readonly="readonly" value="${product.wlh}" />
				
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
				<input name="product.bbh"  type="text" size="30" value="${product.banben}" readonly="readonly"/>
				</dd>
			</dl>
			
			<dl class="nowrap">
				<dt>产品配置模版：</dt>
				<dd>
				<textarea class="editor" name="product.cont" rows="50" cols="100" tools="simple">${product.cont}</textarea>
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