<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="jcxxcomponents/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>订单组件信息</legend>
			<dl >
				<dt>订单：</dt>
				<dd>
				<input name="jcxxComponents.dd" readonly="readonly" type="text" size="30" value="${jcxxComponents.dd}" />
				</dd>
			</dl>
			<dl >
				<dt>物料：</dt>
				<dd>
				<input name="jcxxComponents.wl" readonly="readonly" type="text" size="30" value="${jcxxComponents.wl}" />
				</dd>
			</dl>
			<dl >
				<dt>项目组件：</dt>
				<dd>
				<input name="jcxxComponents.xmzj" readonly="readonly" type="text" size="30" value="${jcxxComponents.xmzj}" />
				</dd>
			</dl>
			<dl >
				<dt>需求日期：</dt>
				<dd>
				<input name="jcxxComponents.xqrq" readonly="readonly" type="text" size="30" value="${jcxxComponents.xqrq}" />
				</dd>
			</dl>
			<dl >
				<dt>需求数量：</dt>
				<dd>
				<input name="jcxxComponents.xqsl" class="required" type="text" size="30" value="${jcxxComponents.xqsl}" />
				</dd>
			</dl>
			<dl >
				<dt>撤回数量：</dt>
				<dd>
				<input name="jcxxComponents.chsl" class="required" type="text" size="30" value="${jcxxComponents.chsl}" />
				</dd>
			</dl>
			<dl >
				<dt>溯源需求：</dt>
				<dd>
				<input name="jcxxComponents.syxq" readonly="readonly" type="text" size="30" value="${jcxxComponents.syxq}" />
				</dd>
			</dl>
			<dl >
				<dt>物料描述：</dt>
				<dd>
				<input name="jcxxComponents.wlms" readonly="readonly" type="text" size="70" value="${jcxxComponents.wlms}" />
				</dd>
			</dl>
				<input name='${jcxxComponents.id==null?" ":"jcxxComponents.id"}' type="hidden" size="30"  value="${jcxxComponents.id}" />
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