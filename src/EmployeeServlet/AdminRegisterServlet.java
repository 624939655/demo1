package EmployeeServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.AdminDao;
import bean.Admin;

@WebServlet("/AdminRegister")
public class AdminRegisterServlet extends HttpServlet {

	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
	
		response.setCharacterEncoding("Utf-8");
		
		String name=request.getParameter("name");
		List<Admin>admins=new AdminDao().list();
		boolean flag=true;
		
		outer:
		while(flag){
				for(int i=0;i<admins.size();i++){
					if(name.equals(admins.get(i).username)){
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
