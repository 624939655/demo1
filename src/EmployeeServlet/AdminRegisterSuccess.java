package EmployeeServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AdminDao;
import bean.Admin;
@WebServlet("/RegisterSuccess")
public class AdminRegisterSuccess extends HttpServlet{

	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setCharacterEncoding("Utf-8");
		 
		Admin admin=new Admin();
		admin.setUsername(request.getParameter("name"));
		admin.setPassword(request.getParameter("password"));
		
		new AdminDao().add(admin);
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().print("<script> alert(\"×¢²á³É¹¦!\");location.assign('login.jsp');</script>");	
		//response.sendRedirect("login.jsp");
	}
}
