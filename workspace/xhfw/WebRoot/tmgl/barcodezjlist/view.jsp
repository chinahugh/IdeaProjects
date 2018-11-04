<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="barcode/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>条码信息</legend>
			<dl >
				<dt>条码：</dt>
				<dd>
				<input name="cpjc.txm" readonly="readonly" type="text" size="30" value="${cpjc.txm}" />
				</dd>
			</dl>
			<dl >
				<dt>物料描述：</dt>
				<dd>
				<input name="cpjc.wlm" readonly="readonly" type="text" size="30" value="${cpjc.wlm}" />
				</dd>
			</dl>
			<dl >
				<dt>生成日期：</dt>
				<dd>
				<input name="cpjc.scrq" readonly="readonly" type="text" size="30" value="${cpjc.scrq}" />
				</dd>
			</dl>
			<dl >
				<dt>物料：</dt>
				<dd>
				<input name="cpjc.wlh" readonly="readonly" type="text" size="30" value="${cpjc.wlh}" />
				</dd>
			</dl>
			<dl >
				<dt>订单：</dt>
				<dd>
				<input name="cpjc.dd" readonly="readonly" type="text" size="30" value="${cpjc.dd}" />
				</dd>
			</dl>
			<dl >
				<dt>是否打印：</dt>
				<dd>
				<input name="cpjc.state" readonly="readonly" type="text" size="30" value="${cpjc.state==1?'已打印':'未打印'}" />
				</dd>
			</dl>
			<dl >
				<dt>条码：</dt>
				<dd>
				<img  src="tmgl/barcode/imag/${cpjc.txm}.png" />
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