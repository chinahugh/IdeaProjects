<%@ page import="java.util.List" %>
<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>creatTable_接收表单</title>
<div></div>
</head>
<body>
<%--<%
    String rows = request.getParameter("rows");//接受表单内容
    String cols = request.getParameter("cols");
%>--%>
<%
    int colum= (int)session.getAttribute("colum");
    int row = (int) session.getAttribute("row");
   String path= (String) session.getAttribute("path");
%>
<table border="1" width="300">
    <%
        for (int i = 1; i <= row; i++) {
    %>
    <tr>
        <%
            for (int j = 1; j <= colum ; j++) {
        %>
<%--<c:forEach items="${page.path}" var="o"/>--%>
        <td>
          <img src="${page.}" alt="${page.path}" >
        </td>

        <%
            }
        %>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>