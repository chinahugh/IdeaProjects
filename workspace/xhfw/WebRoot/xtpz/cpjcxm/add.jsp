<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="cpjcxm/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>检测工序节点项目配置</legend>
			<dl>
				<dt>项目名称：</dt>
				<dd>
				<input name='${cpjcxm.id==null?"add":"cpjcxm.id"}' type="hidden"  value="${cpjcxm.id}" />
				<input name="cpjcxm.fid" type="hidden"   value="${cpjcjd==null?cpjcxm.fid:cpjcjd.id}" />
				
				<input  name="cpjcxm.mc" type="text"  suggestFields="mc" 
					suggestUrl="scode/lookupSuggesm/${cpjcjd==null?cpjcxm.flx:cpjcjd.lx}" lookupGroup="cpjcxm"  value="${cpjcxm.mc}"/>
				</dd>
			</dl>
			<dl>
				<dt>项目类型：</dt>
				<dd>
					<select name="cpjcxm.lx">					
						<option value="1" ${cpjcxm.lx==1?"selected":""}>整型数字</option>	
						<option value="2" ${cpjcxm.lx==2?"selected":""}>浮点小数</option>
						<option value="3" ${cpjcxm.lx==3?"selected":""}>布尔是否</option>
						<option value="4" ${cpjcxm.lx==4?"selected":""}>字符串</option>				
				    </select>				
				</dd>
			</dl>
			<dl>
				<dt>项目序号：</dt>
				<dd>
				<input name="cpjcxm.xh" class="required" type="text" size="30" value="${cpjcxm.xh}" />
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>项目描述：</dt>
				<dd>
				<textarea cols="70" rows="2" name="cpjcxm.ms" >${cpjcxm.ms}</textarea>
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