<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="barcode2/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>二维码菜单基本信息</legend>
			<dl >
				<dt>编   号：</dt>
				<dd>
				<input name='${barcode2.id==null?"add":"barcode2.id"}' type="text" size="30"  value="${barcode2.id}" readonly="readonly"/>
				</dd>
			</dl>
			<dl >
				<dt>二维码号码：</dt>
				<dd>
				<input name="barcode2.dm1" class="required" type="text" size="30" value="${barcode2.dm1}" />
				</dd>
			</dl>

			<dl >
				<dt>产品序列号：</dt>
				<dd>
				<input name="barcode2.bh" class="required" type="text" size="30" value="${barcode2.bh}" />
				</dd>
			</dl>
			<dl >
				<dt>是否验证：</dt>
				<dd>
				<input name="barcode2.isyz"  type="text" size="30" value="${barcode2.isyz}" />
				</dd>
			</dl>
			<dl >
				<dt>反馈状态：</dt>
				<dd>
				<input name="barcode2.state"  type="text" size="30" value="${barcode2.state}" />
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