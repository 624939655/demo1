package EmployeeServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmployeeDao;
import bean.Employee;

@WebServlet("/EditEmployee")
public class EmployeeEditServlet extends HttpServlet{
 
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		 int id=Integer.parseInt(request.getParameter("id"));
		 
		 Employee employee=new EmployeeDao().get(id);
		  
		
		 
		 request.setAttribute("employee",employee);
		 request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
	}
}
