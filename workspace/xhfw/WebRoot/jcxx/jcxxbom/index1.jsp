<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
</style>

<div >
	<div class="tabs">
		<!-- <div class="tabsHeader">
			<div class="tabsHeaderContent">
				<form id="pagerForm" action="jcxxbom/copy" rel="navTabId" method="post"  onsubmit="return validateCallback(this, navTabAjaxDone);">
					<input id='fid' type='hidden' name='fid' value=''/>
						<ul>
							<li><div class="buttonActive"><div class="buttonContent"><button>复制BOM</button></div></div></li>
						</ul>
				</form>
			</div>
		</div> -->
		<div class="tabsContent">
		
			<div>
			<div>
				<form id="pagerForm" action="jcxxbom/index1/${id}" rel="navTabId" method="post"  onsubmit="return navTabSearch(this);" >
					<table class="searchContent">
						<tr>
							<td>
								物料号：<input type="text" name="wlh" value="${param.wlh}" size="20" />
							</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td>
								<div class="buttonActive"><div class="buttonContent"><button>查询</button></div></div>
							</td>
						</tr>
					</table>
				</form>
		</div>
			<div layoutH="35" style="float:left; display:block; overflow:auto; width:600px; border:solid 1px #CCC; line-height:21px; background:#fff">
				   <ul class="tree treeFolder" >
								<li><a href="jcxxbom/list/${wlh}-${fid}-${bbh}" target='ajax' rel='jcxxbomBox1'>${wlh}-${bbh}-${wlms}</a>
			    						${tree }
								</li>
				    </ul>
			</div>
		<div layoutH="0"  id="jcxxbomBox1" class="unitBox" style="margin-left:246px;">
	</div>
</div>
</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent">
			</div>
		</div>
	</div>
</div>


	
