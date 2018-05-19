<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hugh
  Date: 17-11-23
  Time: 下午9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Redirectindex</title>
</head>
<body>
<h2>Redirectindex</h2>
<h2>Spring MVC页面重定向</h2>
<p>点击下面的按钮将结果重定向到新页面</p>
<form method="GET" action="demo/test/redirect/redirect">
    <table>
        <tr>
            <td><input type="submit" value="页面重定向" /></td>
        </tr>
    </table>
</form>
</body>
</html>
