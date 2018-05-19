<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="barcodedreceive/save" class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<legend>领取人基本信息</legend>
				<dl>
					<dt>员工号：</dt>
					<dd>
						<input name="barcodeReceive.ygh" type="text" size="30" value="${barcodeReceive.ygh}" />
					</dd>
				</dl>
				<dl>
					<dt>员工姓名：</dt>
					<dd>
						<input name="barcodeReceive.xm" type="text" size="30" value="${barcodeReceive.xm}" />
					</dd>
				</dl>
			<%-- 	<dl >
					<dt >领取时间：</dt>
					<dd>
						<input name="barcodeReceive.date" class="required date" type="text" size="30" value="${barcodeReceive.date}" />
					</dd>
				</dl> --%>
				<input type="hidden" name="barcodeReceive.date" class=" date" type="text" size="30" value="${barcodeReceive.date}" />
				<dl class="nowrap">
					<dt>备注：</dt>
					<dd>
						<textarea name="barcodeReceive.bz" cols="100" rows="3" value="${barcodeReceive.bz}"></textarea>
					</dd>
				</dl>
				<input name='${barcodeReceive.id==null?"add":"barcodeReceive.id"}' type="hidden" value="${barcodeReceive.id}" /> <input
					name="barcodeReceive.fid" type="hidden" size="30" value="${fid}" />
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