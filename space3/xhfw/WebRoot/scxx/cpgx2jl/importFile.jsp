<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="contentTitle">导入EXCEL文件</h2>
<div class="pageContent">
	<form method="post" action="cpgx2jl/importExcel" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);"  >
		<div class="pageFormContent" layoutH="96">
			<dl>		
				<dt>测试工序：</dt>
				<dd>
				<input class="readonly" name="cpjcjl.fid" value="" readonly="readonly" type="hidden"/>
				<input class="readonly" name="cpjcjl.jdid" value="" readonly="readonly" type="hidden"/>
				<input class="readonly" name="cpjcjl.mc" value="" readonly="readonly" type="text"/>
				<a class="btnLook" href="cpgx2jl/treeCSGXLook?a=fid&b=wlh&c=mc&d=jdid" lookupGroup="cpjcjl">查找带回</a>	
				<span class="info"></span>
				</dd>
			</dl>
			<dl>		
				<dt>产品物料：</dt>
				<dd>
				
				<input class="readonly" name="cpjcjl.wlh" value="" readonly="readonly" type="text"/>
			
				</dd>
			</dl>
			<dl>		
				<dt>导入文件：</dt>
				<dd>
				<input class="readonly" name="attachment.fileName" value="" readonly="readonly" type="text"/>
				<input class="readonly" name="attachment.attachmentPath" value="" readonly="readonly" type="hidden"/>
				<a class="btnAttach" href="element/upfileLookup2.jsp" lookupGroup="attachment" width="560" height="300" title="附件">附件</a>
				<span class="info"></span>
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>