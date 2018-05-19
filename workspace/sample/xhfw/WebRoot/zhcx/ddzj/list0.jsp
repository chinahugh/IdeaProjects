<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
<div class="pageHeader" style="border:1px #B8D0D6 solid">
	<form id="pagerForm" onsubmit="return divSearch(this, 'jbsxBox0');"  action="zhcxddzj/list0" method="post">

		<input type="hidden" name="status" value="${param.status}">	
		<input type="hidden" name="pageNum" value="${page.pageNumber }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize }" />
		<input type="hidden" name="orderField" value="${param.orderField}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					订单：<input type="text" name="dd" value="${param.dd}" size="20" />
				</td>
				<td>
					订单类型：<input type="text" name="ddlx" value="${param.ddlx}" size="20" />
				</td>
				<td>
					MRP控制者：<input type="text" name="mrpkzz" value="${param.mrpkzz}" size="20" />
				</td>
				<td>
					订单完成状态：<input type="text" name="status1" value="${param.status1}" size="20" />
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
			
			<li><a class="edit" href="indentCX/view/{sid_user}" target="navTab"><span>查看</span></a></li>
			<li><a class="icon" href="indentCX/export" target="dwzExport"   title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li> 
		</ul>
	</div>
	<table class="table" width="99%" layoutH="550" rel="jbsxBox0">
		<thead>
			<tr>
				<th >订单</th>
				<th >物料</th>
				<th >订单类型</th>
				<th >订单数量</th>
				<th >基本开始日期</th>
				<th >基本完成日期</th>
				<th >系统状态</th>
				<th >物料描述</th>
				<th >订单完成状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<%boolean isEvenLine = false;%> 
			<c:forEach items="${page.list}" var="o">
			<tr target="sid_obj" rel="${o.id}" ondblclick="view('indentCX/view/${o.id}')" class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
				<td style="text-align:left;">${o.dd}</td>
				<td style="text-align:left;">${o.wl}</td>
				<td style="text-align:left;">${o.ddlx}</td>
				<td style="text-align:left;">${o.ddsl}</td>
				<td style="text-align:left;">${o.jbksrq}</td>
				<td style="text-align:left;">${o.jbwcrq}</td>
				<td style="text-align:left;">${o.xtzt}</td>
				<td style="text-align:left;">${o.wlms}</td>
				<td style="text-align:left;">${o.status}</td>
				<td><a href="zhcxddzj/list1/${o.id}" target="ajax" rel="jbsxBox1">组件列表</a></td>
			</tr><%isEvenLine=!isEvenLine; %>
			</c:forEach>

		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, 'jbsxBox0')">
			<option value="${page.pageSize}" ></option><option value="20" ${page.pageSize==20?"selected":""}>20</option>
				<option value="50" ${page.pageSize==50?"selected":""}>50</option>
				<option value="100" ${page.pageSize==100?"selected":""}>100</option>
			</select>
			<span>条，共${page.totalPage}页 ${page.totalRow}条 </span>
		</div>
		<div class="pagination" rel="jbsxBox0" totalCount="${page.totalRow }" numPerPage="${page.pageSize }" pageNumShown="${page.totalPage }" currentPage="${page.pageNumber }"></div>
		
	</div>
</div>
</div>