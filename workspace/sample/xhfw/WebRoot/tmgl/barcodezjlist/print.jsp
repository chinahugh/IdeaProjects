<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" href="barcodelist/view/{sid_user}" target="navTab"><span>查看</span></a></li>
			<li><a class="icon" href="javascript:Show();"><span>打印</span></a></li>
		</ul>
	</div>
	<div id="w_list_print">
		<table class="list" targetType="navTab" width="100%" asc="asc" desc="desc" layoutH="116">
			<tbody>
				<c:forEach items="${page.list}" var="o">
					<tr>
						<td align="center"><img src='tmgl/barcode/imag/${o.txm}.png'></td>
						<td align="center"><img src='tmgl/barcode/imag/${o.txm}.png'></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%-- <div class="panelBar">
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
	</div> --%>
</div>
<input id="ids" rel="${ids}" type="hidden" name="ids" value="${ids} ">
<script type="text/javascript">
	function Show() {
		var ids = $("#ids").val();
		$.ajax({
			type : 'post',
			url : 'barcodelist/state',
			dataType : "json",
			data : {
				"ids" : ids
			},
			success : function(msg) {
				//alert(msg);
				$.printBox('w_list_print');
			}
		});
	}
</script>