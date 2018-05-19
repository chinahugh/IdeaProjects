<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script> -->
<style>
table{
	width: 99% !important;
}
</style>
<div class="pageHeader">
	<form  id="pagerForm" onsubmit="return navTabSearch(this);" action="sms" method="post">
		<input type="hidden" name="status" value="${param.status}">	
	<input type="hidden" name="pageNum" value="${page.pageNumber }" />
	<input type="hidden" name="numPerPage" value="${page.pageSize }" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
				              标&nbsp;&nbsp;题：<input type="text" value="${param.keywords}" size="20"/>
					&nbsp;&nbsp;短信内容：<input type="text" name="keywords" value="${param.keywords}" size="20" />
					&nbsp;&nbsp;时间：<input type="text" name="" size="20"/>
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
		<!-- 	<li><a class="edit" href="smstemp/view/{sid_user}" target="navTab"><span>查看</span></a></li> -->
			 <li><a class="add" href="smstemp/add?wxsz2=${wxsz}" target="navTab"><span>添加</span></a></li>
			<%-- <li><a class="icon" href="smstemp/add?wxsz2=${wxsz}" target="dialog" rel="dlg_page7" width="800" height="480"><span>添加</span></a></li> --%>
			
			<li><a class="delete" href="smstemp/delete/{sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="smstemp/edit/{sid_user}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="sms/export" target="dwzExport"   title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li> -->
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<c:if test="${type!='1'}">
				<th >选择模版</th>
				</c:if>
				<th >标题</th>
				<th >内容</th>
				<th >时间</th>
				
			</tr>
		</thead>
		<tbody><%boolean isEvenLine = false;%> 

			<c:forEach items="${page.list}" var="o">
			<tr target="sid_user" rel="${o.id}" ondblclick="sms('${o.title} ')" class="<%=(isEvenLine) ? "tr2" : "tr1"%>" >
				<c:if test="${type!='1'}">
				<td>
					<a class="" style="color:#00f;" href="javascript:$.bringBack({ content:'${o.title}-${o.smsContent}'})" title="选择模版">点我选择</a>
				</td>
				</c:if>
				<td style="text-align:left;" >${o.title}</td>
				<td style="text-align:left;">${o.smsContent}</td>
                <td style="text-align:left;"><fmt:formatDate value="${o.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
<script type="text/javascript">
	

</script>