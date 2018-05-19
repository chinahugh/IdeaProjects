<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageHeader">
	<form id="pagerForm" method="post" onsubmit="return navTabSearch(this);">
		<input type="hidden" name="status" value="${param.status}"> <input type="hidden" name="pageNum"
			value="${page.pageNumber }" /> <input type="hidden" name="numPerPage" value="${page.pageSize }" /> <input
			type="hidden" name="orderField" value="${param.orderField}" />
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>条码：<input type="text" name="tm" value="${param.tm}" size="20" />
					</td>
					<td>生成日期：<input class="required date" type="text" name="scrq" value="${param.scrq}" size="20" />
					</td>
					<td>条码方式：<input type="text" name="tmfs" value="${param.tmfs}" size="20" />
					</td>
					<td>打印状态：<td><select class="combox" name="state">
							<option value="">打印状态</option>
							<option value="1">已打印</option>
							<option value="0">未打印</option>
					</select></td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button>查询</button>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<form method="post" action="barcodelist/printconf" rel="ids" onsubmit="return navTabSearch(this);">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="edit" href="barcodelist/view/{sid_user}" target="navTab"><span>查看</span></a></li>
				<li><a title="确定要删除吗?" target="selectedTodo" rel="ids" href="barcodelist/delete" class="delete"><span>批量删除</span></a></li>
			</ul>
		</div>
		<!-- <div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">打印</button>
						</div>
					</div></li>
			</ul>
		</div> -->
		<table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th width="30"><input type="checkbox" class="checkboxCtrl" group="ids" /></th>
					<th>条码</th>
					<th>物料描述</th>
					<th>产品</th>
					<th>产品版本</th>
					<th>条码方式</th>
					<th>生成日期</th>
					<th>打印状态</th>
					<!-- <th>打印</th> -->
				</tr>
			</thead>
			<tbody>
				<%
					boolean isEvenLine = false;
				%>
				<c:forEach items="${page.list}" var="o">
					<tr target="sid_user" rel="${o.id}" ondblclick="view('barcodelist/view/${o.id}')"
						class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
						<td><input type="checkbox" name="ids" value="${o.id}" /></td>
						<td style="text-align: left;">${o.txm}</td>
						<td style="text-align: left;">${o.wlm}</td>
						<td style="text-align: left;">${o.wlh}</td>
						<td style="text-align: left;">${o.bbh}</td>
						<td style="text-align: left;">${o.fs}</td>
						<td style="text-align: left;">${o.scrq}</td>
						<td style="text-align: left;">${o.state==1?'已打印':'未打印'}</td>
						<%-- <td><a href="barcodelist/print/${o.id}" target="navTab">打印</a></td> --%>
					</tr>
					<%
						isEvenLine = !isEvenLine;
					%>
				</c:forEach>
			</tbody>
		</table>
		<div class="panelBar">
		<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">打印</button>
						</div>
					</div></li>
			<div class="pages">
				<span>显示</span> <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
					<option value="${page.pageSize}"></option>
					<option value="20" ${page.pageSize==20?"selected":""}>20</option>
					<option value="50" ${page.pageSize==50?"selected":""}>50</option>
					<option value="100" ${page.pageSize==100?"selected":""}>100</option>
				</select> <span>条，共${page.totalPage}页 ${page.totalRow}条 </span>
			</div>
			<div class="pagination" targetType="navTab" totalCount="${page.totalRow }" numPerPage="${page.pageSize }"
				pageNumShown="${page.totalPage }" currentPage="${page.pageNumber }"></div>				
		</div>
		
	</form>
</div>
<script type="text/javascript">
	var msg = '${msg}';
	if (msg != '') {
		alertMsg.info(msg);
		setTimeout(function() {
			navTab.closeCurrentTab();
		}, 100);
	}
	/* <c:if test="${msg!=null}">
		alertMsg.info('${msg}');
		setTimeout(function(){navTab.closeCurrentTab();}, 100);
	</c:if> */
</script>
