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

@WebServlet("/ListEmployee")
public class EmployeeListServlet extends HttpServlet {
 public void service(HttpServletRequest request,HttpServletResponse response)
 throws ServletException,IOException{
	 
	 response.setCharacterEncoding("Utf-8");
	 
	 String userName=(String)request.getSession().getAttribute("userName");
	 
	 if(null==userName){
		 response.sendRedirect("login.jsp");
		 return;
	 }
	 
	 int start;
	 int count=5;
	 try{
		 start=Integer.parseInt(request.getParameter("start")); 
	 }catch(NumberFormatException e){
		 start=0;
		 System.out.println("≥ı ºªØstart="+start);
	 }
	 int next=start+count;
	 int pre=start-count;
	 
	 int total=new EmployeeDao().getTotal();
	 int last;
	 if(0==total%count){
		 last=total-count;
	 }else{
		 last=total-total%count;
	 }
	 
	 pre=pre<0?0:pre;
	 next=next>last?last:next;
	 
	 request.setAttribute("last",last);
	 request.setAttribute("next", next);
	 request.setAttribute("pre", pre);
	 
	 
	 List<Employee> employees=new EmployeeDao().list(start,count);
	 request.setAttribute("employees",employees);
	 request.getRequestDispatcher("listEmployee.jsp").forward(request, response);
 }
}
