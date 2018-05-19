<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pageHeader">
	<form  id="pagerForm" method="post" action="/xm1/list" onsubmit="return navTabSearch(this);"  >
		<input type="hidden" name="status" value="${param.status}">	
		<input type="hidden" name="pageNum" value="${page.pageNumber }" />
		<input type="hidden" name="numPerPage" value="${page.pageSize }" />
		<input type="hidden" name="orderField" value="${param.orderField}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					项目编码：<input type="text" name="keywords" value="${param.keywords}" size="20" />
					&nbsp;&nbsp;项目名称：<input type="text" name="keywords" value="${param.keywords}" size="20"> 			
					&nbsp;&nbsp;项目类型：<select><option value="">请选择</option>
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
			<li><a class="edit" href="/yajg/qcjg/"><span>查看</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="xm1/export" target="dwzExport"   title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th >项目编码</th>
				<th >项目名称</th>
				<th >申报单位</th>
				<th >申报日期</th>
				<th >截止日期</th>
				<th >剩余时间</th>
				<th >审批部门</th>
				<th >状态</th>
				
				
				
				
				
			</tr>
		</thead>
		<tbody><%boolean isEvenLine = false;%> 
			<c:forEach items="${list}" var="o">
			<tr target="sid_user">
				<td style="text-align:left;">${o.xmbm}</td>
				<td style="text-align:left;">${o.xmmc}</td>
				<td style="text-align:left;">${o.sbdw}</td>
				<td style="text-align:left;">${o.sbrq}</td>
				<td style="text-align:left;">${o.jzrq}</td>
				<c:choose>

　　				<c:when test="${o.syts<4}"><td style="text-align:left;"><img src="xtgl/spqy/img/01.png" width="23" height="23"/><span style="position:relative;bottom:7px;left:9px;">${o.syts}<span/></td></c:when>

　　				<c:when test="${o.syts>6}"><td style="text-align:left;"><img src="xtgl/spqy/img/02.png" width="23" height="23"/><span style="position:relative;bottom:7px;left:9px;">${o.syts}<span/></td></c:when>

　　				<c:otherwise><td style="text-align:left;"><img src="xtgl/spqy/img/03.png" width="23" height="23"/><span style="position:relative;bottom:7px;left:9px;">${o.syts}<span/></td></c:otherwise>

				</c:choose>
				
				<td style="text-align:left;"><a href="http://www.w3school.com.cn">实时跟踪</a></td>
				<td style="text-align:left;">${o.zt}</td>
				
			</tr>
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
