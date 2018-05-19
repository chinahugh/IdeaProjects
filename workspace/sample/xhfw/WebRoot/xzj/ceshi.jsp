<%@ page language="java" import="javax.servlet.http.Cookie" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>
继电器产品检测
</h3>
<hr>

条码：<input  type="text"> <input type="submit" value="查询" onclick="alert(1)">
<hr>
<h4>
产品信息
</h4>
物料：<input  type="text" readonly="readonly" > 
物料描述：<input  type="text" size="80" readonly="readonly" > 
<hr>
<h4>
检测信息
</h4>
故障码：<input  type="text"> <input type="submit" value="确定">
<hr>
<table border="1" width="100%">
<tr>
<th width="5%">序号</th><th width="25%">订单</th><th width="10%">故障码</th><th>描述</th>
</tr>
<tr>
<td>1</td><td>1</td><td>1</td><td>接点间隙小</td>
</tr>
</table>

</body>
</html>