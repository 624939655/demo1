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
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8839250167346098826L;

	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		response.setCharacterEncoding("Utf-8");
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		List<Admin>admins=new AdminDao().list();
		boolean flag=true;
		
		outer:
			while(flag){
				for(int i=0;i<admins.size();i++){
			    if(name.equals(admins.get(i).username)&&password.equals(admins.get(i).password)){
			    	System.out.println("name:"+admins.get(i).username);
				    System.out.println("password:"+admins.get(i).password);
			    	request.getSession().setAttribute("userName",name);
					response.sendRedirect("ListEmployee");
				    break outer;
			    }
				}
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().print("<script> alert(\"输入用户名或密码错误!\");history.go(-1) </script>");	
				flag=false;
				System.out.print("失败！");
			}
			
		/*if("admin".equals(name)&&"123".equals(password)){
			request.getSession().setAttribute("userName",name);
			response.sendRedirect("ListEmployee");
		}else{
			//request.getRequestDispatcher("failure.jsp").forward(request, response);
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print("<script> alert(\"输入用户名或密码错误!\");history.go(-1) </script>");	
		}*/
	}
}
