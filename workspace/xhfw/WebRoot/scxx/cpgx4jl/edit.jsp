<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="cpgx4jl/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>产品绑定信息</legend>
		    <dl >
				<dt>物料：</dt>
				<dd>
				<input name="cpjcjl.id" class="required" type="hidden" size="30" readonly="readonly" value="${cpjcjl.id}" />
				<input name="cpjcjl.wlh" class="required" type="text" size="30" readonly="readonly" value="${cpjcjl.wlh}" />
				
				</dd>
			</dl>	
			 <dl >
				<dt>条码：</dt>
				<dd>
				<input name="cpjcjl.txm" class="required" type="text" size="30" readonly="readonly" value="${cpjcjl.txm}" />
				</dd>
			</dl>
			<dl >
				<dt>${cpjcjl.mc}：</dt>
				<dd>
				<input name="cpjcjl.ms" class="required" type="text" size="30"  value="${cpjcjl.ms}" />
				</dd>
			</dl>
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