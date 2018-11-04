<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style type="text/css" media="screen">
.my-uploadify-button {
	background:none;
	border: none;
	text-shadow: none;
	border-radius:0;
}

.uploadify:hover .my-uploadify-button {
	background:none;
	border: none;
}

.fileQueue {
	width: 400px;
	height: 100px;
	overflow: auto;
	border: 1px solid #E5E5E5;
	margin-bottom: 10px;
}
</style>
<div class="pageHeader">

	<input type="hidden" name="bh" value="${param.bh}">	
	<input type="hidden" name="ml" value="${param.ml}">	
		<input type="hidden" name="status" value="${param.status}">	
		<input type="hidden" name="pageNum" value="${page.pageNumber }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize }" />
		<input type="hidden" name="orderField" value="${param.orderField}" />

	<div class="divider"></div>

	<input id="testFileInput2" type="file" name="image2" 
		uploaderOption="{
			swf:'uploadify/scripts/uploadify.swf',
			uploader:'prouploadfile/up?bh=${param.bh}&ml=${param.ml}',
			formData:{},
			queueID:'fileQueue',
			buttonImage:'uploadify/img/add.jpg',
			buttonClass:'my-uploadify-button',
			width:102,
			multi:true,
			auto:false	
		}"
	/>
	
	<div id="fileQueue" class="fileQueue"></div>
	
	<input type="image" src="uploadify/img/upload.jpg" onclick="$('#testFileInput2').uploadify('upload', '*');"/>
	<input type="image" src="uploadify/img/cancel.jpg" onclick="$('#testFileInput2').uploadify('cancel', '*');"/>


	<div class="divider"></div>

</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit"  href="wd/sjwd?bh=${param.bh}&ml=${param.ml}" target='ajax' rel='sjBox'><span>刷新</span></a></li>
			<li><a class="delete" href="wd/delete/{sid_user}" target="ajaxTodo" rel='sjBox' title="确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			
					</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
			
				<th >文件</th>
				<th >大小</th>
				
			</tr>
		</thead>
		<tbody><%boolean isEvenLine = false;%> 
			<c:forEach items="${page.list}" var="o">
			<tr target="sid_user" rel="${o.id}"  class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
				
				<td style="text-align:left;"><a href="${o.attachmentPath}"  target="_blank">${o.fileName}</a></td>
				<td style="text-align:left;">${o.attachmentSize}</td>
				
			</tr><%isEvenLine=!isEvenLine; %>
			</c:forEach>
		</tbody>
	</table>

		
		<div class="pagination" targetType="navTab" totalCount="${page.totalRow }" numPerPage="${page.pageSize }" pageNumShown="${page.totalPage }" currentPage="${page.pageNumber }"></div>

	</div>
</div>
	<script type="text/javascript">

	function uploadifySuccess(){
		 alert(3);
		 $("#sjBox").loadUrl('wd/sjwd?bh=${param.bh}&ml=${param.ml}',null,null ); 
	}
	</script>
