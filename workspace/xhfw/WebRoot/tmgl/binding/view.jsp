<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="jcxxindent/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>生产订单信息</legend>
			<dl >
				<dt>订单：</dt>
				<dd>
				<input name="jcxxindent.dd" readonly="readonly" type="text" size="30" value="${jcxxindent.dd}" />
				</dd>
			</dl>
			<dl >
				<dt>物料：</dt>
				<dd>
				<input name="jcxxindent.wl" readonly="readonly" type="text" size="30" value="${jcxxindent.wl}" />
				</dd>
			</dl>
			<dl >
				<dt>订单类型：</dt>
				<dd>
				<input name="jcxxindent.ddlx" readonly="readonly" type="text" size="30" value="${jcxxindent.ddlx}" />
				</dd>
			</dl>
			<dl >
				<dt>订单数量：</dt>
				<dd>
				<input name="jcxxindent.ddsl" readonly="readonly" type="text" size="30" value="${jcxxindent.ddsl}" />
				</dd>
			</dl>
			<dl >
				<dt>基本开始日期：</dt>
				<dd>
				<input name="jcxxindent.jbksrq" readonly="readonly" type="text" size="30" value="${jcxxindent.jbksrq}" />
				</dd>
			</dl>
			<dl >
				<dt>基本完成日期：</dt>
				<dd>
				<input name="jcxxindent.jbwcrq" readonly="readonly" type="text" size="30" value="${jcxxindent.jbwcrq}" />
				</dd>
			</dl>
			<dl >
				<dt>系统状态：</dt>
				<dd>
				<input name="jcxxindent.xtzt" readonly="readonly" type="text" size="30" value="${jcxxindent.xtzt}" />
				</dd>
			</dl>
			<dl >
				<dt>物料描述：</dt>
				<dd>
				<input name="jcxxindent.wlms" readonly="readonly" type="text" size="70" value="${jcxxindent.wlms}" />
				</dd>
			</dl>
			<dl >
				<dt>订单完成状态：</dt>
				<dd>
				<input name="jcxxindent.status" readonly="readonly" type="text" size="30" value="${jcxxindent.status}" />
				</dd>
			</dl>
				<input name='${jcxxindent.id==null?" ":"jcxxindent.id"}' type="hidden" size="30"  value="${jcxxindent.id}" />
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