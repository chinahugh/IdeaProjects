<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="cpcsjl/addlx" class="pageForm required-validate" onsubmit="return navTabSearch(this);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>产品测试信息</legend>
			<dl >
				<dt>条码编号：</dt>
				<dd>
				<input id="lrlx" name='cpcsjl.lrlx' type="hidden"  value="0"/>
				<input name='cpcsjl.txm' size="25"  value="" />
				</dd>
			</dl>
			<dl >
				<dt>测试模版：</dt>
				<dd>
				<input name="cpcsjl.fid"  type="hidden" size="30" value="" />
				<input name="cpcsjl.fmc" class="required" type="text" size="25" value="" readonly="readonly"/>
				<a class="btnLook" href="listCPCSLoop?a=fid&b=fmc" lookupGroup="cpcsjl">查找带回</a>	
				</dd>
			</dl>

			</fieldset>

		</div>
		<div class="formBar">
			<ul>
			    <li><div class="buttonActive"><div class="buttonContent"><button type="submit">录入</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="$('#lrlx').val(1)">导入</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>