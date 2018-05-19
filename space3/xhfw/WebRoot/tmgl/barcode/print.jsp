<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
table {
	width: 800px;
	border: 1px solid red;
}

td {
	width: 200px;
	height: 40px;
}
</style>
<style media=print type="text/css">
.noprint {
	visibility: hidden
}
</style>
	<style media="print">.Noprint { DISPLAY: none }</style>
<title>打印</title>
</head>
<body>
	<div>
		<c:forEach items="${list}" var="line">
			<table>
				<tr>
					<c:forEach items="${line}" var="o">
						<td><img alt="${o}" src="${o}"></td>
					</c:forEach>
				</tr>
			</table>
		</c:forEach>
	</div>
<center class=noprint>
	<div id="print"
		style="width: 100%; text-align: center; margin: 12px auto;">
		<input id="btnPrint" value="打印"
			style="width: 50px; height: 22px; font-size: 16px;" type="button"
			onclick="doPrint()">
	</div>
	<script type="text/javascript">
		function doPrint() {
			window.print("print");
		}
	</script>
	</center>

</body>
</html>