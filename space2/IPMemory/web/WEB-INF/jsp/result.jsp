<%--
  Created by IntelliJ IDEA.
  User: hugh
  Date: 17-11-23
  Time: 下午10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Spring MVC表单之-输入框处理</title>
</head>
<body>

<h2>提交的学生信息如下</h2>
<table>
    <tr>
        <td>姓名：</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>年龄：</td>
        <td>${age}</td>
    </tr>
    <tr>
        <td>编号：</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>密码:</td>
        <td>${password}</td>
    </tr>
</table>
</body>
</html>
