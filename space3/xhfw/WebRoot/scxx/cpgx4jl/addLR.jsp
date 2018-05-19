<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function changeFocus(){
	var s=document.getElementsByName("sz");
	for(var i=0; i<s.length;i++){
		if(s[i].value==""){
			alert("请扫描所有的二维码！");
			s[i].focus();
			return true;
		}			
	}
	return false;
}

</script>
<div class="pageContent">
	<form method="post" action="cpgx4jl/save" class="pageForm required-validate" onsubmit="if(changeFocus()){return false;}else{ return validateCallback(this, navTabAjaxDone);}">
		<div class="pageFormContent" layoutH="56">
		<fieldset>
			<legend>产品基本信息</legend>

		    <dl >
				<dt>物料号：</dt>
				<dd>
				<input name="cpjcjl.wlh" class="required" type="text" size="30" readonly="readonly" value="${cpjcjl.wlh}" />
				
				</dd>
			</dl>	
			 <dl >
				<dt>物料名：</dt>
				<dd>
				<input name="product.wlm" class="required" type="text" size="30" readonly="readonly" value="${cpjcjl.wlm}" />
				</dd>
			</dl>
					    <dl >
				<dt>图号：</dt>
				<dd>
				<input name="product.with" class="required" type="text" size="30" readonly="readonly" value="${cpjcjl.with}" />
				</dd>
			</dl>


			
			</fieldset>
			<fieldset>
			<legend>产品绑定信息</legend>

			<dl >
				<dt>条形码：</dt>
				<dd>
				<input name="cpjcjl.txm" class="required" type="text" size="25" value="${cpjcjl.txm}" />
				<input name="cpjcjl.fid"  type="hidden" size="25" value="${cpjcjl.fid}" />
				<input name="cpjcjl.xh"  type="hidden" size="25" value="${cpjcjl.xh==null?1:cpjcjl.xh}" />
				<input id="xh" name="cpjc.xh"  type="hidden" size="25" value="${cpjcjl.xh==null?1:cpjcjl.xh}" />
				<input  name="cpjc.txm"  type="hidden" size="25" value="${cpjcjl.txm}" />
				<input  name="cpjc.fid"  type="hidden" size="25" value="${cpjcjl.fid}" />
				<input  name="cpjc.id"  type="hidden" size="25" value="${cpjcjl.id}" />
				</dd>
			</dl>
			<c:forEach items="${xmL}" var="o">	
			    <dl >
				<dt>${o.wlh }：</dt>
				<dd>
				<input name="mc"  type="hidden" size="25" value="${o.wlh }" />
				<input name="sz" class="required" type="text" size="25" value="" onkeydown="if(event.keyCode==13) event.keyCode=9;" />
				</dd>
			</dl>										
									
			</c:forEach>	

			
			</fieldset>

		</div>
		<div class="formBar">
			<ul>
			   <li><div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="$('#xh').val(parseInt($('#xh').val())+1)">下一步</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">暂存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>

