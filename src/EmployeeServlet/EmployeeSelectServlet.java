package EmployeeServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmployeeDao;
import bean.Employee;
@WebServlet("/Select")
public class EmployeeSelectServlet extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws 
	ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("selectName");
		System.out.println(name);
		List<Employee> employees=new EmployeeDao().listName(name);
		for(int i=0;i<employees.size();i++){
			System.out.println("ÐÕÃû:"+employees.get(i).name+"number:"+employees.get(i).number);
		}
		request.setAttribute("employees",employees);
		request.getRequestDispatcher("listEmployee.jsp").forward(request, response);
	}

}
