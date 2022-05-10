<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/9/3
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${msg}
    <form action="/user/userLogin" method="post">
        登录名：<input type="text" name="username"/><br/>
        密码：<input type="password" name="userpwd"/><br/>
        <input type="submit" value="OK"/>

    </form>
</body>
</html>
