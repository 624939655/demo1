package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import bean.Admin;

public class AdminDao {

	public AdminDao(){
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
		
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employeedemo?characterEncoding=UTF-8","root","admin");
	}
	
	public int getTotal(){
		int total = 0;
		try(Connection c=getConnection();Statement s=c.createStatement();){
			String sql="slect count(*) from admin";
			ResultSet rs=s.executeQuery(sql);
			while(rs.next()){
				total=rs.getInt(1);
			}
			
			System.out.println("total="+total);
			s.close();
			c.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return total;
	}
	public void add(Admin admin){
		String sql="insert into admin values(null,?,?)";
		try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql);){
			ps.setString(1,admin.username);
			ps.setString(2,admin.password);
			ps.execute();
			
			ResultSet rs=ps.getGeneratedKeys();
			if(rs.next()){
				int id=rs.getInt(1);
				admin.id=id;
			}
			ps.close();
			c.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public List<Admin> list(){
		return list(0,Short.MAX_VALUE);
	}

	private List<Admin> list(int start, int count) {
		List<Admin>admins=new ArrayList<Admin>();
		String sql="select *from admin order by id desc limit ?,?";
		try(Connection c=getConnection();PreparedStatement ps=c.prepareStatement(sql))
		{
			ps.setInt(1,start);
			ps.setInt(2,count);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Admin admin=new Admin();
				int id=rs.getInt(1);
				String username=rs.getString(2);
				String password=rs.getString(3);
				
				admin.id=id;
				admin.username=username;
				admin.password=password;
				admins.add(admin);
			}
			ps.close();
			c.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return admins;
	}
	
	
	
}
