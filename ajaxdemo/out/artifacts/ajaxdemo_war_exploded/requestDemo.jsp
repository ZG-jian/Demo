<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/10/2
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script>
        function but() {
            var id = document.getElementById("userid").value;
            var name = document.getElementById("username").value;
            //转换的数据格式必须是JavaScript对象结构的才可以
            //下面的属性名字就必须根要转换的对象的属性名相同，就是Users类里面的属性名
            var obj = {userid:id,username:name};
            var content = JSON.stringify(obj);
            alert(content);
            var xhr = new XMLHttpRequest();
            xhr.open("post","json.do");
            xhr.send(content);
            /*通过回调调用函数完成结果的处理*/
            xhr.onreadystatechange = function () {
                /*我们更关注的是服务端（这个servlet）有响应返回的时候，我们再去处理结果集*/
                if (xhr.readyState==4&&xhr.status==200){
                    alert(xhr.responseText);
                    document.getElementById("span").innerHTML = xhr.responseText;
                }
            }
        }
    </script>
</head>
<body>
<h3>在请求中通过JSON格式传递数据</h3>
<hr/>
<%--不用放到form表单里，form表单里就是同步的submit提交了，不是异步--%>
用户ID：<input name="userid" id="userid" /><br/>
用户姓名：<input name="username" id="username"/><br/>
<span id="span"></span>
<input type="button" value="OK" onclick="but()"/>
</body>
</html>
