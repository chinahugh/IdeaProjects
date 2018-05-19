<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
	function qh(){
		console.log('QH');
			//$('#dxmb').click();
	}
</script>
<div class="pageContent">
	
	<form method="post" action="sms/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<fieldset>
			<legend>短信基本信息</legend>
			<input name= '${sms.id==null?"add":"sms.id"}' type="hidden"   value="${sms.id}" size="30"/>
			
			<dl style="display:none;">
				<dt>推送类型：</dt>
				<dd>
				<select name="tstype" id="tstype" onchange="qh()">
					<option value="sms">短信</option>
				</select>
				</dd>
			</dl>
			<dl id="dianhua"  style="width:100%">
				<dt>电话：</dt>
				<dd>
				<input name="mobile" id="mobile" type="text"  value="" alt="请输入手机号码" size="30"/>
 				
 				  
      
				</dd>
			</dl>
				<dl id="smstemp">
				<dt></dt>
				<dd>
			 	<!-- <a class="smstemp " href="smstemp/list" 
        			target="dialog" rel="dlg_page7" 
        			 height="480" width="800" style="color:#00f;font-size: 18px;" lookupgroup="smstemp">短信模版</a>
        			 
        		<a class="" href="smstemp/list" 
        			target="dialog" rel="dlg_page7" 
        			 height="480" width="800" style="color:#00f;font-size: 18px;" lookupgroup="smstemp">群组选择</a>  -->
        			 
        			   		
		<ul style="float:right;margin-left:130px;">
			
			<li style="float:left"><a class="edits" href="smstemp?wxsz=sms" 
        			target="dialog" rel="dlg_page7" 
        			 height="480" width="800" lookupgroup="smstemp"><span>短信模板&nbsp;|&nbsp;<a class="adds" href="#"><span>群组</span></a></span></a></li>
			
			
			
		</ul>
				
        		
        		</dd>
			</dl>
		
			<dl class="nowrap">
				<dt>推送内容：</dt>
				<dd>
				  <textarea cols="60" rows="6" name="smstemp.content"></textarea>
				</dd>
			</dl>
			</fieldset>

		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">发送</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
