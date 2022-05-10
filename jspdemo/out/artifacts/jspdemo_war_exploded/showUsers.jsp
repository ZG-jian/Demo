<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/7/12
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <table border="1" align="center">
            <tr>
                <th>用户ID</th>
                <th>用户名</th>
            </tr>
            <c:forEach items="${requestScope.list}" var="user">
                <tr>
                    <td>${user.userid}</td>
                    <td>${user.username}</td>
                </tr>
            </c:forEach>
        </table>

</body>
</html>
