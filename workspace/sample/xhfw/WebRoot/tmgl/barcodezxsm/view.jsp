<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="barcodezxsm/view" class="pageForm required-validate" 
	onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
		<fieldset>
			<legend>装箱扫描基本信息</legend>
			<dl>
				<dt>物料号：</dt>
				<dd>
				<input name="barcode.wlh" type="text" size="30"  value="${barcode.wlh}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>条码1：</dt>
				<dd>
				<input name="barcode.tm1" type="text" size="30" value="${barcode.tm1}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>条码2：</dt>
				<dd>
				<input name="barcode.tm2" type="text" size="30" value="${barcode.tm2}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>条码3：</dt>
				<dd>
				<input name="barcode.tm3" type="text" size="30" value="${barcode.tm3}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>条码4：</dt>
				<dd>
				<input name="barcode.tm4" type="text" size="30" value="${barcode.tm4}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>条码5：</dt>
				<dd>
				<input name="barcode.tm5" type="text" size="30" value="${barcode.tm5}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>操作人：</dt>
				<dd>
				<input name="barcode.czr" type="text" size="30" value="${barcode.czr}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>操作时间：</dt>
				<dd>
				<input name="barcode.date" type="text" size="30" value="${barcode.date}" readonly="readonly"/>
				</dd>
			</dl>
			</fieldset>

		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>