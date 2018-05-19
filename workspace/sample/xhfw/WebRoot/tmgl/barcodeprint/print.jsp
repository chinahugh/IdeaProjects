<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="icon" href="javascript:Show();"><span>打印</span></a></li>
		</ul>
	</div>
	<div >
		<table id="w_list_print" width="100%">
			<tbody>
				<c:forEach items="${path}" var="o">
					<tr>
						<td style="height: 17px" />
					</tr>
					<tr>
						<td align="center"><img src='tmgl/barcode/imag/${o}.png' alt='tmgl/barcode/imag/${o}.png'></td>
						<%-- 	<td align="center"><img src='tmgl/barcode/imag/${o}.png' alt='tmgl/barcode/imag/${o}.png'></td> --%>
					</tr>
					<tr>
						<td style="height: 30px" />
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<input id="ids" rel="${ids}" type="hidden" name="ids" value="${ids} ">
<input id="id" rel="${id}" type="hidden" name="id" value="${id}">
<script type="text/javascript">
	function Show() {
		var a = $.printBox('w_list_print');
		a.alert(a);
		var ids = $("#ids").val();
		var id = $("#id").val();
		/* $.ajax({
			type : 'post',
			url : 'barcodeprint/state',
			dataType : "json",
			data : {
				"ids" : ids,
				"id" : id
			},
			success : function(msg) {
				//alert(msg);
				//$.printBox('w_list_print');
			}
		}); */
	}
</script>