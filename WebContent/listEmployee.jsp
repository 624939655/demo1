<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

 </script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EmployeeList</title>
</head>
<body>
 <script>
 $(function(){
	     $("a").addClass("btn btn-default btn-xs");
	      
	 });
 </script>
<table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover table-condensed" align='center' border='1' cellspacing='0'>
  <tr>
     <td>id</td>
     <td>name</td>
     <td>sex</td>
     <td>number</td>
     <td>编辑</td>
     <td>删除</td>
  </tr>
<c:forEach items="${employees}" var="employee" varStatus="st">
 <tr>
    <td>${employee.id}</td>
    <td>${employee.name}</td>
    <td>${employee.sex}</td>
    <td>${employee.number}</td>
    <td><a href="EditEmployee?id=${employee.id}">edit</a>
    <td><a href="DeleteEmployee?id=${employee.id}">delete</a></td>
    </tr>
 </c:forEach>
 <tr>
    <td colspan="6" align="center">
    <a href="addEmployee.jsp">增加</a>   
    <a href="select.jsp">查询</a>
 </tr>
</table>
<nav>
 <ul class="pager">
      <li><a href="ListEmployee?start=0">首  页</a></li>
      <li><a href="ListEmployee?start=${pre}">上一页</a></li>
      <li><a href="ListEmployee?start=${next}">下一页</a></li>
      <li><a href="ListEmployee?start=${last}">末  页</a></li>
 </ul>
</nav>
</body>
</html>