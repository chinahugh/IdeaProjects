<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<div class="pageContent">
	<form id="pagerForm" method="post" action="barcodeprint/print" target="navTab" onsubmit="return navTabSearch(this);">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<legend>条码信息</legend>
				<dl>
					<dt>物料号：</dt>
					<dd>
						<input name="barcodeprint.wlh" readonly="readonly" size="30" value="${barcodeprint.wlh}" />
					</dd>
				</dl>
				<dl>
					<dt>物料图号：</dt>
					<dd>
						<input name="barcodeprint.wlth" readonly="readonly" size="30" value="${barcodeprint.wlth}" />
					</dd>
				</dl>
				<dl>
					<dt>规格型号：</dt>
					<dd>
						<input name="barcodeprint.ggxh" readonly="readonly" size="30" value="${barcodeprint.ggxh}" />
					</dd>
				</dl>
				<dl>
					<dt>条码份数：</dt>
					<dd>
						<input name="value" class="required" type="text" size="30" />
					</dd>
				</dl>
				<input name="id" type="hidden" value="${barcodeprint.id}"  type="text" size="30" />
			</fieldset>
			<fieldset>
				<legend>条码打印配置</legend>
				<dl>
					<dt>条码字体：</dt>
					<dd>
						<select class="combox" name="gfont" class="required" >
							<option value="">所有字体</option>
							<option value="黑体">黑体</option>
							<option value="宋体">宋体</option>
						</select>
					</dd>
				</dl><br><br><br>
				<dl>
					<dt>条码标题字体：</dt>
					<dd>
						<select class="combox" name="tfont" class="required" >
							<option value="">所有字体</option>
							<option value="黑体">黑体</option>
							<option value="宋体">宋体</option>
						</select>
					</dd>
				</dl><br><br><br>
				<dl>
					<dt>条码宽度：</dt>
					<dd>
						<input name="width" class="required" type="text" size="30" value="900" />
					</dd>
				</dl><br><br><br>
				<dl>
					<dt>条码高度：</dt>
					<dd>
						<input name="height" class="required" type="text" size="30" value="100" />
					</dd>
				</dl><br><br><br>
			</fieldset>
			<fieldset>
				<legend>打印排版设置</legend>
				<dl>
					<dt>条码方式：</dt>
					<dd>
						<input name="cpjcjd.mc" class="required" size="15" value="${cpjcjd.mc}" />
					</dd>
					<a class="btnLook" href="treeDYLoop?a=tmids&b=mc" lookupGroup="cpjcjd">查找带回</a>
				</dl><br><br><br>
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