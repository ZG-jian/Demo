<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/8/14
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--相对路径，不然会访问根目录--%>
    <form action="suibian/addUsers7" method="post">
        用户姓名:<input type="text" name="username"/><br/>
        爱好：<br/>
        体育<input type="checkbox" value="Sport" name="userlike"/>
        音乐<input type="checkbox" value="Music" name="userlike"/>
        艺术<input type="checkbox" value="Art" name="userlike"/><br/>
        地址：<br/>
        电话号码：<input type="text" name="addressMap['one'].phonenumber"/>
        邮编：<input type="text" name="addressMap['one'].postcode"/>
        电话号码：<input type="text" name="addressMap['two'].phonenumber"/>
        邮编：<input type="text" name="addressMap['two'].postcode"/>
        <input type="submit" value="OK"/>
    </form>
</body>
</html>
