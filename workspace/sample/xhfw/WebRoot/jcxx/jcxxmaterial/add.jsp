<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="jcxxmaterial/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>物料基本信息</legend>
			<dl>
				<dt>工厂：</dt>
				<dd>
				<input name="jcxxMaterial.gc" class="required" type="text" size="30" value="${jcxxMaterial.gc}" />
				</dd>
			</dl>
			<dl>
				<dt>物料号：</dt>
				<dd>
				<input name="jcxxMaterial.wlh" class="required" size="30"  value="${jcxxMaterial.wlh}" />
				</dd>
			</dl>
			<dl>
				<dt>物料图号：</dt>
				<dd>
				<input name="jcxxMaterial.wlth" class="required" type="text"  size="30" value="${jcxxMaterial.wlth}" />
				</dd>
			</dl>
			<dl>
				<dt>规格型号：</dt>
				<dd>
				<input name="jcxxMaterial.ggxh" class="required" type="text"  size="30" value="${jcxxMaterial.ggxh}" />
				</dd>
			</dl>
			<dl>
				<dt>物料描述：</dt>
				<dd>
				<input name="jcxxMaterial.wlms" class="required" type="text" size="70" value="${jcxxMaterial.wlms}" />
				</dd>
			</dl>
				<input name='${jcxxMaterial.id==null?"":"jcxxMaterial.id"}' type="hidden"  value="${jcxxMaterial.id}" />
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