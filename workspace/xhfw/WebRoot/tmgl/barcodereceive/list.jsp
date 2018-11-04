<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
					员工号：<input type="text" name="ygh" value="${param.wlh}" size="20" />
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent" onclick="validate()"><button>查询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>  
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" href="barcodereceive/view/{sid_user}" target="navTab"><span>查看</span></a></li>
			<li><a class="add" href="barcodereceive/add/${fid}" target="navTab"><span>添加</span></a></li>
			<!--  <li><a class="edit" href="barcodereceive/edit/{sid_user}" target="navTab"><span>修改</span></a></li>  -->
			<li><a class="delete" href="barcodereceive/delete/{sid_user}"target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>员工号</th>
				<th>姓名</th>
				<th>领取日期</th>
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
			<%boolean isEvenLine = false;%>
			<c:forEach items="${page.list}" var="o">
				<tr target="sid_user" rel="${o.id}" ondblclick="view('barcodereceive/view/${o.id}')"class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
					<td style="text-align: left;">${o.ygh}</td>
					<td style="text-align: left;">${o.xm}</td>
					<td style="text-align: left;">${o.date}</td>
					<td style="text-align: left;">${o.bz}</td>
				</tr>
				<%isEvenLine = !isEvenLine;%>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span> <select class="combox" name="numPerPage"
				onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="${page.pageSize}"></option>
				<option value="20" ${page.pageSize==20?"selected":""}>20</option>
				<option value="50" ${page.pageSize==50?"selected":""}>50</option>
				<option value="100" ${page.pageSize==100?"selected":""}>100</option>
			</select> <span>条，共${page.totalPage}页 ${page.totalRow}条 </span>
		</div>
		<div class="pagination" targetType="navTab"
			totalCount="${page.totalRow }" numPerPage="${page.pageSize }"
			pageNumShown="${page.totalPage }" currentPage="${page.pageNumber }"></div>
	</div>
</div>
