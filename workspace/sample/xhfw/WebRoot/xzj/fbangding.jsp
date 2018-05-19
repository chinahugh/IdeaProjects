<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>产品条码绑定</title>
<script type="text/javascript" src="../jquery/jquery.min.js"></script>
<script type="text/javascript">
$(function () {
	if ($("#ftxm").val()=="") {
		$("#ftxm").focus();
	}else if ($("#btxm").val()=="") {
		$("#btxm").focus();
	}
	
	var msg='${msg}';
	if (msg!="") {
		alert(msg);
	}
	
})
</script>
</head>
<body>
<h6 align="right">
<c:if test='${ username==""}'><a  href="login.jsp">登录</a></c:if>
${username }  
<c:if test='${ username!=null}'><a  href="login.jsp">注销</a></c:if>  
</h6>
<h3>
产品条码绑定    
</h3>
<form action="fbangding">
<hr>

防伪条码：<input  type="text" name="fcpjc.ftxm" id="ftxm" size="30" value="${fcpjc.ftxm}"> <input type="submit" value="查询" >
产品条码：<input  type="text" name="fcpjc.btxm" id="btxm" value="${fcpjc.btxm}"> <input type="submit" value="保存" >

<hr>
<h4>
防伪信息
</h4>
订单：<input  type="text" name="fcpjc.dd" readonly="readonly" value="${fcpjc.dd}" /> 
物料：<input  type="text" name="fcpjc.wlh" readonly="readonly" value="${fcpjc.wlh}" /> 
物料描述：<input  type="text" name="fcpjc.wlm" readonly="readonly" value="${fcpjc.wlm}" size="50"/> 
<input  type="hidden" name="fcpjc.id" readonly="readonly" value="${fcpjc.id}" /> 
<input  type="hidden" name="fcpjc.fid" readonly="readonly" value="${fcpjc.fid}" /> 
<hr>

<h4>
产品信息
</h4>
订单：<input  type="text" name="cpjc.dd" readonly="readonly" value="${cpjc.dd}" /> 
物料：<input  type="text" name="cpjc.wlh" readonly="readonly" value="${cpjc.wlh}" /> 
物料描述：<input  type="text" name="cpjc.wlm" readonly="readonly" value="${cpjc.wlm}"size="50" /> 
<input  type="hidden" name="cpjc.fid" readonly="readonly" value="${cpjc.fid}" /> 
<hr>

</form>
<h4>
绑定记录
</h4>
<hr>
<table border="1" width="100%">
<tr>
<th width="5%">序号</th><th width="15%">防伪码</th><th width="15%">订单</th><th width="15%">物料</th><th width="20%">产品条码</th><th>时间</th>
</tr>
<c:forEach items="${list}" var="o" varStatus="s" >
<tr>
<td>${s.index+1}</td><td>${o.ftxm}</td><td>${o.dd}</td><td>${o.wlh}</td><td>${o.btxm}</td>
<td><fmt:formatDate value="${o.bdrq}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
</tr>
</c:forEach>
</table>

</body>
</html>