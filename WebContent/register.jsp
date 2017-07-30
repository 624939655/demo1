<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function check(){
	var name=document.getElementById("name").value;
	var url="AdminRegister?name="+name;
	xmlhttp =new XMLHttpRequest(); 
	xmlhttp.onreadystatechange=checkResult; //响应函数
	xmlhttp.open("POST",url,true);   //设置访问的页面
	xmlhttp.send(null);  //执行访问
}
function checkResult(){
	 if (xmlhttp.readyState==4 && xmlhttp.status==200)
		 document.getElementById('checkResult').innerHTML=xmlhttp.responseText;
}
function check1(){
	var str=document.getElementById("checkResult").innerText;
	if(str=="已经存在"){
		alert("用户名不可用");
		document.ThisForm.name.focus();
		return false;
	}
	return ture;
}

</script>

<body>

<form action="RegisterSuccess" method="post" align='center' onsubmit="return check1()" name="ThisForm">
用户名:<input type="text" name="name" onkeyup="check()" id="name">
<span id="checkResult"></span><br>
密码:<input type="password" name="password"><br>
<input type="submit" value="注册">
</form>
</body>
</html>