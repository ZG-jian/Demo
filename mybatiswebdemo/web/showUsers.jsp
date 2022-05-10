<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/8/2
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示查询结果</title>
    <script>
        function subForm(pageIndex){
            document.getElementById("pageIndex").value = pageIndex;
            /*提交表单*/
            document.forms[0].submit();
        }
    </script>
</head>
<body>
        <form action="usersServlet.do" method="post">
            <input type="hidden" name="flag" value="findUsers"/>
            <%--这个是取页码的，得跟servlet里一样--%>
            <input type="hidden" name="pageIndex" id="pageIndex"/>
             <input type="hidden" name="username" value="${users.username}"/>
             <input type="hidden" name="usersex" value="${users.usersex}"/>
        </form>
        <table align="center" border="1" width="40%">
            <tr>
                <th>用户ID</th>
                <th>用户姓名</th>
                <th>用户性别</th>
            </tr>
            <c:forEach items="${pageInfo.list}" var="users">
            <tr>
                <td>${users.userid}</td>
                <td>${users.username}</td>
                <td>${users.usersex}</td>
            </tr>
            </c:forEach>
            <tr>
                <%--a标签中的href的#好表示不发送请求--%>
                <td colspan="3" align="center">
                    <c:if test="${pageInfo.pageNum > 1}">
                        <a href="#" onclick="subForm(${pageInfo.pageNum -1})">上一页</a>
                    </c:if>
                    <c:forEach begin="1" end="${pageInfo.pages}" varStatus="st">
                        <c:choose>
                            <c:when test="${pageInfo.pageNum eq st.count}">
                                <a style="color: aqua" href="#" onclick="subForm(${st.count})">${st.count}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="#" onclick="subForm(${st.count})">${st.count}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pageInfo.pageNum < pageInfo.pages}">
                        <a href="#" onclick="subForm(${pageInfo.pageNum +1})">下一页</a>
                    </c:if>
                </td>
            </tr>
        </table>
</body>
</html>
