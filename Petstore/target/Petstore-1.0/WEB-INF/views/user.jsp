<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用 户 注 册</title>
    <style>
        .success{
            color: red;
        }

    </style>
</head>
<body>
用户注册页面：
    <form action="/user" method="post" >
        <input type="text" name="userName" placeholder="请输入账号"><br/>
        <input type="password" name="password" placeholder="请输入密码"><br/>
        <input type="text" name="firstName" placeholder="请输入姓氏"><br/>
        <input type="text" name="lastName" placeholder="请输入名字"><br/>
        <input type="text" name="email" placeholder="请输入邮箱"><br/>
        <input type="text" name="phone" placeholder="请输入您的电话号码"><br/>
        <input type="submit" value="注册" />
    </form>
    <div>
        <p class="success">${msg}</p>
    </div>
</body>
</html>
