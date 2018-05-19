<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="cpgx1jl/addlx" class="pageForm required-validate" onsubmit="return navTabSearch(this);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>产品加工信息</legend>
			<dl >
				<dt>条码编号：</dt>
				<dd>

				<input name='cpjcjl.txm' size="25"  value="" />
				</dd>
			</dl>


			</fieldset>

		</div>
		<div class="formBar">
			<ul>
			    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">录入</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>