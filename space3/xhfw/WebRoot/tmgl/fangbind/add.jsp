<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<script type="text/javascript">
	$(function () {
		if ($("#ftxm").val()=="") {
			$("#ftxm").focus();
		}else if ($("#btxm").val()=="") {
			$("#btxm").focus();
		}
	})
</script>
<div class="pageContent">
	<form method="post" action="fangbind/save" class="pageForm required-validate"  onsubmit='return ${cpjc.dd==null?"navTabSearch(this)":"validateCallback(this, navTabAjaxDone)"};'>
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>防伪码绑定</legend>
			<dl>
				<dt>防伪码：</dt>
				<dd>
				<input id="ftxm" name="fcpjc.ftxm" type="text" size="30"  value="${fcpjc.ftxm}" />
				</dd>
			</dl>
			<dl>
				<dt>产品条码：</dt>
				<dd>
				<input id="btxm" name="fcpjc.btxm" type="text" size="30"  value="${fcpjc.btxm}" />
				<input name="fcpjc.id" type="hidden" size="30"  value="${fcpjc.id}" />
				<input name="fcpjc.fid" type="hidden" size="30"  value="${fcpjc.fid}" />
				</dd>
			</dl>
			</fieldset>
			
			<fieldset>
			<legend>防伪码信息</legend>
			<dl>
				<dt>订单：</dt>
				<dd>
				<input name="fcpjc.dd" type="text" size="30"  value="${fcpjc.dd}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料：</dt>
				<dd>
				<input name="fcpjc.wlh" type="text" size="30"  value="${fcpjc.wlh}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料描述：</dt>
				<dd>
				<input name="fcpjc.wlm" type="text" size="70"  value="${fcpjc.wlm}" readonly="readonly"/>
				</dd>
			</dl>
			</fieldset>
			
			<fieldset>
			<legend>产品条码信息</legend>
			<dl>
				<dt>订单：</dt>
				<dd>
				<input name="cpjc.dd" type="text" size="30"  value="${cpjc.dd}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料：</dt>
				<dd>
				<input name="cpjc.wlh" type="text" size="30"  value="${cpjc.wlh}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>物料描述：</dt>
				<dd>
				<input name="cpjc.wlm" type="text" size="70"  value="${cpjc.wlm}" readonly="readonly"/>
				<input name="cpjc.fid" type="hidden" size="30"  value="${cpjc.fid}"/>
				</dd>
			</dl>
			</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>