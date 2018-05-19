<%--
  Created by IntelliJ IDEA.
  User: hugh
  Date: 1/5/18
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>页面重定向</title>
</head>
<body>
    <%--使用form标签创建表单--%>
    <form action="re001" method="post">
        <table border="1" align="center">
            <tr>
                <td>name: <input type="text" name="name"></td>
                <td>password: <input type="password" name="password"></td>
                <td>adress: <input type="text" name="adress"></td>
                <td><input type="submit"></td>
            </tr>
        </table>
    </form>
</body>
</html>
