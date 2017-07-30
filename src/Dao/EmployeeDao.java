package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Employee;

public class EmployeeDao {

	
	public EmployeeDao(){
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
}
 public Connection getConnection() throws SQLException{
	return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeedemo?characterEncoding=UTF-8","root","admin");
}


 public int getTotal(){
	int total=0;
	try(Connection c=getConnection();Statement s=c.createStatement();){
		
		String sql="select count(*) from employee";
		
		ResultSet rs=s.executeQuery(sql);
		while(rs.next()){
			total=rs.getInt(1);
		}
		
		System.out.println("total:"+total);
	    s.close();
		c.close();
	
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	return total;

 }

public void add(Employee employee){
	String sql="insert into employee values(null,?,?,?)";
	try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
		ps.setString(1,employee.name);
		ps.setString(2,employee.sex);
		ps.setString(3,employee.number);
        ps.execute();
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next()){
        	int id=rs.getInt(1);
        	employee.id=id;
        }
        ps.close();
        c.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
}

public void delete(int id){
	try(Connection c=getConnection();Statement s=c.createStatement();){
		String sql="delete from employee where id="+id;
		s.execute(sql);
		
		s.close();
		c.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
	
}

public void update(Employee employee){
	String sql="update employee set name=?,sex=?,number=? where id=?";
	try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
		ps.setString(1,employee.name);
		ps.setString(2,employee.sex);
		ps.setString(3,employee.number);
		ps.setInt(4,employee.id);
		ps.execute();
		
		ps.close();
		c.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
}

public Employee get(int id){
	Employee employee=null;
	try(Connection c=getConnection();Statement s=c.createStatement();){
		String sql="select * from employee where id="+id;
		ResultSet rs=s.executeQuery(sql);
		if(rs.next()){
			employee=new Employee();
			String name=rs.getString(2);
			String sex=rs.getString(3);
			String number=rs.getString(4);
			employee.name=name;
			employee.sex=sex;
			employee.number=number;
		    employee.id=id;
		}
		
		s.close();
		c.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return employee;
}

public List<Employee>list(){
	return list(0,Short.MAX_VALUE);
}
public List<Employee> list(int start,int count) {
	List<Employee> employees=new ArrayList<Employee>();
	String sql="select *from employee order by id desc limit ?,?";
	try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
		ps.setInt(1,start);
		ps.setInt(2, count);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Employee employee=new Employee();
			int id=rs.getInt(1);
			String name=rs.getString(2);
			String sex=rs.getString(3);
			String number=rs.getString(4);
			employee.id=id;
			employee.name=name;
			employee.sex=sex;
			employee.number=number;
			employees.add(employee);
		}
		
		ps.close();
		c.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return employees;
}
//***************************************
public List<Employee> listName(String selectName){
	
	List<Employee> employees=new ArrayList<Employee>();
	String sql="select *from employee where name='"+ selectName+"'";
	System.out.println(sql);
	try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql)){
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			Employee employee=new Employee();
			String name=rs.getString(2);
			String sex=rs.getString(3);
			String number=rs.getString(4);
			int id=rs.getInt(1);
			employee.id=id;
			employee.name=name;
			employee.sex=sex;
			employee.number=number;
			employees.add(employee);
		}
		ps.close();
		c.close();
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	return employees;
	
}
}
