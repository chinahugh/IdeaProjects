<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pageHeader">
	<form  id="pagerForm" method="post"  onsubmit="return navTabSearch(this);"  >
		<input type="hidden" name="status" value="${param.status}">	
		<input type="hidden" name="pageNum" value="${page.pageNumber }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize }" />
		<input type="hidden" name="orderField" value="${param.orderField}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					条码：${cpjcjl.txm}
				</td>
				<td>
					物料：${cpjcjl.wlh}
				</td>
				<td>
					工序：${cpjcjl.mc}
				</td>

			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button>查询</button></div></div></li>
				
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="icon" href="cpgx2jl/export1/${id}" target="dwzExport"   title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="list" width="100%" layoutH="138" border="2">
		<thead>
			<tr>
			<c:forEach items="${xmL}" var="o">
			     <th >${o.mc}</th>
			</c:forEach>
			</tr>
		</thead>
		<tbody> 
			<c:forEach items="${jlL}" var="j">
			<tr  >
				<c:forEach items="${xmL}"  varStatus="i">
				<c:set value="c${i.index}" var="m" scope="page"></c:set>
			     <th >${j[m]}</th>
			     
			  </c:forEach>
			
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>
