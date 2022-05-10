<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/9/4
  Time: 19:09
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
        <th>
            <td>用户ID</td>
            <td>用户登录名</td>
            <td>用户密码</td>
        </th>
        <c:forEach items="${list}" var="user">
            <tr>
                <th>${user.userid}</th>
                <th>${user.username}</th>
                <th>${user.userpwd}</th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
