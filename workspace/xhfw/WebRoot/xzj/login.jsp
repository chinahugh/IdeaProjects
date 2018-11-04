<%@ page language="java" import="javax.servlet.http.Cookie" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../css/login.css" />
		<title>西安铁路信号有限公司产品防伪系统</title>
		<SCRIPT>
function tocms(){
	if(document.LoginForm.yhid.value == ""||document.LoginForm.yhid.value == null)
	{
		alert("请输入用户名！");
		document.LoginForm.yhid.focus();
		return false;
	}

	if(document.LoginForm.yhmm.value == ""||document.LoginForm.yhmm.value == null)
	{
		alert("请输入密码！");
		document.LoginForm.yhmm.focus();
		return false;
	}
	

	 document.LoginForm.submit(); 	
}

 function getkey()   
  {   
  if(event.keyCode==13)   
  {   
  document.LoginForm.yhmm.focus();   
  }
  }
</SCRIPT>
<%
//session.invalidate();
Cookie[] cookies=request.getCookies(); 
String cookiename="";
if(cookies!=null)
{ System.out.println("cookies.length"+cookies.length);
for(int i=0;i<cookies.length;i++)
{System.out.println("cookies[i].getName()"+cookies[i].getName());
     if(cookies[i].getName().equals("clxtname"))
     {
    cookiename=cookies[i].getValue();
    break;
     } 
}
}
 %>
	</head>
	<body>
	<FORM method="post" name="LoginForm" action="manage">
		<div class="login">
			<p class="lg-bt">西安铁路信号有限公司产品防伪系统</p>
			<div class="log-form">
			
			<div class="cell">
				<label>用户名</label>
				<input class="text"  type="text" name="yhid" onKeyDown="getkey()"  value="<%=cookiename%>" />
			</div>
			<div class="cell">
				<label>密码</label>
				<input class="text"  onkeydown="if(event.keyCode==13) tocms();" 
                  type=password name="yhmm"  />
			</div>

			<div class="dlu">
				<a id=" " href="javascript: tocms();" class="button btn-green"> 登录</a>
				<a id=" " href="javascript:reset();" class="button btn-green"> 取消</a>
			</div>
		</div>
		</div>
		<SCRIPT>
${arletMsg}
</SCRIPT>
</FORM>
		<div class="lg-foot">
			<p>陕ICP备08101054号 xxxx 版权所有</p>
		</div>
	</body>
</html>

