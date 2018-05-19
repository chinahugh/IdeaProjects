<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="scode/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>继电器1--产品工序配置</legend>
			<dl>
				<dt>工序名称：</dt>
				<dd>
				<input name='${scode.id==null?"add":"scode.id"}' type="hidden"  value="${scode.id}" />
				<input name="scode.fid" type="hidden"   value="${scodeFid}" />
				<input name="scode.mc" class="required" type="text" size="30" value="${scode.mc}" alt="请输入工序名称"/>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>工作台：</dt>
				<dd>
				<ul class="tree treeFolder treeCheck expand" >
			<li><a tname="name" tvalue="value1" checked="true">工作台1</a></li>
			<li><a tname="name" tvalue="value2">工作台2</a></li>
			<li><a tname="name" tvalue="value3">工作台3</a></li>
			<li><a tname="name" tvalue="value4">工作台4</a></li>
			<li><a tname="name" tvalue="value5">工作台5</a></li>
</ul>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>检测项目：</dt>
				<dd>
<ul class="tree treeFolder treeCheck expand" >

			<li><a tname="name" tvalue="value1" checked="true">检测项A</a></li>
			<li><a tname="name" tvalue="value2">检测项B</a></li>
			<li><a tname="name" tvalue="value3">检测项C</a></li>
			<li><a tname="name" tvalue="value4">检测项D</a></li>
			<li><a tname="name" tvalue="value5">检测项E</a></li>
	<li><a tname="name" tvalue="value5">检测项F</a></li>
</ul>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="70" rows="2" name="scode.ms" >${scode.ms}</textarea>
				</dd>
			</dl>
		</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
	</fieldset>
</div>