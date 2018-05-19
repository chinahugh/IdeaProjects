<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" href="barcodeconf/view/{sid_user}" target="navTab"><span>查看</span></a></li>
			<li><a class="add" href="barcodeconf/add" target="navTab"><span>添加</span></a></li>
			<li><a class="edit" href="barcodeconf/edit/{sid_user}" target="navTab"><span>修改</span></a></li>
			<li><a class="delete" href="barcodeconf/delete/{sid_user}"target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th>条码名称</th>
				<th>添加日期</th>
				<th>标题</th>
				<th>第一字段</th>
				<th>第二字段</th>
				<th>第三字段</th>
				<th>第四字段</th>
				<th>第五字段</th>
				<th>第六字段</th>
				<th>第七字段</th>
				<th>第八字段</th>				
			</tr>
		</thead>
		<tbody>
			<%
				boolean isEvenLine = false;
			%>
			<c:forEach items="${page.list}" var="o">
				<tr target="sid_user" rel="${o.id}"
					ondblclick="view('barcodeconf/view/${o.id}')"
					class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
					<td style="text-align: left;">${o.mc}</td>
					<td style="text-align: left;">${o.xzrq}</td>
					<td style="text-align: left;">${o.t1}</td>
					<td style="text-align: left;">${o.d1}</td>
					<td style="text-align: left;">${o.d2}</td>
					<td style="text-align: left;">${o.d3}</td>
					<td style="text-align: left;">${o.d4}</td>
					<td style="text-align: left;">${o.d5}</td>
					<td style="text-align: left;">${o.d6}</td>
					<td style="text-align: left;">${o.d7}</td>
					<td style="text-align: left;">${o.d8}</td>					
				</tr>
				<%
					isEvenLine = !isEvenLine;
				%>
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
