<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="barcodeconf/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>			
			<fieldset>
			<legend>条码信息</legend>
			<dl >
				<dt>名称：</dt>
				<dd>
				<input name="barcodeConf.mc" readonly="readonly" type="text" size="30" value="${barcodeConf.mc}" />
				</dd> 
			</dl>
			<dl >
				<dt>创建日期：</dt>
				<dd>
				<input name="barcodeConf.xzrq" readonly="readonly" type="text" size="30" value="${barcodeConf.xzrq}" />
				</dd> 
			</dl>
			<dl >
				<dt>工号：</dt>
				<dd>
				<input name="barcodeConf.gh" readonly="readonly" type="text" size="30" value="${barcodeConf.gh}" />
				</dd> 
			</dl>
			<dl >
				<dt>标题：</dt>
				<dd>
				<input name="barcodeConf.t1" readonly="readonly" type="text" size="30" value="${barcodeConf.t1}" />
				</dd>
			</dl>
			<dl >
				<dt>第一字段：</dt>
				<dd>
				<input name="barcodeConf.d1" readonly="readonly" type="text" size="30" value="${barcodeConf.d1}" />
				</dd>
			</dl>
			<dl >
				<dt>第二字段：</dt>
				<dd>
				<input name="barcodeConf.d2" readonly="readonly" type="text" size="30" value="${barcodeConf.d2}" />
				</dd>
			</dl>
			<dl >
				<dt>第三字段：</dt>
				<dd>
				<input name="barcodeConf.d3" readonly="readonly" type="text" size="30" value="${barcodeConf.d3}" />
				</dd>
			</dl>
			<dl >
				<dt>第四字段：</dt>
				<dd>
				<input name="barcodeConf.d5" readonly="readonly" type="text" size="30" value="${barcodeConf.d5}" />
				</dd>
			</dl>
			<dl >
				<dt>第五字段：</dt>
				<dd>
				<input name="barcodeConf.d5" readonly="readonly" type="text" size="30" value="${barcodeConf.d5}" />
				</dd>
			</dl>
			<dl >
				<dt>第六字段：</dt>
				<dd>
				<input name="barcodeConf.d6" readonly="readonly" type="text" size="30" value="${barcodeConf.d6}" />
				</dd>
			</dl>
			<dl >
				<dt>第七字段：</dt>
				<dd>
				<input name="barcodeConf.d7" readonly="readonly" type="text" size="30" value="${barcodeConf.d7}" />
				</dd>
			</dl>
			<dl >
				<dt>第八字段：</dt>
				<dd>
				<input name="barcodeConf.d8" readonly="readonly" type="text" size="30" value="${barcodeConf.d8}" />
				</dd>
			</dl>
				<input name='${barcodeConf.id==null?" ":"barcodeConf.id"}' type="hidden" size="30"  value="${barcodeConf.id}" />
			</fieldset>
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