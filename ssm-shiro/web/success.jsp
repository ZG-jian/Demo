<%--
  Created by IntelliJ IDEA.
  User: SXT
  Date: 2019/10/9
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成功页面</title>
    <base href="<%=request.getContextPath()+"/"%>">
</head>
<body>
<h3>成功页面</h3>
<h4 style="float: right"><a href="loginOut">退出</a></h4>
<h3>sessionID:<%= session.getId()%></h3>
<hr/>
<c:forEach items="${list}" var="menu">
    <h4>${menu.mname}</h4> <br/><br/><br/>
    <c:forEach items="${menu.list}" var="menu2">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${menu2.url}">${menu2.mname}</a>
    </c:forEach>
</c:forEach>
</body>
</html>
