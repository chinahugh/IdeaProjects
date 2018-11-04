<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="pageContent">
	<form method="get" action="barcode/print">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
				<legend>条码打印配置</legend>
				<dl>
					<dt>条码字体：</dt>
					<dd>
						<select class="" name="province">
							<option value="all">所有字体</option>
							<option value="bj">黑体</option>
							<option value="sh">宋体</option>
						</select>
					</dd>
				</dl>
				<dl>
					<dt>条码标题字体：</dt>
					<dd>
						<select class="" name="province"">
							<option value="all">所有字体</option>
							<option value="bj">黑体</option>
							<option value="sh">宋体</option>
						</select>
					</dd>
				</dl>
				<dl>
					<dt>条码宽度：</dt>
					<dd>
						<input name="whide" class="required" type="text" size="30"
							value="900" />
					</dd>
				</dl>
				<dl>
					<dt>条码高度：</dt>
					<dd>
						<input name="height" class="required" type="text" size="30"
							value="100" />
					</dd>
				</dl>


			</fieldset>
			<fieldset>
				<legend>打印排版设置</legend>
				<dl>
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
				</dl>
			</fieldset>
			<fieldset>
				<legend>打印人信息：</legend>
				<dl>
					<dt>工号：</dt>
					<dd>
						<input name="workerID" class="required" type="text" size="30" />
					</dd>
				</dl>
				<dl>
					<dt>姓名：</dt>
					<dd>
						<input name="workername" class="required" type="text" size="30" />
					</dd>
				</dl>
				<dl>
					<dt>日期：</dt>
					<dd>
						<input name="date" class="required" type="text" size="30" />
					</dd>
				</dl>

				<dl class="nowrap">
					<dt>备注：</dt>
					<dd>
						<textarea cols="100" rows="20" name="barcode.ms" value="本次打印原因"></textarea>
					</dd>
				</dl>
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