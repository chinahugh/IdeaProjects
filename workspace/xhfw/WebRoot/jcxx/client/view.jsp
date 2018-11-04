<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="client/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>检修所基本信息</legend>
			<dl >
				<dt>编号：</dt>
				<dd>
				<input name="client.bh" readonly="readonly" type="text" size="30" value="${client.bh}" />
				</dd>
			</dl>
			<dl >
				<dt>名称：</dt>
				<dd>
				<input name="client.mc" readonly="readonly" type="text" size="30" value="${client.mc}" />
				</dd>
			</dl>
			<dl >
				<dt>联系人1：</dt>
				<dd>
				<input name="client.lxr1" readonly="readonly" type="text" size="30" value="${client.lxr1}" />
				</dd>
			</dl>
			<dl >
				<dt>联系人2：</dt>
				<dd>
				<input name="client.lxr2" readonly="readonly" type="text" size="30" value="${client.lxr2}" />
				</dd>
			</dl>
			<dl >
				<dt>电话1：</dt>
				<dd>
				<input name="client.dh1" readonly="readonly" type="text" size="30" value="${client.dh1}" />
				</dd>
			</dl>
			<dl >
				<dt>电话2：</dt>
				<dd>
				<input name="client.dh2" readonly="readonly" type="text" size="30" value="${client.dh2}" />
				</dd>
			</dl>
			<dl >
				<dt>地址：</dt>
				<dd>
				<input name="client.dz" readonly="readonly" type="text" size="30" value="${client.dz}" />
				</dd>
			</dl>
			<dl >
				<dt>城市：</dt>
				<dd>
				<input name="client.cs" readonly="readonly" type="text" size="30" value="${client.cs}" />
				</dd>
			</dl>
			<dl >
				<dt>电子邮箱：</dt>
				<dd>
				<input name="client.dzyx" readonly="readonly" type="text" size="30" value="${client.dzyx}" />
				</dd>
			</dl>
			<dl >
				<dt>备注：</dt>
				<dd>
				<input name="client.bz" readonly="readonly" type="text" size="30" value="${client.bz}" />
				</dd>
			</dl>
				<input name='${client.id==null?"add":"client.id"}' type="hidden" size="30"  value="${client.id}" />
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