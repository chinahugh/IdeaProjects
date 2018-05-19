<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hugh
  Date: 17-11-24
  Time: 上午11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC表单处理(复选框)</title>
</head>
<body>
<h2>用户信息 - </h2>
<form method="POST" action="/demo/test/addUser">
    <table>
        <tr>
            <td>用户名：<input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>密码：<input type="password" name="password" /></td>
        </tr>
        <tr>
            <td>地址：<%--<input type="text" size="30" name="address"/> --%>
                <textarea name="address" style="width: 200px;height: 100px">address</textarea>
            </td>
        </tr>
        <tr>
            <td>订阅新闻？<input type="checkbox" name="receivePaper"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
