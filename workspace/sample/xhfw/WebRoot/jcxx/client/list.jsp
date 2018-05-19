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
					编号：<input type="text" name="bh" value="${param.bh}" size="20" />
				</td>
				<td>
					名称：<input type="text" name="mc" value="${param.mc}" size="20" />
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
			<li><a class="edit" href="client/view/{sid_user}" target="navTab"><span>查看</span></a></li>
			<li><a class="add" href="client/add" target="navTab"><span>添加</span></a></li>
			<c:if test="${flag==1 }">
				<li><a class="delete" href="client/delete/{sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			</c:if>			
			<li><a class="edit" href="client/edit/{sid_user}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="client/export" target="dwzExport"   title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
			<li><a class="icon" href="client/importFile" target="navTab"><span>导入EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th >编号</th>
				<th >名称</th>
				<th >联系人1</th>
				<th >联系人2</th>
				<th >电话1</th>
				<th >电话2</th>
				<th >地址</th>
				<th >城市</th>
				<th >电子邮箱</th>
				<th >备注</th>
			</tr>
		</thead>
		<tbody><%boolean isEvenLine = false;%> 
			<c:forEach items="${page.list}" var="o">
			<tr target="sid_user" rel="${o.id}" ondblclick="view('client/view/${o.id}')" class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
				<td style="text-align:left;">${o.bh}</td>
				<td style="text-align:left;">${o.mc}</td>
				<td style="text-align:left;">${o.lxr1}</td>
				<td style="text-align:left;">${o.lxr2}</td>
				<td style="text-align:left;">${o.dh1}</td>
				<td style="text-align:left;">${o.dh2}</td>
				<td style="text-align:left;">${o.dz}</td>
				<td style="text-align:left;">${o.cs}</td>
				<td style="text-align:left;">${o.dzyx}</td>
				<td style="text-align:left;">${o.bz}</td>
			</tr><%isEvenLine=!isEvenLine; %>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="${page.pageSize}" ></option><option value="20" ${page.pageSize==20?"selected":""}>20</option>
				<option value="50" ${page.pageSize==50?"selected":""}>50</option>
				<option value="100" ${page.pageSize==100?"selected":""}>100</option>
			</select>
			<span>条，共${page.totalPage}页 ${page.totalRow}条 </span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${page.totalRow }" numPerPage="${page.pageSize }" pageNumShown="${page.totalPage }" currentPage="${page.pageNumber }"></div>

	</div>
</div>
