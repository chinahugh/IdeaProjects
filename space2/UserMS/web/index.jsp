<%--
  Created by IntelliJ IDEA.
  User: hugh
  Date: 12/27/17
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>个人网页登录</title>
  </head>
  <body>
  <form action="/form/login" method="get">
  <table align="center">
    <tr>
      <td>name</td>
      <td><label>
        <input type="text" name="name">
      </label></td>
    </tr>
    <tr>
      <td>password</td>
      <td><label>
        <input type="password" name="password">
      </label></td>
    </tr>
    <tr>
     <td><input type="submit"></td>
    </tr>
  </table>
  </form>
  </body>
</html>
