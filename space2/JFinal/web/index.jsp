<%--
  Created by IntelliJ IDEA.
  User: hugh
  Date: 12/6/17
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>$Title$</title>
    <script src="Scripts/jquery-1.5.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        if(typeof FileReader === "undified") {
            alert("您老的浏览器不行了！");


        }

        function showDataByURL() {
            var resultFile = document.getElementById("fileDemo").files[0];
            if (resultFile) {
                var reader = new FileReader();
                reader.readAsDataURL(resultFile);
                reader.onload = function (e) {
                    var urlData = this.result;
                    document.getElementById("result").innerHTML += "<img src='" + urlData + "' alt='" + resultFile.name + "' />";
                };
            }
        }

        function showDataByBinaryString() {
            var resultFile = document.getElementById("fileDemo").files[0];
            if (resultFile) {
                var reader = new FileReader();
                //异步方式，不会影响主线程
                reader.readAsBinaryString(resultFile);
                reader.onload = function(e) {
                    var urlData = this.result;
                    document.getElementById("result").innerHTML += urlData;
                };
            }
        }

        function showDataByText() {
            var resultFile = document.getElementById("fileDemo").files[0];
            if (resultFile) {
                var reader = new FileReader();
                reader.readAsText(resultFile,'gb2312');
                reader.onload = function (e) {
                    var urlData = this.result;
                    document.getElementById("result").innerHTML += urlData;
                };
            }
        }

    </script>


  </head>
  <body>
  <input type="email" name="email" placeholder="请输入注册邮箱"/>

  <fieldset>
    <legend>表单演示：最新Opera浏览器支持效果良好</legend>
    <form action="" method="POST" id="form1" oninput="output.value=parseInt(range.value)">
      <%--<input type="text" autofocus="autofocus" required pattern="\d+" name="auto" placeholder="必填项测试" />--%>
      <input type="number" name="demoNumber" min="1" max="100" step="2" />
      <input type="email" placeholder="请输入邮箱" name="mail" />
      <input type="url" name="url" placeholder="输入正确的网址" />
      <br />
      日期：<input type="datetime" name="time" />
      颜色：<input type="color" name="color" /><br />
      <br />
      <input type="range" min="0" max="50" step="5" name="range" value="0" />
      <output name="output">0</output>
      <br />
      <input type="submit" value="提交表单" />
    </form>
    表单外的input标签：
    <input type="text" form="form1" name="demo" />
  </fieldset>

  <input type="file" name="fileDemo" id="fileDemo" multep/>
  <input type="button" value="readAsDataURL" id="readAsDataURL" onclick="showDataByURL();"/>
  <input type="button" value="readAsBinaryString"  id="readAsBinaryString" onclick="showDataByBinaryString();"/>
  <input type="button" value="readAsText"  id="readAsText" onclick="showDataByText();"/>
  <div id="result">
  </div>

  <div>
    <c:forEach items="${o}" var="o" ></c:forEach>

  </div>


  </body>
</html>
