<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form id="pagerForm" action="listWLLoop">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>
<div class="pageHeader">
	<form rel="pagerForm" method="post" action="listWLLoop" onsubmit="return dwzSearch(this, 'dialog');">
	<input type="hidden" name="a" value="${param.a}" />
<input type="hidden" name="b" value="${param.b}" />
		<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>物料名称:</label>
				<input class="textInput" name="wlms" value="${param.wlms}" type="text">
			</li>	  
			<li>
				<label>物料编号:</label>
				<input class="textInput" name="wl" value="${param.wl}" type="text">
			</li>
			<li>
				<label>测试模版:</label>
				<input class="textInput" name="mc" value="${param.mc}" type="text">
			</li>

		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">

	<table class="table" layoutH="118" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th >物料名称</th>
				<th >物料编号</th>
				<th >测试模版</th>

				<th width="80">查找带回</th>
			</tr>
		</thead>
		<tbody>
					<c:forEach items="${page.list}" var="o">
			<tr target="sid_user" rel="${o.id}" ondblclick="view('role/view/${o.id}')" class="tr1">
				<td style="text-align:left;">${o.wlm}</td>
				<td style="text-align:left;">${o.wlh}</td>
				<td>${o.mc}</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({${param.a}:'${o.id}', ${param.b}:'${o.mc}'})" title="查找带回">选择</a>
				</td>
			</tr>
			</c:forEach>

		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select name="numPerPage" onchange="dwzPageBreak({targetType:'dialog', numPerPage:'10'})">
				<option value="${page.pageSize}" ></option><option value="20" ${page.pageSize==20?"selected":""}>20</option>
				<option value="50" ${page.pageSize==50?"selected":""}>50</option>
				<option value="100" ${page.pageSize==100?"selected":""}>100</option>
			</select>
			<span>条，共${page.totalPage}页 ${page.totalRow}条 </span>
		</div>
		
		<div class="pagination" targetType="dialog" totalCount="${page.totalRow }" numPerPage="${page.pageSize }" pageNumShown="${page.totalPage }" currentPage="${page.pageNumber }"></div>

	</div>
	
</div>