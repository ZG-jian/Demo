<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/7/11
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--需求：以 20%概率显示你中奖了。--%>
<%--原始标签不能嵌套--%>
<%
        int flag = new Random().nextInt(100);
        if (flag<=20){
%>
        中奖了！<%=flag%>
<% } else {%>
        抱歉没中奖，请再试一试<%=flag%>
<%}%>
</body>
</html>
