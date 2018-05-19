<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<h2 class="contentTitle">请选择需要上传的附件</h2>

<form name="uploadForm"  action="uploadfile/upAttachment" method="post" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="if(chkform()){iframeCallback(this, $.bringBack);window.setTimeout('setpicture()',1000);} else return false;">

<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>图片：</dt><dd><input type="file" name="image" id="fileName" class="required" size="30" /></dd>
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
		
		var str = document.uploadForm.image.value; 
		if (str == "")
	    {
	    	return false;
	    }			  			  
		if (str != "")
	    {		                        
	    	var leg = str.length;
			var img = str.substring(str.lastIndexOf(".")+1,leg);
			img = img.toLowerCase();		         
			img = img.toLowerCase();		       
			if (img != "gif" && img != "jpg"&& img != "jpeg"&& img != "png"&& img != "bmp"&& img!= "pic")
			{
				alert("只能上传图片！");
				document.uploadForm.image.focus();
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