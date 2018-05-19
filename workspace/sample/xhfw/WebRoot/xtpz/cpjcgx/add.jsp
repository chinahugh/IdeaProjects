<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="cpjcgx/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>检测工序菜单基本信息</legend>
			<dl >
				<dt>名称：</dt>
				<dd>
				<input name='${cpjcgx.id==null?"add":"cpjcgx.id"}' type="hidden"   value="${cpjcgx.id}" readonly="readonly"/>
				<input name="cpjcgx.mc" class="required" type="text" size="30" value="${cpjcgx.mc}" alt="请输入检测工序姓名"/>
				</dd>
			</dl>
			<dl >
				<dt>序号：</dt>
				<dd>
				
				<input name="cpjcgx.xh" class="required digits" type="text" size="30" value="${cpjcgx.xh}" />
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="60" rows="2" name="cpjcgx.ms">${cpjcgx.ms}</textarea>
				</dd>
			</dl>
			<dl >
				<dt>产品名称：</dt>
				<dd>
				<input name='cpjcgx.fid' type="hidden" size="30"  value="${product.id}" readonly="readonly"/>
				<input name="product.mc" class="required" type="text" size="30"readonly="readonly" value="${product.mc}" />
				</dd>
			</dl>
			<dl >
				<dt>版本：</dt>
				<dd>
				<input name="product.banben"  type="text" size="30" readonly="readonly"  value="${product.banben}" />
				</dd>
			</dl>
			<dl >
				<dt>产品序列号：</dt>
				<dd>
				<input name="product.cpxlh"  type="text" size="30" readonly="readonly" value="${product.cpxlh}" />
				</dd>
			</dl>
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