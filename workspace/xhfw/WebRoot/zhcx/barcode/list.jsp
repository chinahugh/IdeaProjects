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
					产品条码：<input type="text" name="txm" value="${param.txm}" size="20" />
				</td>
				<td>
					产品版本：<input type="text" name="fid" value="${param.fid}" size="20" />
				</td>
				<td>
					订单：<input type="text" name="dd" value="${param.dd}" size="20" />
				</td>
				<td>
					产品版本：<input type="text" name="wlh" value="${param.wlh}" size="20" />
				</td>
				<td>
					订单：<input type="text" name="wlm" value="${param.wlm}" size="20" />
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
		       	<li><a class="edit" href="barcodeCX/list?txm={sid_user}" rel="jcxxcomponents" target="navTab"><span>条码记录</span></a></li>
				
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				
				<th >产品条码</th>
				<th >物料</th>
				<th >物料描述</th>
				<th >版本编号</th>
				<th >订单</th>
				<th >状态</th>
				
			</tr>
		</thead>
		<tbody><%boolean isEvenLine = false;%> 
			<c:forEach items="${page.list}" var="o">
			<tr target="sid_user" rel="${o.txm}" ondblclick="view('role/view/${o.id}')" class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
				
				<td style="text-align:left;">${o.txm}</td>
				<td style="text-align:left;">${o.wlh}</td>
				<td style="text-align:left;">${o.wlm}</td>
				<td style="text-align:left;">${o.fid}</td>
				<td style="text-align:left;">${o.dd}</td>
				<td style="text-align:left;">${o.state}</td>
													
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