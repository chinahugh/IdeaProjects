<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HUGH
  Date: 2018/4/15
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:include page="/WEB-INF/jsp/include/taglib.jsp"/>
<html>
<head>
    <title>list</title>
</head>
<body>
<h1> list</h1>

<table border="1">
    <c:forEach items="${page.list}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
