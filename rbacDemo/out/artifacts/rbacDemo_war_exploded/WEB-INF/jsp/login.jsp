<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/10/6
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h3><font color="red">${requestScope.msg }</font></h3>
<form action="userLogin" method="post">
    用户名<input type="text"  name="username"/><br/>
    密码<input type="password"  name="userpwd"/><br/>
    <input type="submit" value="OK"/><br/>
</form>
</body>
</html>
