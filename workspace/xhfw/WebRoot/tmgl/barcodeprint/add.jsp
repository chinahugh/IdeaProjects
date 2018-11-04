<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="barcodeprint/save" class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<fieldset>
					<legend>条码打印基本信息</legend>
					<dl>
						<dt>物料号：</dt>
						<dd>
							<input name="barcodeprint.wlh" type="text" size="30" value="${barcodeprint.wlh}" readonly="readonly" />
						</dd>
					</dl>
					<dl>
						<dt>规格型号：</dt>
						<dd>
							<input name="barcodeprint.ggxh" type="text" size="30" value="${barcodeprint.ggxh}" readonly="readonly" />
						</dd>
					</dl>
					<dl>
						<dt>物料图号：</dt>
						<dd>
							<input name="barcodeprint.wlth" type="text" size="30" value="${barcodeprint.wlth}" readonly="readonly" />
						</dd>
						<a class="btnLook" href="listWLLoop?a=wlh&b=wlms&c=wlth&d=ggxh" lookupGroup="barcodeprint">查找带回</a>
					</dl>
					<dl>
						<dt>订单号：</dt>
						<dd>
							<input name="barcodeprint.dd" type="text" size="30" value="${barcodeprint.dd}" />
						</dd>
					</dl>
					
				</fieldset>
				<fieldset>
					<%-- <dl>
						<dt>员工号：</dt>
						<dd>
							<input name="barcodeprint.czr" type="text" size="30" value="${barcodeprint.czr}" />
						</dd>
					</dl> --%>
					<%-- <dl>
						<dt>添加时间：</dt>
						<dd>
							<input name="barcodeprint.date" class="required date" type="text" size="30" value="${barcodeprint.date}" />
						</dd>
					</dl> --%>
					<dl class='nowrap'>
						<dt>备注：</dt>
						<dd>
							<textarea cols="150" rows="6" name="barcodeprint.bz" value="${barcodeprint.bz}"></textarea>
						</dd>
					</dl>
				</fieldset>
			</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>