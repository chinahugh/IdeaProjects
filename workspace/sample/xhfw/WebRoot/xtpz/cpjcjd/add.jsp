<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="cpjcjd/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>产品工序节点配置</legend>
			<dl>
				<dt>节点名称：</dt>
				<dd>
				<input name='${cpjcjd.id==null?"add":"cpjcjd.id"}' type="hidden"  value="${cpjcjd.id}" />
				<input name="cpjcjd.fid" type="hidden"   value="${fid==null?cpjcjd.fid:fid}" />
				<input name="cpjcjd.mc" class="required" type="text" size="30" value="${cpjcjd.mc}" />
				</dd>
			</dl>
			<dl>
				<dt>操作角色：</dt>
				<dd>
				<input name="cpjcjd.jsids" type="hidden"   value="${cpjcjd.jsids}" />
				<input name="cpjcjd.jsmcs" class="required" type="text" size="25" value="${cpjcjd.jsmcs}" />
				<a class="btnLook" href="treeJSLoops?a=jsids&b=jsmcs" lookupGroup="cpjcjd">查找带回</a>	
				</dd>
			</dl>
			<dl>
				<dt>节点序号：</dt>
				<dd>
				<input name="cpjcjd.xh" class="required" type="text" size="30" value="${cpjcjd.xh}" />
				</dd>
			</dl>
			<dl>
				<dt>操作类型：</dt>
				<dd>
					<select class="combox" name="cpjcjd.lx">
						<option value="1" ${cpjcjd.lx==1?"selected":""}>扫描</option>
						<option value="2" ${cpjcjd.lx==2?"selected":""}>导入</option>
						<option value="3" ${cpjcjd.lx==3?"selected":""}>录入</option>
					</select>
				
				</dd>
			</dl>
			<dl>
				<dt>配置角色：</dt>
				<dd>
				<input name="cpjcjd.jsids1" type="hidden"   value="${cpjcjd.jsids1}" />
				<input name="cpjcjd.jsmcs1" class="required" type="text" size="25" value="${cpjcjd.jsmcs1}" />
				<a class="btnLook" href="treeJSLoops?a=jsids1&b=jsmcs1" lookupGroup="cpjcjd">查找带回</a>	
				</dd>
			</dl>		
			<dl class="nowrap">
				<dt>节点描述：</dt>
				<dd>
				<textarea cols="70" rows="2" name="cpjcjd.ms" >${cpjcjd.ms}</textarea>
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