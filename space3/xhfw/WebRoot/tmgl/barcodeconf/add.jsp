<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="barcodeconf/save" class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<legend>条码设置</legend>
				<fieldset>
					<legend>基础信息</legend>
					<dl>
						<dt>名称：</dt>
						<dd>
							<input name="barcodeConf.mc" class="required" type="text" size="30" value="${barcodeConf.mc}" />
						</dd>
					</dl>
					<dl>
						<dt>长度：</dt>
						<dd>
							<input name="barcodeConf.cd" class="required" type="text" size="30" value="${barcodeConf.cd}" />
						</dd>
					</dl>
					<input type="hidden" name='${barcodeConf.id==null?"add":"barcodeConf.id"}' type="text" size="30"
						value="${barcodeConf.id}" readonly="readonly" />
					<%-- <dl type="hidden">
						<dt>日期：</dt>
						<dd>
							<input name="barcodeConf.xzrq" class="required date" type="text"
								size="30" value="${xzrq}" type="hidden"/>
						</dd>
					</dl> --%>
					<%-- <dl>
						<dt>工号：</dt>
						<dd>
							<input name="barcodeConf.gh" class="required " type="text" size="30" value="${barcodeConf.gh}" />
						</dd>
					</dl> --%>
				</fieldset>
				<fieldset>
					<legend>条码配置</legend>
					<legend>标题</legend>
					<dl>
						<dt>从</dt>
						<dd>
							<input name='barcodeConf.t1s' type="text" size="30" value="1" />
						</dd>
					</dl>
					<dl>
						<dt>位到第</dt>
						<dd>
							<input name='barcodeConf.t1c' type="text" size="30" value="${barcodeConf.t1c}" />
						</dd>
					</dl>
					<dl>
						<dt>位，字段为：</dt>
						<dd>
							<input name="barcodeConf.t1" type="text" suggestFields="t1" suggestUrl="scode/lookupSuggest/23-1"
								lookupGroup="barcodeConf" value="${barcodeConf.t1}" />
						</dd>
					</dl>
				</fieldset>
				<fieldset>
					<legend>条码明文</legend>
					<dl>
						<dt>第一字段： 从</dt>
						<dd>
							<input name='barcodeConf.d1s' class="required" type="text" size="30" value="1" />
						</dd>
					</dl>
					<dl>
						<dt>位到第</dt>
						<dd>
							<input name='barcodeConf.d1c' class="required" type="text" size="30" value="${barcodeConf.d1c}" />
						</dd>
					</dl>
					<dl>
						<dt>位，字段为：</dt>
						<dd>
							<input name="barcodeConf.d1" type="text" suggestFields="d1" suggestUrl="scode/lookupSuggesd/23-1"
								lookupGroup="barcodeConf" value="${barcodeConf.d1}" />
						</dd>
					</dl>
					<br> <br> <br>
					<dl>
						<dt>第二字段： 从</dt>
						<dd>
							<input name='barcodeConf.d2s' type="text" size="30" value="${barcodeConf.d2s}" />
						</dd>
					</dl>
					<dl>
						<dt>位到第</dt>
						<dd>
							<input name='barcodeConf.d2c' type="text" size="30" value="${barcodeConf.d2c}" />
						</dd>
					</dl>
					<dl>
						<dt>位，字段为</dt>
						<dd>
							<input name="barcodeConf.d2" type="text" suggestFields="d2" suggestUrl="scode/lookupSuggesd/23-2"
								lookupGroup="barcodeConf" value="${barcodeConf.d2}" />
						</dd>
					</dl>
					<br> <br> <br>
					<dl>
						<dt>第三字段： 从</dt>
						<dd>
							<input name='barcodeConf.d3s' type="text" size="30" value="${barcodeConf.d3s}" />
						</dd>
					</dl>
					<dl>
						<dt>位到第</dt>
						<dd>
							<input name='barcodeConf.d3c' type="text" size="30" value="${barcodeConf.d3c}" />
						</dd>
					</dl>
					<dl>
						<dt>位，字段为</dt>
						<dd>
							<input name="barcodeConf.d3" type="text" suggestFields="d3" suggestUrl="scode/lookupSuggesd/23-3"
								lookupGroup="barcodeConf" value="${barcodeConf.d3}" />
						</dd>
					</dl>
					<br> <br> <br>
					<dl>
						<dt>第四字段： 从</dt>
						<dd>
							<input name='barcodeConf.d4s' type="text" size="30" value="${barcodeConf.d4s}" />
						</dd>
					</dl>
					<dl>
						<dt>位到第</dt>
						<dd>
							<input name='barcodeConf.d4c' type="text" size="30" value="${barcodeConf.d4c}" />
						</dd>
					</dl>
					<dl>
						<dt>位，字段为</dt>
						<dd>
							<input name="barcodeConf.d4" type="text" suggestFields="d4" suggestUrl="scode/lookupSuggesd/23-4"
								lookupGroup="barcodeConf" value="${barcodeConf.d4}" />
						</dd>
					</dl>
					<br> <br> <br>
					<dl>
						<dt>第五字段： 从</dt>
						<dd>
							<input name='barcodeConf.d5s' type="text" size="30" value="${barcodeConf.d5s}" />
						</dd>
					</dl>
					<dl>
						<dt>位到第</dt>
						<dd>
							<input name='barcodeConf.d5c' type="text" size="30" value="${barcodeConf.d5c}" />
						</dd>
					</dl>
					<dl>
						<dt>位，字段为</dt>
						<dd>
							<input name="barcodeConf.d5" type="text" suggestFields="d5" suggestUrl="scode/lookupSuggesd/23-5"
								lookupGroup="barcodeConf" value="${barcodeConf.d5}" />
						</dd>
					</dl>
					<br> <br> <br>
					<dl>
						<dt>第六字段： 从</dt>
						<dd>
							<input name='barcodeConf.d6s' type="text" size="30" value="${barcodeConf.d6s}" />
						</dd>
					</dl>
					<dl>
						<dt>位到第</dt>
						<dd>
							<input name='barcodeConf.d6c' type="text" size="30" value="${barcodeConf.d6c}" />
						</dd>
					</dl>
					<dl>
						<dt>位，字段为</dt>
						<dd>
							<input name="barcodeConf.d6" type="text" suggestFields="d6" suggestUrl="scode/lookupSuggesd/23-6"
								lookupGroup="barcodeConf" value="${barcodeConf.d6}" />
						</dd>
					</dl>
					<br> <br> <br>
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