<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/9/29
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>信息管理系统界面</title>
    <%--页面分针 在不同的资源里引入不同的页面--%>
</head>
<frameset rows="*,31" cols="*" frameborder="no" border="0" framespacing="0">
    <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
        <frame src="left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
        <frame src="index.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
    </frameset>
    <frame src="footer.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" title="bottomFrame" />
</frameset>
<noframes><body>
</body></noframes>
</html>