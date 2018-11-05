<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宠物列表</title>
    <style>
        .addPet{
            border:1px solid red;
            height: 100px;
        }
    </style>
</head>
<body>
<a href="">添加宠物</a>
<div class="addPet">
    <form action="">
        宠物名称:<input type="text" placeholder="请输入宠物名称">
        <form action="">
            宠物图片:<input type="file">
        </form>
        <select name="" >
        </select>
        <select name="">
        </select>
        <select name="" >

        </select>
    </form>
</div>

<br/>
<c:forEach items="${pets}" var="pet">
    <hr/>
    <p>宠物名称：${pet.pName}</p>
    <p>宠物图片：<img src="${pet.photoUrls}" width="50px" height="50px" alt="未知错误"></p>
    <p>宠物类型：${pet.category.cName}</p>
    <p>宠物标签：${pet.tag.tName}</p>
    <p>当前状态：${pet.status}</p>
    <p><a href="">删除</a></p>
    <hr/>
</c:forEach>

</body>
</html>
