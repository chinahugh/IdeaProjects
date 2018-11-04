<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="barcode/print" onsubmit="return navTabSearch(this);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<legend>打印配置</legend>
				<fieldset>
					<legend>打印物料：</legend>
					<dl>
						<input name="" value="${jcxxindent.wl}" readonly="readonly" size="30">
					</dl>
					<dl>
						<input name="" value="${jcxxindent.wlms}" readonly="readonly" size="50">
					</dl>
					<dl>
						<input name="id" value="${jcxxindent.id}" type="hidden" readonly="readonly" size="5">
					</dl>
				</fieldset>
				<fieldset>
					<legend>条码配置：</legend>
					<dl>
						<dt>条码字体：</dt>
						<dd>
							<select class="combox" name="bf">
								<option value="">所有字体</option>
								<option value="黑体">黑体</option>
								<option value="宋体">宋体</option>
							</select>
						</dd>
					</dl><br><br><br>
					<dl>
						<dt>条码标题字体：</dt>
						<dd>
							<select class="combox" name="tf">
								<option value="">所有字体</option>
								<option value="黑体">黑体</option>
								<option value="宋体">宋体</option>
							</select>
						</dd>
					</dl><br><br><br>
					<dl>
						<dt>条码宽度：</dt>
						<dd>
							<input name="width" class="required" type="text" size="30" value="900" min="500" max="1500" />
						</dd>
					</dl><br><br><br>
					<dl>
						<dt>条码高度：</dt>
						<dd>
							<input name="height" class="required" type="text" size="30" value="100" min="50" max="150" />
						</dd>
					</dl><br><br><br>
					<dl>
						<dt>产品版本：</dt>
						<dd>
							<input name="cpjcjd.fid" class="required" type="text" size="15" value="${cpjcjd.mc}" /> <a class="btnLook"
								href="treeCpbbLoop?a=${jcxxindent.wl }" lookupGroup="cpjcjd">查找带回</a>
						</dd>
					</dl><br><br><br>
					<dl>
						<dt>条码方式：</dt>
						<dd>
							<input name="cpjcjd.mc" class="required" type="text" size="15" value="${cpjcjd.mc}" /> <a class="btnLook"
								href="treeDYLoop?a=tmids&b=mc" lookupGroup="cpjcjd">查找带回</a>
						</dd>
					</dl>
					<!-- 	<dl>
					<dt>条码列数：</dt>
					<dd>
						<input name="column" class="required" type="text" size="30"
							value="2" />
					</dd>
				</dl>
				<dl>
					<dt>条码份数：</dt>
					<dd>
						<input name="value" class="required" type="text" size="30"
							value="2" />
					</dd>
				</dl> -->
				</fieldset>
			</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">打印预览</button>
						</div>
					</div></li>
				<li>
					<div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>