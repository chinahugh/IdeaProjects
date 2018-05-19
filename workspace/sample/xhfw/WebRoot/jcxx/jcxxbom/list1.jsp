<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pageHeader">
	<form  id="pagerForm" method="post" action="jcxxbom/list1/${wlh }-${id}" rel="jcxxbomBox"  onsubmit="return divSearch(this,'jcxxbomBox');"  >
		<input type="hidden" name="status" value="${param.status}">	
		<input type="hidden" name="pageNum" value="${page.pageNumber }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize }" />
		<input type="hidden" name="orderField" value="${param.orderField}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					物料号：<input type="text" name="wlh" value="${param.wlh}" size="20" />
				</td>
				<td>
					产品名称：<input type="text" name="wlm" value="${param.wlm}" size="20" />
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
			<li><a class="edit"  href="jcxxbom/view1/{sid_user}" rel="jcxxbomView" target="navTab"><span>查看</span></a></li>
			<li><a class="edit" href="jcxxbom/add1/{sid_user}-${id }" target="navTab" rel="jcxxbomAdd"><span>复制产品</span></a></li>
			<c:if test="${flag==1 }">
				<li><a class="delete" href="jcxxbom/delete1/{sid_user}" target="ajaxTodo" rel="jcxxbomdel" title="确定要删除吗?"><span>删除</span></a></li>
			</c:if>
			<!-- <li><a class="edit" href="jcxxbom/edit1/{sid_user}" target="navTab" rel="jcxxbomEdit" ><span>修改</span></a></li> -->
		</ul>
	</div>
	<table class="table" width="100%" layoutH="170" rel="jcxxbomBox">
		<thead>									
			<tr>
				<th >物料号</th>
				<th >产品描述</th>
				<th >版本号</th>
			</tr>
		</thead>
		<tbody>
		<%boolean isEvenLine = false;%> 
			<c:forEach items="${page.list}" var="o">
			<tr target="sid_user" rel="${o.id}" ondblclick="view('jcxxbom/view1/${o.id}')" class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
				<td style="text-align:left;">${o.wlh}</td>
				<td style="text-align:left;">${o.wlms}</td>
				<td style="text-align:left;">${o.bbh}</td>
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
		
		<div class="pagination" rel="jcxxbomBox" totalCount="${page.totalRow }" numPerPage="${page.pageSize }" pageNumShown="${page.totalPage }" currentPage="${page.pageNumber }"></div>

	</div>
</div>
