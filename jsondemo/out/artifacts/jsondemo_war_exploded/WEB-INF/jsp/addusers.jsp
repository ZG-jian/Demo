<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/8/16
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--还有，引入js不能一个标签即开始又结束--%>
    <script src="/js/jquery.js"></script>
    <script>
        $(function () {
            $("#but").click(function () {
                var name = $("#username").val();
                var age = $("#userage").val();
                var obj = {
                  username:name,
                  userage:age
                };
                var user = JSON.stringify(obj);

                /*发送异步请求 */
                $.ajax({
                    url:"http://127.0.0.1:8080/user/addUsers",
                    contentType:"application/json",
                    type:"post",
                    data:user,
                    success:function (res) {
                        $("#username").val(res.username);
                        $("#userage").val(res.userage);                    }
                });

            })
        });
    </script>
</head>
<body>
    <%--异步提交就不要form表单了--%>
    用户姓名：<input type="text" id="username"/><br/>
    用户年龄：<input type="text" id="userage"/><br/>
<input type="button" value="OK" id="but"/>
</body>
</html>
