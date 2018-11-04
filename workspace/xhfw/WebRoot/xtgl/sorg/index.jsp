<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
</style>

<div style="padding:5px">
	
	<div class="tabs">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					
				</ul>
			</div>
		</div>
		<div class="tabsContent">
			<div>
	
				<div layoutH="50" style="float:left; display:block; overflow:auto; width:340px; border:solid 1px #CCC; line-height:21px; background:#fff">
				    <ul class="tree treeFolder">
						<li><a href="sorg/list/0" target='ajax' rel='bmBox'>西安信号厂</a>
                        ${treeStr }
						</li>
						
				     </ul>
				</div>
				
				<div layoutH="0"  id="bmBox" class="unitBox" style="margin-left:246px;">
					<!--#include virtual="list1.html" -->

<div >

<div class="pageHeader">
	<form  id="pagerForm" onsubmit="return divSearch(this, 'bmBox');" action="sorg/list/${sorgFid}" method="post">
		<input type="hidden" name="status" value="${param.status}">	
	<input type="hidden" name="pageNum" value="${page.pageNumber }" />
	<input type="hidden" name="numPerPage" value="${page.pageSize }" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					部门名称：<input type="text" size="20" name="keywords" value="${param.keywords}"/>
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
			<li><a class="edit" href="sorg/view/{sid_user}?fid=${sorgFid}" target="navTab"><span>查看</span></a></li>
			<li><a class="add" href="sorg/add/${sorgFid}" target="navTab"><span>添加</span></a></li>
			<li><a class="delete" href="sorg/delete/{sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="sorg/edit/{sid_user}?fid=${sorgFid}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="sorg/export/${sorgFid}" target="dwzExport"   title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="180" rel="bmBox">
		<thead>
			<tr>
				<th >名称</th>
				<th >描述</th>
			</tr>
		</thead>
		<tbody><%boolean isEvenLine = false;%> 
			<c:forEach items="${page.list}" var="o">
			<tr target="sid_user" rel="${o.id}" ondblclick="view('bm/view/${o.id}')" class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
				<td style="text-align:left;">${o.mc}</td>
				<td style="text-align:left;">${o.ms}</td>
			</tr><%isEvenLine=!isEvenLine; %>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, 'bmBox')">
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
				</div>
	
			</div>
			

		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>
	
</div>


	

