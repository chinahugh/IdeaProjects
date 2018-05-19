<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="jcxxcomponents/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>订单组件信息</legend>
			<dl >
				<dt>订单：</dt>
				<dd>
				<input name="jcxxcomponents.dd" readonly="readonly" type="text" size="30" value="${jcxxcomponents.dd}" />
				</dd>
			</dl>
			<dl >
				<dt>物料：</dt>
				<dd>
				<input name="jcxxcomponents.wl" readonly="readonly" type="text" size="30" value="${jcxxcomponents.wl}" />
				</dd>
			</dl>
			<dl >
				<dt>项目组件：</dt>
				<dd>
				<input name="jcxxcomponents.xmzj" readonly="readonly" type="text" size="30" value="${jcxxcomponents.xmzj}" />
				</dd>
			</dl>
			<dl >
				<dt>需求日期：</dt>
				<dd>
				<input name="jcxxcomponents.xqrq" readonly="readonly" type="text" size="30" value="${jcxxcomponents.xqrq}" />
				</dd>
			</dl>
			<dl >
				<dt>需求数量：</dt>
				<dd>
				<input name="jcxxcomponents.xqsl" readonly="readonly" type="text" size="30" value="${jcxxcomponents.xqsl}" />
				</dd>
			</dl>
			<dl >
				<dt>撤回数量：</dt>
				<dd>
				<input name="jcxxcomponents.chsl" readonly="readonly" type="text" size="30" value="${jcxxcomponents.chsl}" />
				</dd>
			</dl>
			<dl >
				<dt>溯源需求：</dt>
				<dd>
				<input name="jcxxcomponents.syxq" readonly="readonly" type="text" size="30" value="${jcxxcomponents.syxq}" />
				</dd>
			</dl>
			<dl >
				<dt>物料描述：</dt>
				<dd>
				<input name="jcxxcomponents.wlms" readonly="readonly" type="text" size="70" value="${jcxxcomponents.wlms}" />
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