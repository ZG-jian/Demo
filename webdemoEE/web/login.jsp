<%--
  Created by IntelliJ IDEA.
  User: jianjian
  Date: 2021/9/29
  Time: 12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        if (window.parent.length>0){
            window.parent.location = "login.jsp";
        }
        $(function(){
            $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            $(window).resize(function(){
                $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
            })
        });
        function change() {
        /*取img标签让他重新请求就行*/
            $("#code").attr("src","validateCode.do?"+Math.random());
        }
    </script>

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <ul>
        <li><a href="#">回首页</a></li>
        <li><a href="#">帮助</a></li>
        <li><a href="#">关于</a></li>
    </ul>
</div>

<div class="loginbody">
    <%--EL表达式取值--%>
    ${msg}
    <div class="loginbox loginbox2">
        <%--表单提交的uri以及提交方式--%>
        <form action="login.do" method="post">
            <ul>
                <li><input name="username" type="text" class="loginuser" value="" onclick="JavaScript:this.value=''"/></li>
                <li><input name="userpwd" type="password" class="loginpwd" value="" onclick="JavaScript:this.value=''"/></li>
                <li class="yzm">
                    <span><input name="code" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite><img id="code" src="validateCode.do" onclick="change()"></cite>
                </li>
                <li><input name="" type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'"  /></li>
            </ul>
        </form>
    </div>

</div>
</body>

</html>
