<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录界面</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<a href="/page/reg">用户注册</a>
<form action="/user/login" method="post">
    <input type="text" name="username" placeholder="请输入账号"><br/>
    <input type="password" name="password" placeholder="请输入密码"><br/>
    <input type="submit" value="登录">
</form>

<div class="error">
    <p>${msg}</p>
</div>
</body>
</html>
