<%--
  Created by IntelliJ IDEA.
  User: hugh
  Date: 17-11-23
  Time: 下午8:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login</h2>
<form action="/test/login" method="get">
    <table>

        <tr>
            name:
        <tr>
            <input type="text" name="name">
        </tr>
        </tr>
        <tr>
            password:
        <tr>
            <input type="password" name="password">
        </tr>
        </tr>

        <td>
            <input type="submit">
        </td>
    </table>
</form>
</body>
</html>
