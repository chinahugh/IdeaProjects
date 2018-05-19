<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="productkey/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>关键件基本信息</legend>
			<dl >
				<dt>编   号：</dt>
				<dd>
				<input name='${productkey.id==null?"add":"productkey.id"}' type="text" size="30"  value="${productkey.id}" readonly="readonly"/>
				</dd>
			</dl>
			<dl >
				<dt>编码：</dt>
				<dd>
				<input name="productkey.bm" class="required" type="text" size="30" value="${productkey.bm}" />
				</dd>
			</dl>
			<dl >
				<dt>物料id：</dt>
				<dd>
				<input name="productkey.wid" class="required" type="text" size="30" value="${productkey.wid}" />
				</dd>
			</dl>
		    <dl >
				<dt>产品id：</dt>
				<dd>
				<input name="productkey.fid" class="required" type="text" size="30" value="${productkey.fid}" />
				</dd>
			</dl>			
			<dl >
				<dt>数量：</dt>
				<dd>
				<input name="productkey.num" class="required" type="text" size="30" value="${productkey.num}" />
				</dd>
			</dl>

			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="60" rows="2" name="productkey.ms">${productkey.ms}</textarea>
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