<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="jcxxbom/view" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
		<fieldset>
			<legend>bom基本信息</legend>
			<dl>
				<dt>物料号：</dt>
				<dd>
				<input name="jcxxbom.wlh" type="text" size="30" value="${jcxxbom.wlh}" readonly="readonly" />
				</dd>
			</dl>
			<dl>
				<dt>组件：</dt>
				<dd>
				<input name="jcxxbom.zj" type="text" size="30" value="${jcxxbom.zj}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>组件图号：</dt>
				<dd>
				<input name="jcxxbom.zjth" type="text" size="30" value="${jcxxbom.zjth}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>组件描述：</dt>
				<dd>
				<input name="jcxxbom.zjms" type="text" size="70" value="${jcxxbom.zjms}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>版本号：</dt>
				<dd>
				<input name="jcxxbom.bbh" type="text" size="30" value="${jcxxbom.bbh}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>组件数量：</dt>
				<dd>
				<input name="jcxxbom.zjsl" type="text" size="30" value="${jcxxbom.zjsl}" readonly="readonly"/>
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