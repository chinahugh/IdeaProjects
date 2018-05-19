<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="sendlist/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>发货清单</legend>
			<dl>
				<dt>交货单号：</dt>
				<dd>
				<input name="sendList.jhdh" type="text" size="30" value="${sendList.jhdh}" />
				</dd>
			</dl>
			<dl>
				<dt>送达方名称：</dt>
				<dd>
				<input name="sendList.sdfmc" type="text" size="30" value="${sendList.sdfmc}" />
				</dd>
			</dl>
			<dl>
				<dt>物料：</dt>
				<dd>
				<input name="sendList.wl" type="text" size="30" value="${sendList.wl}" />
				</dd>
			</dl>
			<dl>
				<dt>物料描述：</dt>
				<dd>
				<input name="sendList.wlms" type="text" size="70" value="${sendList.wlms}" />
				</dd>
			</dl>
			<dl>
				<dt>交货单数量：</dt>
				<dd>
				<input name="sendList.jhdsl" type="text" size="30" value="${sendList.jhdsl}" />
				</dd>
			</dl>
			<dl>
				<dt>条码：</dt>
				<dd>
				<input name="sendList.tm" type="text" size="30" value="${sendList.tm}" />
				</dd>
			</dl>
			<dl>
				<dt>设备号：</dt>
				<dd>
				<input name="sendList.sbh" type="text" size="30" value="${sendList.sbh}" />
				</dd>
			</dl>
			<dl>
				<dt>设备描述：</dt>
				<dd>
				<input name="sendList.sbms" type="text" size="70" value="${sendList.sbms}" />
				</dd>
			</dl>
			<dl>
				<dt>条码日期：</dt>
				<dd>
				<input name="sendList.tmrq" type="text" size="30" value="${sendList.tmrq}" />
				</dd>
			</dl>
				<input name='${sendList.id==null?"":"sendList.id"}' type="hidden"  value="${sendList.id}" />
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