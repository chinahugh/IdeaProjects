<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="cpcssz/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>产品测试配置信息</legend>
			<dl >
				<dt>物料名称：</dt>
				<dd>
				<input name='${cpcssz.id==null?"add":"cpcssz.id"}' type="hidden"   value="${cpcssz.id}" readonly="readonly"/>
				<input name='cpcssz.wlh' type="hidden"  value="${cpcssz.wlh}" readonly="readonly"/>
				<input name="cpcssz.wlm" class="required" type="text" size="25"  value="${cpcssz.wlm}" readonly="readonly"/>
								<a class="btnLook" href="listWLLoop?a=wlh&b=wlm" lookupGroup="cpcssz">查找带回</a>	
				</dd>
			</dl>
			<dl >
				<dt>名称：</dt>
				<dd>
				<input name="cpcssz.mc" class="required" type="text" size="25" value="${cpcssz.mc}" />
				</dd>
			</dl>
			<dl >
				<dt>操作人：</dt>
				<dd>
				<input name="cpcssz.czrids" class="required" type="text" size="25" value="${cpcssz.czrids}" />
				<input name="cpcssz.czrmcs" class="required" type="text" size="25" value="${cpcssz.czrmcs}" />
				<a class="btnLook" href="treeYGLoop?a=czrids&b=czrmcs" lookupGroup="suser">查找带回</a>	
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>描述：</dt>
				<dd>
				<textarea cols="60" rows="2" name="cpcssz.ms">${cpcssz.ms}</textarea>
				</dd>
			</dl>
			</fieldset>
		<div class="divider"></div>
		<h3 class="contentTitle">测试项目</h3>
		<div class="tabs">

			<div class="tabsContent" style="height: 550px;">
				<div>
					<table class="list nowrap itemDetail" addButton="新建" width="100%">
						<thead>
							<tr>																
								<th type="text" name="c" size="12" fieldClass="required" >测试项目</th>
								<th type="del" width="60">操作</th>
							</tr>
						</thead>
						<tbody><c:forEach items="${list}" var="o">
							<tr class="unitBox">												
								<td><input type="text" name="c" value="${o }" size="12" class="required"  maxlength="20"></td>
								<td><a href="javascript:void(0)" class="btnDel ">删除</a></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</div>
				
			</div>

		</div>
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