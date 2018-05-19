<%--
  Created by IntelliJ IDEA.
  User: hugh
  Date: 17-11-24
  Time: 下午9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理系统</title>
</head>
<frameset rows="80,*">
    <frame name="top"
           src="../frame/top.jsp">
    <frameset cols="150,*" id="main">
        <frame src="../frame/left.jsp">
        <frame name="right"
               src="../frame/right.jsp">
    </frameset>
</frameset>
</html>
