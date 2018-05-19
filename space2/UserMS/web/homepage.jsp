<%--
  Created by IntelliJ IDEA.
  User: hugh
  Date: 2/26/18
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>个人网站</title>
</head>
<body>
<div align="center">
    <hr>
    <table border="1">
        <thead>
        <tr>
            <td>名称</td>
            <td>日期</td>
            <td>内容</td>
            <td>操作</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="o">
        <tr>
            <td>${o.mc}</td>
            <td>${o.date}</td>
            <td>${o.text}</td>
            <td><a href="">删除</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    <hr>
    <a href="add">添加</a>
</div>

</body>
</html>
