<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2 class="contentTitle">取消覆盖</h2>
<div class="pageContent">
	<form method="post" action="material/cancelRepeate" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);" >
		<div class="pageFormContent" layoutH="96">
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