<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
function check1(){
	var str=document.getElementById("checkResult").innerText;
    if(document.ThisForm.name.value==""){
    	alert("姓名不能为空！");
    	document.ThisForm.name.focus();
    	return false;
    }
	if(document.ThisForm.sex.value!="男"&&document.ThisForm.sex.value!="女"){
		alert("性别输入有误！");
		document.ThisForm.sex.focus();
		return false;
	}
	if(str=="已经存在"){
		alert("number不可用");
		document.ThisForm.number.focus();
		return false;
	}
	return true;
}
 function check(){
	 var number=document.getElementById("number").value;
	 var url="EmployeeRegister?number="+number;
	 xmlhttp =new XMLHttpRequest(); 
	 xmlhttp.onreadystatechange=checkResult; //响应函数
	 xmlhttp.open("POST",url,true);   //设置访问的页面
	 xmlhttp.send(null);  //执行访问
 }
 function checkResult(){
	 if (xmlhttp.readyState==4 && xmlhttp.status==200)
			 document.getElementById('checkResult').innerHTML=xmlhttp.responseText;
 }
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加</title>
</head>
<body>
<form action="AddEmployee" method="post" name="ThisForm" onsubmit="return check1()">
名字 ： <input type="text" name="name"> <br>
性别 ： <input type="text" name="sex"> <br>
编号： <input type="text" name="number"  onkeyup="check()" id="number">
     <span id="checkResult"></span><br>
     <input type="submit" value="增加 ">
</form>
</body>
</html>