<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>宠物列表</title>
    <style>
        .addPet {
            border: 1px solid red;
            height: 100px;
        }

        .addPetimg {
            position: absolute;
            top: 30px;
            right: 400px;
        }

        .update_pet {
            border: 1px solid red;
            height: 200px;
            margin: auto;
            width: 400px;
        }

        .update_pet > .div1 {
            width: 260px;
            float: left;
        }
    </style>
</head>
<body>
<a href="#" onclick="none(this)">添加宠物</a>

<div class="addPet" style="display:none">

    <form id="myFormPet" action="/pet" method="post">
        宠物名称:<input type="text" name="pName" placeholder="请输入宠物名称"/>
        宠物类型:
        <select name="cId">
            <c:forEach items="${type}" var="ty">
                <option value="${ty.cId}">${ty.cName}</option>
            </c:forEach>
        </select>
        宠物标签：
        <select name="tId">
            <c:forEach items="${tags}" var="tag">
                <option value="${tag.tId}">${tag.tName}</option>
            </c:forEach>
        </select>
        状态:
        <select name="status">
            <option value="available">available</option>
            <option value="pending">pending</option>
            <option value="sold">sold</option>
        </select>
        <%--将图片的地址存储在这里--%>
        <input type="hidden" name="photoUrls"/>

        <input type="button" onclick="btn_add_pet(this)" value="添加"/>
    </form>

    <form action="#" id="uploadPic" enctype="multipart/form-data">
        宠物图片:<input type="file" name="filename"/>
        <input type="button" id="btn_upload" value="上传"/>
    </form>

    <span style="color: red">${error}</span>

    <img class="addPetimg" src="" width="100px" height="100px" alt="未上传">

</div>

<br/>
<c:forEach items="${pets}" var="pet">
    <hr/>
    <p>宠物名称：${pet.pName}</p>
    <p>宠物图片：<img src="${pet.photoUrls}" width="50px" height="50px" alt="未知错误"></p>
    <p>宠物类型：${pet.category.cName}</p>
    <p>宠物标签：${pet.tag.tName}</p>
    <p>当前状态：${pet.status}</p>
    <p><a href="/pet/del/${pet.pId}">删除</a> <a href="#" id="btn_update" update_id="${pet.pId}">修改</a></p>
    <hr/>
</c:forEach>
<br/>

<div style="display: none" class="update_pet">
    <div class="div1">
        <p>宠物名称: <input type="text" id="pName" ></p>
        <p>
            宠物类型:
            <select id="pet_type">
                <c:forEach items="${type}" var="ty">
                    <option value="${ty.cId}">${ty.cName}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            宠物标签:
            <select id="pet_tag">
                <c:forEach items="${tags}" var="tag">
                    <option value="${tag.tId}">${tag.tName}</option>
                </c:forEach>
            </select>
        </p>
        <p>
            当前状态:
            <select id="pet_status">
                <option value="available">available</option>
                <option value="pending">pending</option>
                <option value="sold">sold</option>
            </select>
        </p>

        <form action="" method="post" enctype="multipart/form-data">
            <p>
                宠物图片: <input type="file" style="width: 70px">
                <input type="submit" value="上传">
            </p>
        </form>
    </div>

    <img style="margin-top: 50px" class="update_img" src="" width="100px" height="100px" alt="未上传图片">

     <input style="margin-top: 20px;margin-left: 40px" type="button" value="修改">
</div>

<script src="${pageContext.request.contextPath}/js/jquery-1.12.3.js"></script>
<script>

    var i = 1;

    function none(x) {

        if (i % 2 != 0) {
            $(".addPet").attr("style", "");
            i++;
        } else {
            $(".addPet").attr("style", "display:none");
            i = 1;
        }
    }

    function btn_add_pet(x) {
        var name = $("input[name='pName']").val();
        var imgFile = $("input[name='photoUrls']").val();
        if (imgFile == "") {
            if (confirm("宠物图片未上传，是否还要进行添加？")) {
                $("#myFormPet").submit();
            } else {
                return false;
            }
        }

        if (name == "") {
            alert("兄弟给这只宠物起个名呗!!");
            return false;
        }

        $("#myFormPet").submit();
    };

    $("#btn_upload").click(function () {
        var isFIle = $("input[name='filename']").val();
        if (isFIle == "") {
            alert("请选择一张图片，然后再进行上传!");
            return false;
        }
        var formData = new FormData($("#uploadPic")[0]);
        $.ajax({
            type: "POST",
            url: "/imgUpload",
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                $(".addPetimg").attr("src", data.img_src);
                $("input[name='photoUrls']").val(data.img_src);
            },
            error: function (data) {
                alert("error:" + data.responseText);
            }
        });
    });

    //修改标签
    $("body").on("click","#btn_update",function () {
        //显示
        $(".update_pet").attr("style","");
        //取到宠物编号
        var pid = $(this).attr("update_id");
        //根据编号渲染数据
        $.get("/pet/update",{pid:pid},function (data) {
            $("#pName").val(data.pName);
            $("#pet_type option[value="+data.category.cId+"]").attr("selected","selected");
            $("#pet_tag option[value="+data.tag.tId+"]").attr("selected","selected");
            $("#pet_status option[value="+data.status+"]").attr("selected","selected");
            $(".update_img").attr("src",data.photoUrls);
        });
    })
    //修改按钮




</script>
</body>
</html>
