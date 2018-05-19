<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div >

<div class="pageHeader">
	<form  id="pagerForm" onsubmit="return divSearch(this, 'bmBox');" action="productGX/list/${productGXFid}" method="post">
		<input type="hidden" name="status" value="${param.status}">	
	<input type="hidden" name="pageNum" value="${page.pageNumber }" />
	<input type="hidden" name="numPerPage" value="${page.pageSize }" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					名称：<input type="text" size="20" name="keywords" value="${param.keywords}"/>
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
			<li><a class="edit" href="productGX/view/{sid_user}?fid=${productGXFid}" target="navTab"><span>查看</span></a></li>
			<li><a class="add" href="productGX/add/${productGXFid}" target="navTab"><span>添加</span></a></li>
			<li><a class="delete" href="productGX/delete/{sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="productGX/edit/{sid_user}?fid=${productGXFid}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="productGX/export/${productGXFid}" target="dwzExport"   title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="180" rel="bmBox">
		<thead>
			<tr>
				<th >名称</th>
				<th >工作台</th>
				<th >检测项目</th>
			</tr>
		</thead>
		<tbody>
		<tr target="sid_user" rel="${o.id}" ondblclick="view('productGX/view/${o.id}')" class="tr1">
				<td style="text-align:left;">工序1</td>
				<td style="text-align:left;">工作台1，工作台2</td>
				<td style="text-align:left;">检测项A,检测项B,检测项C</td>
			</tr>
					<tr target="sid_user" rel="${o.id}" ondblclick="view('productGX/view/${o.id}')" class="tr2">
				<td style="text-align:left;">工序2</td>
				<td style="text-align:left;">工作台3</td>
				<td style="text-align:left;">检测项D,检测项E</td>
			</tr>
					<tr target="sid_user" rel="${o.id}" ondblclick="view('productGX/view/${o.id}')" class="tr1">
				<td style="text-align:left;">工序3</td>
				<td style="text-align:left;">工作台4，工作台5</td>
				<td style="text-align:left;">检测项F</td>
			</tr>
		<%boolean isEvenLine = false;%> 
		
			<c:forEach items="${page.list}" var="o">
			<tr target="sid_user" rel="${o.id}" ondblclick="view('productGX/view/${o.id}')" class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
				<td style="text-align:left;">${o.mc}</td>
				<td style="text-align:left;">${o.dm}</td>
				<td style="text-align:left;">${o.ms}</td>
			</tr><%isEvenLine=!isEvenLine; %>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select   onchange="navTabPageBreak({numPerPage:this.value}, 'bmBox')">
				<option value="${page.pageSize}" ></option><option value="20" ${page.pageSize==20?"selected":""}>20</option>
				<option value="50" ${page.pageSize==50?"selected":""}>50</option>
				<option value="100" ${page.pageSize==100?"selected":""}>100</option>
			</select>
			<span>条，共${page.totalPage}页 ${page.totalRow}条 </span>
		</div>
		
		<div class="pagination"  rel="bmBox" totalCount="${page.totalRow }" numPerPage="${page.pageSize }" pageNumShown="${page.totalPage }" currentPage="${page.pageNumber }"></div>

	</div>
</div>

</div>	