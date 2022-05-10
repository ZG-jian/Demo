<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/8/15
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${files}" var="file">
    <a href="/file/fileDown?fileName=${file}">${file}</a><br/>
    </c:forEach>
</body>
</html>
