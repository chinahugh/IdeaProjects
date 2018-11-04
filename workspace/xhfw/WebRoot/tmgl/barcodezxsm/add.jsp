<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<script type="text/javascript">
		function isEmpty() {
			 if ($("#tm1").value=="") {	
				$("#tm1").focus();
				return true;
			} else if ($("#tm2").val()=="") {
				$("#tm2").focus();
				return true;
			} else if ($("#tm3").val()=="") {
				$("#tm3").focus();
				return true;
			} else if ($("#tm4").val()=="") {
				$("#tm4").focus();
				return true;
			} else if ($("#tm5").val()=="") {
				$("#tm5").focus();
				return true;
			}  
			return false;
		}
		
		var msg='${msg}';
		 if(msg!=''){
			alertMsg.info(msg);
		}
		
</script>	

<div class="pageContent">
	<form id="tmform" method="post" action="barcodezxsm/save" class="pageForm required-validate"  onsubmit="if(isEmpty()){ return false; }else{return navTabSearch(this);}">
		<div class="pageFormContent" layoutH="56">
			<fieldset>
			<legend>装箱扫描基本信息</legend>
			<dl>
				<dt>条码1：</dt>
				<dd>
				<input name="barcode.tm1" type="text" size="30"  value="${barcode.tm1}" id="tm1" />
				</dd>
			</dl>
			<dl>
				<dt>条码2：</dt>
				<dd>
				<input name="barcode.tm2" type="text" size="30"  value="${barcode.tm2}" id="tm2" />
				</dd>
			</dl>
			<dl>
				<dt>条码3：</dt>
				<dd>
				<input name="barcode.tm3" type="text" size="30"  value="${barcode.tm3}"  id="tm3"/>
				</dd>
			</dl>
			<dl>
				<dt>条码4：</dt>
				<dd>
				<input name="barcode.tm4" type="text" size="30"  value="${barcode.tm4}"  id="tm4"/>
				</dd>
			</dl>
			<dl>
				<dt>条码5：</dt>
				<dd>
				<input name="barcode.tm5" type="text" size="30"  value="${barcode.tm5}"  id="tm5"/>
				</dd>
			</dl>
			</fieldset>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
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