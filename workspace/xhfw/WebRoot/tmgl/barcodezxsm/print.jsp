<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">

/* $(function () {
navTab.reloadFlag('barcodezxsm');
navTab.reload();
}); */
</script>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="icon" href="javascript:$.printBox('w_list_print')"><span>打印</span></a></li>
		</ul>
	</div>
	<div id="w_list_print" align="center">
		<table class="list" targetType="navTab" width="70%" layoutH="116">
			<tbody>
				<c:forEach items="${path}" var="o">
					<tr>
						<td align="center"><img src='${o}'></td>
						<td align="center"><img src='${o}'></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>