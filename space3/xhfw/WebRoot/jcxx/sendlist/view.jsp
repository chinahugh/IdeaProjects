<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="sendlist/view" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
		<fieldset>
			<legend>发货清单信息</legend>
			<dl>
				<dt>交货单号：</dt>
				<dd>
				<input name="sendlist.jhdh" type="text" size="30" value="${sendlist.jhdh}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>送达方名称：</dt>
				<dd>
				<input name="sendlist.sdfmc" type="text" size="30" value="${sendlist.sdfmc}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料：</dt>
				<dd>
				<input name="sendlist.wlh" type="text" size="30" value="${sendlist.wlh}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料描述：</dt>
				<dd>
				<input name="sendlist.wlms" type="text" size="70" value="${sendlist.wlms}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>交货单数量：</dt>
				<dd>
				<input name="sendlist.jhdsl" type="text" size="30" value="${sendlist.jhdsl}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>条码：</dt>
				<dd>
				<input name="sendlist.tm" type="text" size="30" value="${sendlist.tm}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>设备号：</dt>
				<dd>
				<input name="sendlist.sbh" type="text" size="30" value="${sendlist.sbh}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>设备描述：</dt>
				<dd>
				<input name="sendlist.sbms" type="text" size="70" value="${sendlist.sbms}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>条码日期：</dt>
				<dd>
				<input name="sendlist.tmrq" type="text" size="30" value="${sendlist.tmrq}" readonly="readonly"/>
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