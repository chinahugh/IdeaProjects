<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<form method="post" action="srcd/save" class="pageForm required-validate" onsubmit="return validateCallback(this)">					<!--#include virtual="list1.html" -->
<div layoutH="60" style=" float:left; display:block; margin:10px; overflow:auto; width:350px; height:500px; overflow:auto; border:solid 1px #CCC; line-height:21px; background:#FFF;">


<input name="srcd.id" type="hidden" size="30"  value="${id}" />

<ul  class="tree treeFolder treeCheck expand" >
						<li><a >系统角色菜单</a>
                        ${treeJSCDStr }
						</li>
</ul>


</div>	
<textarea rows="30" cols="8" readonly>${yhmcs}</textarea><br>
<input type="submit" value="提交"/>
</form>
	
