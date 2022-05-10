<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/7/12
  Time: 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String value = (String) request.getAttribute("key");
%>
当前浏览器支持的语言为：<%=value %>
</body>
</html>
