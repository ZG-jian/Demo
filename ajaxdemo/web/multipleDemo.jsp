<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/10/2
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>$Title$</title>
    <script>
        function but() {
            /*当我们一点这个按钮，向servlet发送请求，返回一个数据  hello Ajax局部更新*/
            var xhr = new XMLHttpRequest();
            xhr.open("get","multiple.do");
            xhr.send();
            /*通过回调调用函数完成结果的处理*/
            xhr.onreadystatechange = function () {
                /*我们更关注的是服务端（这个servlet）有响应返回的时候，我们再去处理结果集*/
                if (xhr.readyState==4&&xhr.status==200){
                    alert(xhr.responseText);
                    //通过Javascript的内置对象JSON的parse函数将JSON格式的字符串对象转换成Javascript的对象
                    var obj = JSON.parse(xhr.responseText);//这个obj放的就是数组了，数组里放的才是Javascript对象
                    var temp = "";
                    for ( i = 0; i < obj.length; i++) {
                        alert(obj[i].userid+" "+obj[i].username);
                        temp+=obj[i].userid+" "+obj[i].username+"<br/>"
                    }
                    document.getElementById("span").innerHTML = temp;//插入到html当中
                }
            }
        }
    </script>
</head>
<body>
<h3>JSON格式的多个对象的响应</h3>
<hr/>
<span id="span"></span>
<input type="button" value="OK" onclick="but()"/>
</body>
</html>
