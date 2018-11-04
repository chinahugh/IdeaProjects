<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<div class="pageContent">
	<form method="post" action="smstemp/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<fieldset style="height: 250px;">
			
			<legend>微信模版信息</legend>
			
			
			<input type="hidden" name="typ" value="wx"> 
			
			 <input name= '${smstemp.id==null?"add":"smstemp.id"}' type="hidden"   value="${smstemp.id}" size="30"/> 			
			<dl>
				<dt>标题：</dt>
				<dd>
				<input  type="text" name="smstemp.title" size="30"  value="${smstemp.title}"/>
				</dd>
			</dl>
		
			<dl class="nowrap">
				<dt>微信内容：</dt>
				<dd>
				  <textarea cols="60" rows="6" name="smstemp.smsContent">${smstemp.smsContent}</textarea>
				</dd>
			</dl>
			<input name="smstemp.create_time" type="hidden"   value="${smstemp.create_time}" size="30"/> 
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
<script>
	function qh(){
		if($('#tstype').val()=='wx'){
			$('#dianhua').css('display','none');
		}
		else {
			$('#dianhua').css('display','');
		}
		
	}
</script>