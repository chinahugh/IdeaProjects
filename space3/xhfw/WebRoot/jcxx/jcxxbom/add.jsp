<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="jcxxbom/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);" rel="jcxxbomBox1">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>jcxxBom基本信息</legend>
			<dl>
				<dt>物料号：</dt>
				<dd>
				<input name="jcxxBom.wlh" type="text" size="30" class="required" value="${jcxxBom.wlh}" readonly="readonly" />
				</dd>
			</dl>
			<dl>
				<dt>物料描述：</dt>
				<dd>
				<input name="jcxxBom.wlms" type="text" size="70" class="required" value="${jcxxBom.wlms}" readonly="readonly" />
				</dd>
			</dl>
			<dl>
				<dt>物料图号：</dt>
				<dd>
				<input name="jcxxBom.wlth" type="text" size="30" class="required" value="${jcxxBom.wlth}" readonly="readonly" />
				</dd>
			</dl>
			<dl>
				<dt>组件：</dt>
				<dd>
				<input name="jcxxBom.zj" type="text" size="30" class="required" value="${jcxxBom.zj}" readonly="readonly" />
				</dd>
				<a class="btnLook" href="listWLLoop?a=zj&b=zjms&c=zjth&d=ggxh" lookupGroup="jcxxBom">查找带回</a>	
			</dl>
			<dl>
				<dt>组件图号：</dt>
				<dd>
				<input name="jcxxBom.zjth" type="text" size="30"  value="${jcxxBom.zjth}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>组件描述：</dt>
				<dd>
				<input name="jcxxBom.zjms" type="text" size="70" class="required" value="${jcxxBom.zjms}" readonly="readonly"/>
				</dd>
			</dl>
			<dl>
				<dt>组件数量：</dt>
				<dd>
				<input name="jcxxBom.zjsl" type="text" size="30" class="required" value="${jcxxBom.zjsl}"  />
				</dd>
			</dl>
			<dl>
				<dt>版本号：</dt>
				<dd>
				<input name="jcxxBom.bbh" type="text" size="30"  value="${jcxxBom.bbh}" readonly="readonly"/>
				</dd>
			</dl>
				<input name='${jcxxBom.id==null?"":"jcxxBom.id"}' type="hidden"  value="${jcxxBom.id}" />
				<input name='${jcxxBom.fid==null?"":"jcxxBom.fid"}' type="hidden"  value="${jcxxBom.fid}" />
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
