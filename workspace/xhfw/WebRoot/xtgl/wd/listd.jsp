<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<HTML><HEAD><TITLE>weboffice演示页面</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="/weboffice/style.css" type=text/css rel=stylesheet>
<SCRIPT src="/weboffice/main.js" type=text/javascript></SCRIPT>
<!-- --------------------=== 调用Weboffice初始化方法 ===--------------------- -->
<SCRIPT language=javascript event=NotifyCtrlReady for=WebOffice1>
/****************************************************
*
*	在装载完Weboffice(执行<object>...</object>)
*	控件后执行 "WebOffice1_NotifyCtrlReady"方法
*
****************************************************/
   // WebOffice_Event_Flash("NotifyCtrlReady");
	WebOffice1_NotifyCtrlReady()
</SCRIPT>

<SCRIPT language=javascript event=NotifyWordEvent(eventname) for=WebOffice1>
<!--
WebOffice_Event_Flash("NotifyWordEvent");
 WebOffice1_NotifyWordEvent(eventname);
 
//-->
</SCRIPT>

<SCRIPT language=javascript event=NotifyToolBarClick(iIndex) for=WebOffice1>
<!--
  WebOffice_Event_Flash("NotifyToolBarClick");
 WebOffice1_NotifyToolBarClick(iIndex);
//-->
</SCRIPT>

<SCRIPT language=javascript>
/****************************************************
*
*		控件初始化WebOffice方法
*
****************************************************/
function WebOffice1_NotifyCtrlReady() {
	//document.all.WebOffice1.SetWindowText("授权XX(可通过接口自定义)", 0);
	//document.all.WebOffice1.OptionFlag |= 128;
	// 新建文档
	//document.all.WebOffice1.LoadOriginalFile("http://127.0.0.1/getdoc.asp?id=8", "doc");
	
	document.all.WebOffice1.LoadOriginalFile("${attachmentPath}", "${filename}");
	//spnWebOfficeInfo.innerText="----   您电脑上安装的WebOffice版本为:V" + document.all.WebOffice1.GetOcxVersion() +"\t\t\t本实例是根据版本V6044编写";
//function intoweb(path,lx) {
//	document.all.WebOffice1.LoadOriginalFile(path, lx);
	
//}
</SCRIPT>
<LINK href="/weboffice/style.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2900.5921" name=GENERATOR></HEAD>
<BODY style="BACKGROUND: #ccc" onunload="return window_onunload()">
<CENTER>
<DIV 
style="PADDING-RIGHT: 0px; PADDING-LEFT: 0px; BACKGROUND: #fff; PADDING-BOTTOM: 0px; MARGIN: -10px 0px 0px; WIDTH: 1024px; PADDING-TOP: 10px; HEIGHT: 750px" 
align=center>
<FORM name=myform>

<TABLE class=TableBlock width="90%">
  <TBODY>
  <TR>
<TD class=leftTableData vAlign=top width="15%">
      <DIV class=menuItem ">文档目录 </DIV>
      <DIV id=chc ><!-- ---------------=== 该处文件格式的value不可以自定义 ===------------------------- -->

<INPUT class=btn id=CreateFile  type=button value=新建文档 name=CreateFile> 

 
      </DIV>
      </TD>
    <TD class=TableData vAlign=top width="90%">
    	<!-- -----------------------------== 装载weboffice控件 ==--------------------------------- -->
      <SCRIPT src="/weboffice/LoadWebOffice.js"></SCRIPT>
			<!-- --------------------------------== 结束装载控件 ==----------------------------------- -->
			</TD></TR></TBODY></TABLE></FORM></DIV></CENTER></BODY></HTML>
