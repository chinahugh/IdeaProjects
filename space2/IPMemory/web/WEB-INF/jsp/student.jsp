<%--
  Created by IntelliJ IDEA.
  User: hugh
  Date: 17-11-23
  Time: 下午10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC表单之-输入框处理</title>
</head>
<body>
<h2>学生信息</h2>
<form action="/demo/test/addstudent" method="post">
    <table>
        <tr>
            <td>name<input type="text" name="name"></td>
        </tr>
        <tr>
            <td>age:<input type="text" name="age"></td>
        </tr>
        <tr>
            <td>id:<input type="text" name="id"></td>
        </tr>
        <tr>
            <td>password:<input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交学生信息"/></td>
        </tr>
    </table>
</form>
</body>
</html>
