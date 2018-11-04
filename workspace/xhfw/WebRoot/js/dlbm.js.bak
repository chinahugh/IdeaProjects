//身份证校验
function isIdCardNo(num)
{
var len=num.length,re;
if(len==15){
if(isNaN(num)){alert("输入的不是数字！");return false;}
re=new RegExp(/^(\d{6})()?(\d{2})(\d{2})(\d{2})(\d{3})$/);
}else if(len==18){
var  str=num+'';
str=str.substring(0,17);
if(isNaN(str)){alert(str+"输入的不是数字！");return false;}
re=new RegExp(/^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\d|[X])$/);
}else{alert("输入的数字位数不对！");return false;}
var a=num.match(re);
if(a!=null)
{
if(len==15)
{
var D=new Date("19"+a[3]+"/"+a[4]+"/"+a[5]);
var B=D.getYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
}
else
{
var D=new Date(a[3]+"/"+a[4]+"/"+a[5]);
var B=D.getFullYear()==a[3]&&(D.getMonth()+1)==a[4]&&D.getDate()==a[5];
}
if(!B){alert("输入的身份证号"+a[0]+"里出生日期不对！");return false;}
}
return true;
}
//非法字符校验
function isTchars(s) 
{ 
var patrn=/^[^`~!@#$%^&*()+=|\\\][\]\{\}:;'\,.<>/?]{1}[^`~!@$%^&()+=|\\\] [\]\{\}:;'\,.<>?]{0,19}$/; 
if(!patrn.exec(s))return false 
return true 
} 
//是否是数字
function isNumber(str) {
	var regexp=/^(\d+)$/;
	return regexp.test(str);
}
//是否是汉字
function isUename(str) {
	var regexp=/[^\u4E00-\u9FA5]/; 
	return regexp.test(str);
}
function WebForm_OnSubmit() {
	
	 var userxmv=$('#userxm').val();
	 alert(userxmv);  alert(userxmv.length);
		if (userxmv.length<=1||userxmv.length>10){
			
        alert("请填写您的姓名！");
        $('#msg').html('"请填写您的姓名！');
		  // document.getElementById("msg").innerHTML = "请填写您的姓名！";
       
        return false;
      }else{
       if(isUename(userxmv)){
        alert("请填写您的姓名格式不对，输入汉字不带特殊符号或空格！");
        document.getElementById("msg").innerHTML = "请填写您的姓名格式不对，输入汉字不带特殊符号或空格！";
        
        return false;
       }
        }
		

//return true;
	return false;
}