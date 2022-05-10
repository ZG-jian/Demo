<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/7/12
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" align="center">
    <tr>
        <th>Map的Key</th>
        <th>用户ID</th>
        <th>用户名</th>
    </tr>
    <c:forEach items="${map}" var="map">
        <tr>
            <td>${map.key}</td>
            <td>${map.value.userid}</td>
            <td>${map.value.username}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
