<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/8/15
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/file/multifile" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username"/><br/>
    文件上传1：<input type="file" name="file"/><br/><%--多文件上传file组件的name要相同--%>
    文件上传2：<input type="file" name="file"/><br/>
    <input type="submit" value="OKOK"/>
</form>
</body>
</html>
