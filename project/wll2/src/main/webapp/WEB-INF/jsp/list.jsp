<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: HUGH
  Date: 2018/5/6
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/jsp/libert.jsp"/>
<html>
<head>
    <title>列表</title>
</head>
<body>
    <table>
        <c:forEach items="list" var="o">

        </c:forEach>
    </table>
</body>
</html>
