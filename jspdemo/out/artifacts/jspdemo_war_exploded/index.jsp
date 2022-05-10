<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/7/11
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  Welcome JSP
  <%!
    int a = 10;
    int add(int a,int b){
      return a+b;
    }
  %>
  <%
    int b = 20;
  %>

  <%=a%>
  <%=b%>
  </body>
</html>
