package EmployeeServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmployeeDao;
import bean.Employee;
@WebServlet("/AddEmployee")
public class EmployeeAddServlet extends HttpServlet {
    public void service(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
    	request.setCharacterEncoding("UTF-8");
    	 
    	Employee employee=new Employee();
    	employee.setName(request.getParameter("name"));
    	employee.setSex(request.getParameter("sex"));
    	employee.setNumber(request.getParameter("number"));
    	
    	new EmployeeDao().add(employee);
    	response.sendRedirect("ListEmployee");
    }
}
