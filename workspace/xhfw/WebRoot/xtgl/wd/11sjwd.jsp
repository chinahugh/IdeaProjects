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
			auto:false,
			onUploadSuccess:uploadifySuccess				
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
			<li><a class="edit" href="wd/view/{sid_user}-${fid}" target="navTab"><span>查看</span></a></li>
			<li><a class="add"  href="wd/add?bh=${param.bh}&ml=${param.ml}" target="navTab"  rel="wdadd" mask="true"" ><span>添加</span></a></li>
			<li><a class="delete" href="wd/delete/{sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="wd/edit/{sid_user}?fid=${fid}" target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			
					</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th >名称</th>
				<th >文件</th>
				<th >大小</th>
				<th >描述</th>
			</tr>
		</thead>
		<tbody><%boolean isEvenLine = false;%> 
			<c:forEach items="${page.list}" var="o">
			<tr target="sid_user" rel="${o.id}" ondblclick="view('wd/view/${o.id}')" class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
				<td style="text-align:left;">${o.mc}</td>
				<td style="text-align:left;"><a herf="${o.attachmentPath}"  target="_blank">${o.fileName}</a></td>
				<td style="text-align:left;">${o.attachmentSize}</td>
				<td style="text-align:left;">${o.ms}</td>
			</tr><%isEvenLine=!isEvenLine; %>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="${page.pageSize}" ></option><option value="20" ${page.pageSize==20?"selected":""}>20</option>
				<option value="50" ${page.pageSize==50?"selected":""}>50</option>
				<option value="100" ${page.pageSize==100?"selected":""}>100</option>
			</select>
			<span>条，共${page.totalPage}页 ${page.totalRow}条 </span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${page.totalRow }" numPerPage="${page.pageSize }" pageNumShown="${page.totalPage }" currentPage="${page.pageNumber }"></div>

	</div>
</div>
	<script type="text/javascript">

	function uploadifySuccess(file, data, response){
		 alert(3);
		 $("#sjBox").loadUrl('wd/sjwd?bh=${param.bh}&ml=${param.ml}',null,null ); 
	}
	
	　/***
	* uplaodify响应函数
	* 当相应不为false的时候，拼接回显图片的路径并显示图片
	*/
	function myUplaodifyComplete(event,queueId,fileObj,response,data){
	　　　　if(response != 'false'){
		 alert(3);
		 $("#sjBox").loadUrl('wd/sjwd?bh=${param.bh}&ml=${param.ml}',null,null ); 
	　　　　}
	　　}
	
	</script>
