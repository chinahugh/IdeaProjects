<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<HTML><HEAD><TITLE>weboffice��ʾҳ��</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="/weboffice/style.css" type=text/css rel=stylesheet>
<SCRIPT src="/weboffice/main.js" type=text/javascript></SCRIPT>
<!-- --------------------=== ����Weboffice��ʼ������ ===--------------------- -->
<SCRIPT language=javascript event=NotifyCtrlReady for=WebOffice1>
/****************************************************
*
*	��װ����Weboffice(ִ��<object>...</object>)
*	�ؼ���ִ�� "WebOffice1_NotifyCtrlReady"����
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
*		�ؼ���ʼ��WebOffice����
*
****************************************************/
function WebOffice1_NotifyCtrlReady() {
	//document.all.WebOffice1.SetWindowText("��ȨXX(��ͨ���ӿ��Զ���)", 0);
	//document.all.WebOffice1.OptionFlag |= 128;
	// �½��ĵ�
	//document.all.WebOffice1.LoadOriginalFile("http://127.0.0.1/getdoc.asp?id=8", "doc");
	
	document.all.WebOffice1.LoadOriginalFile("${attachmentPath}", "${filename}");
	//spnWebOfficeInfo.innerText="----   �������ϰ�װ��WebOffice�汾Ϊ:V" + document.all.WebOffice1.GetOcxVersion() +"\t\t\t��ʵ���Ǹ��ݰ汾V6044��д";
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
      <DIV class=menuItem ">�ĵ�Ŀ¼ </DIV>
      <DIV id=chc ><!-- ---------------=== �ô��ļ���ʽ��value�������Զ��� ===------------------------- -->

<INPUT class=btn id=CreateFile  type=button value=�½��ĵ� name=CreateFile> 

 
      </DIV>
      </TD>
    <TD class=TableData vAlign=top width="90%">
    	<!-- -----------------------------== װ��weboffice�ؼ� ==--------------------------------- -->
      <SCRIPT src="/weboffice/LoadWebOffice.js"></SCRIPT>
			<!-- --------------------------------== ����װ�ؿؼ� ==----------------------------------- -->
			</TD></TR></TBODY></TABLE></FORM></DIV></CENTER></BODY></HTML>
