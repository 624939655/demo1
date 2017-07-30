package EmployeeServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.EmployeeDao;
import bean.Employee;
@WebServlet("/EmployeeRegister")
public class EmployeeRegisterServlet extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setCharacterEncoding("Utf-8");
		String number=request.getParameter("number");
		List<Employee>employees=new EmployeeDao().list();
		boolean flag=true;
		
		outer:
		while(flag){
			for(int i=0;i<employees.size();i++){
				if(number.equals(employees.get(i).number)){
					response.setContentType("text/html; charset=UTF-8");
					response.getWriter().print("<font color='red'>已经存在</font>");
					System.out.println("已经存在");
					break outer;
				}
			}
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print("<font color='green'>可以使用</font>");
			flag=false;
			System.out.println("可以使用");
	}

}
}
