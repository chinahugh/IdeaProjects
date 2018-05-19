<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<form id="pagerForm" action="/treeJSLoop"  onsubmit="return dwzSearch(this, 'dialog');">
<input type="hidden" name="a" value="${param.a}">	
<input type="hidden" name="b" value="${param.b}">	
	<input type="hidden" name="status" value="${param.status}">	
	<input type="hidden" name="pageNum" value="${page.pageNumber }" />
	<input type="hidden" name="numPerPage" value="${page.pageSize }" />
	<input type="hidden" name="orderField" value="${param.orderField}" />

<div class="pageHeader">

	<div class="searchBar">
		<ul class="searchContent">
  
			<li>
				<label>角色编号:</label>
				<input class="textInput" name="id" value="${id }" type="text">
			</li>
			<li>
				<label>角色名称:</label>
				<input class="textInput" name="mc" value="${mc }">
			</li>

		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button>查询</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" multLookup="orgId" warn="请选择角色">选择带回</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">

	<table class="table" layoutH="118" targetType="dialog" width="100%">
		<thead>
			<tr>
			<th width="30"><input type="checkbox" class="checkboxCtrl" group="orgId" /></th>
				<th >角色编号</th>
				<th >角色名称</th>
				<th >描述</th>
				<th width="12%">查找带回</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="o">
			<tr target="sid_user" rel="${o.id}">
			<td><input type="checkbox" name="orgId" value="{${param.a }:'${o.id}',${param.b }:'${o.mc}'}"/></td>
				<td style="text-align:left;"><c:out value="${o.id}" default=""/></td>
				<td style="text-align:left;">${o.mc}</td>
				<td style="text-align:left;">${o.ms}</td>
				<td style="text-align:left;">
					<a class="btnSelect" href="javascript:$.bringBack({${param.a }:'${o.id}',${param.b }:'${o.mc}'})" title="查找带回">选择</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class="panelBar">
		<div class="pages">
			<span>每页</span>

			<select name="numPerPage" onchange="dwzPageBreak({targetType:dialog, numPerPage:'10'})">
				<option value="10" ${page.pageSize==10?"selected":""}>10</option>
				<option value="${page.pageSize}" ></option><option value="20" ${page.pageSize==20?"selected":""}>20</option>
				<option value="50" ${page.pageSize==50?"selected":""}>50</option>
				<option value="100" ${page.pageSize==100?"selected":""}>100</option>
			</select>
			<span>条，共2条</span>
		</div>
		<div class="pagination" targetType="dialog" totalCount="${page.totalRow }" numPerPage="${page.pageSize }" pageNumShown="${page.totalPage }" currentPage="${page.pageNumber }"  ></div>
	</div>
</div>