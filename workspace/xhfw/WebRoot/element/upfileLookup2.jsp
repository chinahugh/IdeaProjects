<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>西安铁路信号有限公司产品防伪系统</title>

<link href="../themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="../themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="../themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="../uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
	<style type="text/css">
		body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
		#l-map {height:100%;width:78%;float:left;border-right:2px solid #bcbcbc;}
		#r-result{height:100%;width:20%;float:left;}
	</style>


<script src="../js/dqxt.js" type="text/javascript"></script>

<h2 class="contentTitle">请选择需要上传的附件</h2>

<form name="uploadForm"  action="uploadfile/upAttachment" method="post" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="if(chkform()){iframeCallback(this, $.bringBack);window.setTimeout('setpicture()',1000);} else return false;">

<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>上传资料：</dt><dd><input type="file" name="fileName" id="fileName" class="required" size="30" /></dd>
		</dl>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit" >上传</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>
</form>
 <script language="javascript">
	function chkform()
	{
		
		var str = document.uploadForm.fileName.value; 
		if (str == "")
	    {
	    	return false;
	    }			  			  
		if (str != "")
	    {		                        
	    	var leg = str.length;
			var excel = str.substring(str.lastIndexOf(".")+1,leg);
			excel = excel.toLowerCase();		         
			excel = excel.toLowerCase();		       
			if (excel != "xls"&&excel !="xlsx")
			{
				alert("只能上传Excel文件！");
				document.uploadForm.fileName.focus();
				return false;
			}else{
				//alert(11);alert($("#pictureD").val());
				//$("#pictureD").html("<img  src='E:\\00\\11.png' width=\"100\" height=\"120\">");	
			    return true;
			}
	 	}
	//	alert($("#pictureD"));
		//$("#pictureD").html("<img  src=\""+str+"\" width=\"100\" height=\"120\">");	
        return false;
	}
	
	</script>  