<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="shadowbox-3.0.3/shadowbox.js" charset="UTF-8"></script>
	<script type="text/javascript">


	//初始化看圖組件Shadowbox
	function initShadowbox(){
		Shadowbox.init({
			language: 'en',
			players:  ['img', 'html', 'iframe', 'qt', 'wmp', 'swf', 'flv','jpg'],
//		     handleOversize: "drag",//当图片过大的时候，可以腿拽  
//	 		   handleOversize: "none",//当图片过大的时候，不显示多余的部分  
			   handleOversize: "resize",//默认:自动调整图片大小  
			    modal:false//true:鼠标点击非图片区域无反应 false:鼠标点击非图片区域图片效果消失    
			   
		});
	};

	</script>
<div class="pageHeader">

	<input type="hidden" name="bh" value="${param.bh}">	
	<input type="hidden" name="ml" value="${param.ml}">	
		<input type="hidden" name="status" value="${param.status}">	
		<input type="hidden" name="pageNum" value="${page.pageNumber }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize }" />
		<input type="hidden" name="orderField" value="${param.orderField}" />




	


</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
				<li class="line">line</li>
				<li><a class="edit"  href="wd/listp?bh=${param.bh}&ml=${param.ml}"  target="_blank"  title="图片列表"><span>图片列表</span></a></li>

			
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
			<c:forEach items="${list}" var="o">
			<tr target="sid_user" rel="${o.id}"  class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
				
				<td style="text-align:left;"><a href="${o.attachmentPath}"  class="item_anchor" alt="none" rel="shadowbox[${o.id }]">${o.fileName}</a>
	
				</td>
				<td style="text-align:left;">${o.attachmentSize}</td>
				
			</tr><%isEvenLine=!isEvenLine; %>
			</c:forEach>
		</tbody>
	</table>

		
		
	</div>
</div>

