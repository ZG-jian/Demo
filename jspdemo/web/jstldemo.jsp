<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/7/12
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--test里面为true，就会执行但不识别除了Boolean类型，所以使用EL表达式
              给表达式的话必须要能够返回一个布尔类型的值--%>

<%--多个when同时满足条件只执行第一个--%>
        <c:if test="${1==1}">
            执行了
        </c:if>
<c:choose>
    <c:when test="${1==1}">
        when1执行了
    </c:when>
    <c:when test="${1==1}">
        when2执行了
    </c:when>
    <c:when test="${1==1}">
        when3执行了
    </c:when>
    <c:otherwise>
        上面的都没执行，默认执行
    </c:otherwise>
</c:choose>
</body>
</html>
