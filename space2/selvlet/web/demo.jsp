<!doctype html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>setTable-发送表单</title>
    <script type="text/javascript">
        function checknum1(obj){
            var ck1 = obj.value;
            var pattern=/^\d+$/;
            if(ck1.match(pattern)===null){
                alert("请输入数字");
                document.getElementById("ro").value="";
                return false;
            }else{
                return true;
            }
        }
        function checknum2(obj){
            var ck2 = obj.value;
            var pattern=/^\d+$/;
            if(ck2.match(pattern)===null){
                alert("请输入数字");
                document.getElementById("co").value="";
                return false;
            }else{
                return true;
            }
        }
    </script>
</head>
<body>
<div align="center">
    <h1>自定义创建表格</h1>
    <form action="creatTable.jsp" method="post">
        请输出创建的行数：<input type="text" name="rows" id="ro" onblur="checknum1(this)"/><br/>
        请输入创建的列数：<input type="text" name="cols" id="co" onblur="checknum2(this)"/><br/>
        <input type="submit" value="提交">
        <input type="reset" value= "重置">

    </form>
</div>
</body>
</html>