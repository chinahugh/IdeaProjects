<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="components/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>订单组件信息</legend>
			<dl >
				<dt>订单：</dt>
				<dd>
				<input name="components.dd" readonly="readonly" type="text" size="30" value="${components.dd}" />
				</dd>
			</dl>
			<dl >
				<dt>物料：</dt>
				<dd>
				<input name="components.wl" readonly="readonly" type="text" size="30" value="${components.wl}" />
				</dd>
			</dl>
			<dl >
				<dt>项目组件：</dt>
				<dd>
				<input name="components.xmzj" readonly="readonly" type="text" size="30" value="${components.xmzj}" />
				</dd>
			</dl>
			<dl >
				<dt>需求日期：</dt>
				<dd>
				<input name="components.xqrq" readonly="readonly" type="text" size="30" value="${components.xqrq}" />
				</dd>
			</dl>
			<dl >
				<dt>需求数量：</dt>
				<dd>
				<input name="components.xqsl" readonly="readonly" type="text" size="30" value="${components.xqsl}" />
				</dd>
			</dl>
			<dl >
				<dt>撤回数量：</dt>
				<dd>
				<input name="components.chsl" readonly="readonly" type="text" size="30" value="${components.chsl}" />
				</dd>
			</dl>
			<dl >
				<dt>溯源需求：</dt>
				<dd>
				<input name="components.syxq" readonly="readonly" type="text" size="30" value="${components.syxq}" />
				</dd>
			</dl>
			<dl >
				<dt>物料描述：</dt>
				<dd>
				<input name="components.wlms" readonly="readonly" type="text" size="70" value="${components.wlms}" />
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