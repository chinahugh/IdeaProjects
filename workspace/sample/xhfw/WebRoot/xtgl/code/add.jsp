<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="scode/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>参数配置</legend>
			<dl>
				<dt>序号：</dt>
				<dd>
				<input name="scode.xh" class="required digits" onclick="func1()" type="text" size="30" value="${scode.xh}" />
				</dd>
			</dl>
			<dl>
				<dt>名称：</dt>
				<dd>
				<input name='${scode.id==null?"add":"scode.id"}' type="hidden"  value="${scode.id}" />
				<input name="scode.fid" type="hidden"   value="${scodeFid}" />
				<input name="scode.mc" class="required" type="text" size="30" value="${scode.mc}" alt="请输入部门名称"/>
				</dd>
			</dl>
			<dl>
				<dt>代码：</dt>
				<dd>
				<input name="scode.dm"   type="text" size="30" value="${scode.dm}" />
				</dd>
			</dl>
			<dl>
				<dt>项目类型：</dt>
				<dd>
					<select name="scode.lx">
					    <option value="0" ${scode.lx==0?"selected":""}>字符串</option>									
						<option value="1" ${scode.lx==1?"selected":""}>浮点小数</option>	
						<option value="2" ${scode.lx==2?"selected":""}>布尔是否</option>
						
				    </select>				
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