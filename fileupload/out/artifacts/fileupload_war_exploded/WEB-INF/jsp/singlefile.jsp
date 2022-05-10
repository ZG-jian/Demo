<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/8/15
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--文件上传只能字节方式提交 所以就是post提交方式--%>
    <form action="/file/singleFile" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username"/><br/>
        文件上传：<input type="file" name="file"/><br/>
        <input type="submit" value="OKOK"/>
    </form>
</body>
</html>
