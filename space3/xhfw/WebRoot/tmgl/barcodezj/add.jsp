<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="components/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>订单抬头信息</legend>
			<dl >
				<dt>订单：</dt>
				<dd>
				<input name="components.dd" class="required" type="text" size="30" value="${components.dd}" />
				</dd>
			</dl>
			<dl >
				<dt>物料：</dt>
				<dd>
				<input name="components.wl" class="required" type="text" size="30" value="${components.wl}" />
				</dd>
			</dl>
			<dl >
				<dt>项目组件：</dt>
				<dd>
				<input name="components.xmzj" class="required" type="text" size="30" value="${components.xmzj}" />
				</dd>
			</dl>
			<dl >
				<dt>需求日期：</dt>
				<dd>
				<input name="indent.xqrq" class="required" type="text" size="30" value="${indent.xqrq}" />
				</dd>
			</dl>
			<dl >
				<dt>需求数量：</dt>
				<dd>
				<input name="components.xqsl" class="required" type="text" size="30" value="${components.xqsl}" />
				</dd>
			</dl>
			<dl >
				<dt>撤回数量：</dt>
				<dd>
				<input name="components.chsl" class="required" type="text" size="30" value="${components.chsl}" />
				</dd>
			</dl>
			<dl >
				<dt>溯源需求：</dt>
				<dd>
				<input name="indent.syxq" class="required" type="text" size="30" value="${indent.syxq}" />
				</dd>
			</dl>
			<dl >
				<dt>物料描述：</dt>
				<dd>
				<input name="components.wlms" class="required" type="text" size="70" value="${components.wlms}" />
				</dd>
			</dl>
				<input name='${components.id==null?" ":"components.id"}' type="hidden" size="30"  value="${components.id}" />
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