<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="jcxxbom/save1" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);" rel="productBox">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>产品基本信息</legend>
			<dl>
				<dt>物料号：</dt>
				<dd>
				<input name="product.wlh" type="text" size="30" class="required" value="${product.wlh}" readonly="readonly" />
				</dd>
			</dl>
			<dl>
				<dt>产品描述：</dt>
				<dd>
				<input name="product.wlm" type="text" size="70" class="required" value="${product.wlm}" readonly="readonly" />
				</dd>
			</dl>
			<dl>
				<dt>版本号：</dt>
				<dd>
				<input name="proBbh.bbh" type="text" size="30"  value="${proBbh.bbh}" />
				</dd>
			</dl>
				<input name='${product.id==null?"":"product.id"}' type="hidden"  value="${product.id}" />
				<input name='${proBbh.id==null?"":"proBbh.id"}' type="hidden"  value="${proBbh.id}" />
				<!-- 被复制子产品probbh的id -->
				<input name='${id==null?"":"id"}' type="hidden"  value="${id}" />
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


<script type="text/javascript">
	var msg='${msg}';
	 if(msg!=''){
		alertMsg.info(msg);
		setTimeout(function(){navTab.closeCurrentTab();}, 100);
	}
	/* <c:if test="${msg!=null}">
		alertMsg.info('${msg}');
		setTimeout(function(){navTab.closeCurrentTab();}, 100);
	</c:if> */
</script>
