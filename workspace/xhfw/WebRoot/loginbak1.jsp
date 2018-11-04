<%@ page language="java" import="javax.servlet.http.Cookie" pageEncoding="gbk"%>
<%@ page contentType="text/html; charset=gbk" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<!-- saved from url=(0036)http://localhost:8000/cjxt/login.jsp -->
<HTML 
xmlns="http://www.w3.org/1999/xhtml"><HEAD><TITLE>延安市投资项目监管服务平台</TITLE>
<META content="text/html; charset=gb2312" http-equiv=Content-Type>
<STYLE>BODY {
	LINE-HEIGHT: 24px; WIDTH: 1000px; MARGIN-LEFT: auto; FONT-SIZE: 12px; MARGIN-RIGHT: auto
}
* {
	PADDING-BOTTOM: 0px; LIST-STYLE-TYPE: none; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; PADDING-TOP: 0px
}
.login {
	BACKGROUND-IMAGE: url(images/input.jpg); TEXT-ALIGN: center; BACKGROUND-REPEAT: no-repeat; HEIGHT: 210px
}
FORM {
	PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; PADDING-TOP: 0px
}
.ziti {
	MARGIN-TOP: 45px; FONT-FAMILY: "宋体"; COLOR: #070707; FONT-SIZE: 12px
}
.tc {
	PADDING-LEFT: 10px
}
.inputclass {
	BORDER-BOTTOM: #4aa0d3 1px groove; BORDER-LEFT: #4aa0d3 1px outset; WIDTH: 180px; HEIGHT: 18px; BORDER-TOP: #4aa0d3 1px outset; BORDER-RIGHT: #4aa0d3 1px groove
}
.inputclass1 {
	BORDER-BOTTOM: #4aa0d3 1px groove; BORDER-LEFT: #4aa0d3 1px outset; WIDTH: 80px; HEIGHT: 18px; BORDER-TOP: #4aa0d3 1px outset; BORDER-RIGHT: #4aa0d3 1px groove
}
.bianjie {
	MARGIN-TOP: -2px
}
.anniu {
	PADDING-LEFT: 57px
}
.righttc {
	PADDING-RIGHT: 55px
}
.youtc {
	PADDING-RIGHT: 5px
}
.jizhu {
	PADDING-RIGHT: 5px
}
.righttd {
	PADDING-RIGHT: 50px
}
.xit {
	COLOR: #000000; FONT-SIZE: 12px; TEXT-DECORATION: none
}
.STYLE1 {
	COLOR: #ff0000; FONT-SIZE: 12px
}
.zitise {
	COLOR: #ff0000; FONT-SIZE: 12px
}
</STYLE>

<SCRIPT>
function tocms(){
	if(document.LoginForm.yhid.value == ""||document.LoginForm.yhid.value == null)
	{
		alert("请输入用户名！");
		document.LoginForm.yhid.focus();
		return false;
	}
	
	//if(!(isspecial(document.LoginForm.yhid.value,"'~`"+
     // 	String.fromCharCode(34)+"@#$%^{}'<>")))
  //  {
     //   alert("用户名不能包含以下特殊字符，例如 ~`"+String.fromCharCode(34)+"@#$%^{}'<>等！");
     //   document.LoginForm.yhid.focus();
     //   return false;
   // }
	
	if(document.LoginForm.yhmm.value == ""||document.LoginForm.yhmm.value == null)
	{
		alert("请输入密码！");
		document.LoginForm.yhmm.focus();
		return false;
	}
	
	if(document.LoginForm.code.value == ""||document.LoginForm.code.value == null)
	{
		alert("请输入验证码！");
		document.LoginForm.code.focus();
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
<META name=GENERATOR ></HEAD>
<BODY>
<FORM method="post" name="LoginForm" action="manage">
<DIV align=center><IMG src="images/top.jpg" width=1000 height=229></DIV>
<TABLE border=0 cellSpacing=0 cellPadding=0 width=1000 align=center>
  <TBODY>
  <TR>
    <TD height=210 background=images/input.jpg>
      <TABLE class=ziti border=0 cellSpacing=0 cellPadding=0 width=1000
      align=center height=156>
        <TBODY>
        <TR>
          <TD width=400 align=right></TD>
          <TD width=600 align=left>
            <TABLE border=0 cellSpacing=0 cellPadding=0 width=301 height=70 align=left>
              <TBODY>
              <TR>
                <TD class=xit width=185 align=right>&nbsp;用户名 ：</TD>
                <TD colspan="2"  class="youtc">
                <input class="inputclass" type="text" name="yhid" onKeyDown="getkey()"  value="<%=cookiename%>" /></TD></TR>
              <TR>
                <TD class=xit align=right>&nbsp;密 &nbsp;码 ：</TD>
                <TD colspan="2"  class=youtc><INPUT 
                  onkeydown="if(event.keyCode==13) tocms();" class=inputclass 
                  type=password name=yhmm></TD></TR>
			   <TR>
                <TD class=xit align=right>&nbsp;验证码&nbsp;：</TD>
                <TD width="104" align=left class=youtc><INPUT 
                  onkeydown="if(event.keyCode==13) tocms();" class=inputclass1 
                   name=code></TD>
                <TD width="112" align=left class=youtc><img alt="" src="myimage.jsp" /></TD>
			   </TR>
			   	<TR>
                <TD class=xit align=middle>&nbsp;&nbsp;</TD>
                <TD width="104" align=left class=youtc><span class="zitise">${msg}</span></TD>
                <TD width="112" align=left class=youtc></TD>
			   </TR>
			</TBODY></TABLE></TD></TR>
        <TR>
          <TD height=32></TD>
          <TD vAlign=top   align=left >
            <TABLE border=0 cellSpacing=0 cellPadding=0 width=285  align=left >
              <TBODY>
              <TR>
                <TD class=anniu height=28 width=133 align=left><INPUT 
                  onclick= "return tocms();" src="images/login.jpg" 
                  type=image name=imageField></TD>
                <TD class=righttd height=28 width=226><INPUT 
                  onclick=javascript:reset(); src="images/asd.jpg" 
                  type=image name=imageField2></TD></TR></TBODY></TABLE></TD></TR>
        <TR>
          </TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
<DIV class=bianjie align=center><IMG src="images/111.jpg"></DIV>
<SCRIPT>
${arletMsg}
</SCRIPT>
</FORM></BODY></HTML>
