<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="post" action="wd/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>项目文档基本信息</legend>

			<dl >
				<dt>名称：</dt>
				<dd>
				<input name='${profiles.id==null?"add":"profiles.id"}' type="hidden"  value="${profiles.id}" />
					<input type="hidden" name="profiles.infobh" value="${param.bh}">	
	               <input type="hidden" name="profiles.fileml" value="${param.ml}">	
				<input name="profiles.mc" class="required" type="text"  value="${profiles.mc}" alt="请输入文件名称"/>
				</dd>
			</dl>
			<dl>
				<dt>文件：(<a  href="${profiles.attachmentpath }"  target="_blank" title="实要下载这些附件吗?">下载</a> <a  href="javascript:;" onclick ="delfj()" >删除</a>)</dt>
				<dd><input type="hidden" id="attachmentSize" name="profiles.attachmentSize"  value="${profiles.attachmentSize}" />
				<input type="hidden" id="attachmentPath" name="profiles.attachmentPath"  value="${profiles.attachmentPath}"  />
				<input type="text" id="fileName" name="profiles.fileName" class="text" value="${profiles.fileName}"  />
				<a class="btnAttach" href="/element/upfileLookup.jsp" lookupGroup="profiles" width="560" height="300" title="附件">附件</a>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="40" rows="2" name="profiles.ms">${profiles.ms}</textarea>
				</dd>
			</dl>
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