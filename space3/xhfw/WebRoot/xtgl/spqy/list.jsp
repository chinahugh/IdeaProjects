<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

$(function(){
	 //操作全选按钮开始
   $("#contentTable #allcheck").click(function () {
	   alert(2);
     if ($(this).attr('checked')) {
       $("#contentTable input[type='checkbox'][name*='childcheck']").each(function () {
         $(this).attr("checked", true);
         $(this).parent().parent().find("td").addClass("trred");
       });
     } else {
       $("#contentTable input[type='checkbox'][name*='childcheck']").each(function () {
         $(this).attr("checked", false);
         $(this).parent().parent().find("td").removeClass("trred");
       });
     }
   });
   $("#contentTable input[name*='childcheck']").click(function () {
     if ($(this).attr('checked')) {
       var v = true;
       $("#contentTable input[type='checkbox'][name*='childcheck']").each(
               function () {
                 if (!$(this).attr('checked')) {
                   v = false;
                 }
               });
       $("#contentTable #allcheck").attr("checked", v);
       $(this).parent().parent().find("td").addClass("trred");
     } else {
       $("#contentTable #allcheck").attr("checked", false);
       $(this).parent().parent().find("td").removeClass("trred");
     }
   });
   //操作全选按钮结束

});


</script>
<style>
table{
	width: 99% !important;
}
</style>
<div class="pageHeader">
	<form  id="pagerForm" method="post"  onsubmit="return navTabSearch(this);"  >
		<input type="hidden" name="status" value="${param.status}">	
		<input type="hidden" name="pageNum" value="${page.pageNumber }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize }" />
		<input type="hidden" name="orderField" value="${param.orderField}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					项目编码：<input type="text" name="keywords" value="${param.keywords}" size="20" />
					&nbsp;项目名称：<input type="text" name="keywords" value="${param.keywords}" size="20"> 			
					&nbsp;项目类型：<select><option value="">请选择</option>
						<option value="审批制">审批制</option>
						<option value="备案制">备案制</option>
						<option value="核准制">核准制</option>
						</select>
						
						&nbsp;&nbsp;审批部门：<select><option value="">全&nbsp;&nbsp;部</option>
	<option value="发改委">发&nbsp;改&nbsp;委</option>
	<option value="市国土局">市国土局</option>
	<option value="市规划局">市规划局</option>
	<option value="市财政局">市财政局</option>
	<option value="市环保局">市环保局</option>	
    </select>
    &nbsp;&nbsp;申报单位： <select><option value="">全&nbsp;&nbsp;部</option>
		       <option value="延安市宝塔区麻洞川乡人民政府">延安市宝塔区麻洞川乡人民政府</option>
		       <option value="延安市宝塔区南泥湾镇人民政府">延安市宝塔区南泥湾镇人民政府</option>
		       <option value="延安市宝塔区河庄坪镇人民政府">延安市宝塔区河庄坪镇人民政府</option>	       
		       </select>
    &nbsp;&nbsp;项目所属行业：<select><option value="">全&nbsp;&nbsp;部</option>
               <option value="产业类">产业类</option>
               <option value="基础功能类">基础功能类</option>
		       <option value="采掘业">采掘业</option>
		       <option value="基础工业及加工制造">基础工业及加工制造</option>
		       <option value="高新技术及新型产业">高新技术及新型产业</option>
		       <option value="旅游文化">旅游文化</option>
		       <option value="现代农业及深加工">现代农业及深加工</option>
		       </select>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button>查询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" href="/yajg/qcjg/" target="navTab"><span>查看</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="/yajg/yj1?type=msg" 
        target="dialog" rel="dlg_page7" mask="true"
        width="800" height="480">
        <span>消息提醒</span></a></li>
		</ul>
	</div>
	<table id="contentTable" class="table" width="100%" layoutH="168">
		<thead>
			<tr>
				<th style="text-align:center;"><input id="allcheck"  name="count" type="checkbox" value=""/></th>
				<th >项目编码</th>
				<th >项目名称</th>
				<th >申报单位</th>
				<c:if test="${type=='2'}">
				<th >审批部门</th>
				<th >剩余时间</th>
				<th >超期时间</th>
				<th >项目阶段</th>		
				</c:if>	
				<c:if test="${type=='1'}">
				<th >异常时间</th>
				<th >异常情况</th>		
				</c:if>	
			</tr>
		</thead>
		<tbody><%boolean isEvenLine = false;%> 
			
			<c:forEach items="${list}" var="o">
			<tr target="sid_user" class="<%=(isEvenLine) ? "tr2" : "tr1"%>">
		   		<td style="text-align:center;"><input id="childcheck" name="childcheck" type="checkbox" /></td>
				<td style="text-align:left;">
					
					<c:if test="${type=='2'}">
					<c:if test="${o.syts>=1}">
						<img src="xtgl/spqy/img/01.png" width="23" height="23"/>
					</c:if>
					<%-- <c:if test="${o.syts>100}">
						<img src="xtgl/spqy/img/03.png" width="23" height="23"/>
					</c:if> --%>
					<c:if test="${o.syts<=0}">
						<img src="xtgl/spqy/img/02.png" width="23" height="23"/>
					</c:if>
					</c:if>
					<c:if test="${type=='1'}">
						<c:if test="${o.syts>=4}">
						<img src="xtgl/spqy/img/01.png" width="23" height="23"/>
						</c:if>
						<c:if test="${o.syts<4}">
						<img src="xtgl/spqy/img/02.png" width="23" height="23"/>
						</c:if>
					</c:if>
					
				<span style="position:relative;bottom:7px;left:9px;">${o.xmbm}<span/></td>
				
				
				<c:if test="${type=='2'}">
				<td style="text-align:left;">${o.xmmc}</td>
				<td style="text-align:left;">${o.sbdw}</td>
				<td style="text-align:left;">${o.sbrq}</td>
				<td style="text-align:left;">${o.sysj}</td>
				<td style="text-align:left;">${o.syts}</td>
				<td style="text-align:left;"><a href="/yajg/gz1" target="navTab">实时跟踪</a></td>
				</c:if>
				<c:if test="${type=='1'}">
				<td style="text-align:left;"><a href="/yajg/de/2.jsp" target="navTab">${o.xmmc}</a></td>
				<td style="text-align:left;"><a href="/yajg/de/2.jsp" target="navTab">${o.sbdw}</a></td>
				<td>${o.jzrq}</td>
				<td>材料不全</td>		
				</c:if>	
				
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
