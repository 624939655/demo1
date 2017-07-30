<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>editEmployee</title>
</head>
<body>
<form action="UpdateEmployee" method="post">
名字  <input type="text" name="name" value="${employee.name}"> <br>
性别  <input type="text" name="sex"  value="${employee.sex}"> <br>
编号  <input type="text" name="number" value="${employee.number}"> <br>
     <input type="hidden" name="id" value="${employee.id}"><br>    
     <input type="submit" value="更新 ">        
</form>
</body>
</html>