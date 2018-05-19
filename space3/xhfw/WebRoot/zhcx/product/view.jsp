<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="jcxxmaterial/view" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
		<fieldset>
			<legend>物料基本信息</legend>
			<dl>
				<dt>工厂：</dt>
				<dd>
				<input name="jcxxmaterial.gc" type="text" type="text" size="30" value="${jcxxmaterial.gc}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料号：</dt>
				<dd>
				<input name="jcxxmaterial.wlh" type="text" size="30"  value="${jcxxmaterial.wlh}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料图号：</dt>
				<dd>
				<input name="jcxxmaterial.wlth" type="text" size="30" value="${jcxxmaterial.wlth}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>规格型号：</dt>
				<dd>
				<input name="jcxxmaterial.ggxh" type="text" size="30" value="${jcxxmaterial.ggxh}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料描述：</dt>
				<dd>
				<input name="jcxxmaterial.wlms" type="text" size="70" value="${jcxxmaterial.wlms}" readonly="readonly"/>
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