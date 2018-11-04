<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
</style>
<script type="text/javascript">
var msg='${msg}';
if(msg!=''){
	alertMsg.info(msg);
	setTimeout(function(){navTab.closeCurrentTab();}, 100);
}
</script>
<div >
	<div class="tabs">
		<!-- <div class="tabsHeader">
		</div> -->
		<div class="tabsContent">
		
			<div>
			<div>
				<%-- <form id="pagerForm" action="jcxxbom" rel="navTabId" method="post"  onsubmit="return navTabSearch(this);" >
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
				</form> --%>
		</div>
			<div layoutH="35" style="float:left; display:block; overflow:auto; width:550px; border:solid 1px #CCC; line-height:21px; background:#fff">
				   <ul class="tree treeFolder" >
						<li><a href="#" >${wlh}-${bbh}-${wlms}</a>
			    			${tree }
						</li>
				    </ul>
			</div>
		<div layoutH="0"  id="binding1" class="unitBox" style="margin-left:246px;">
		</div>
</div>
</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent">
			</div>
		</div>
	</div>
</div>


	
