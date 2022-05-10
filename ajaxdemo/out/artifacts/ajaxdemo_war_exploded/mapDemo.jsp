<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/10/2
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script>
        function but() {
            /*当我们一点这个按钮，向servlet发送请求，返回一个数据  hello Ajax局部更新*/
            var xhr = new XMLHttpRequest();
            xhr.open("get","map.do");
            xhr.send();
            /*通过回调调用函数完成结果的处理*/
            xhr.onreadystatechange = function () {
                /*我们更关注的是服务端（这个servlet）有响应返回的时候，我们再去处理结果集*/
                if (xhr.readyState==4&&xhr.status==200){
                    alert(xhr.responseText);
                    //通过Javascript的内置对象JSON的parse函数将JSON格式的字符串对象转换成Javascript的对象
                    var obj = JSON.parse(xhr.responseText);
                    alert(obj.userid+" "+obj.url);
                    document.getElementById("span").innerHTML = obj.userid+"<br/>"+obj.url;
                }
            }
        }
    </script>
</head>
<body>
<h3>Map模型的使用</h3>
<hr/>
<span id="span"></span>
<input type="button" value="OK" onclick="but()"/>
</body>
</html>
