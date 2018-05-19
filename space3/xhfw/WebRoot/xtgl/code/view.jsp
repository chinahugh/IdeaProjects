<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>参数配置</legend>
			<dl>
				<dt>名称：</dt>
				<dd>
				<input  value="${scode.mc}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>代码：</dt>
				<dd>
				<input name="scode.dm"   type="text" size="30" value="${scode.dm}"readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>序号：</dt>
				<dd>
				<input name="scode.xh" class="required digits" onclick="func1()" type="text" size="30" value="${scode.xh}"readonly="readonly"/>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="70" rows="2" readonly="readonly" >${scode.ms}</textarea>
				</dd>
			</dl>

		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</fieldset>
</div>