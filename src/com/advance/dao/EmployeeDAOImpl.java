package com.advance.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.advance.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs;
	Employee e;
	Employee e1[];
	public static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	public static final String user="system";
	public static final String pass="password";

	@Override
	public int save(Employee e) {
		int status=0;
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,user,pass);
			String sql="insert into employee values(?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, e.getEmpID());
			ps.setString(2, e.getEmpName());
			ps.setDouble(3, e.getEmpSal());
			
			status=ps.executeUpdate();
		}
		catch(Exception r){
			
		}
		finally{
			
		}
		return status;
	}

	@Override
	public int update(Employee e) {
		
		int status=0;
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,user,pass);
			String sql="update employee set sal=? where id=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(2, e.getEmpID());
			ps.setDouble(1, e.getEmpSal());
			
			status=ps.executeUpdate();
		}
		catch(Exception r){
			
		}
		finally{
			
		}
		return status;
	}

	@Override
	public int delete(Employee e){
		
		int status=0;
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,user,pass);
			String sql="delete from employee where id=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, e.getEmpID());
			
			status=ps.executeUpdate();
		}
		catch(Exception r){
			
		}
		finally{
			
		}
		return status;
	}

	@Override
	public Employee get(int id) {
		
		try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,user,pass);
			String sql="select *from employee where id=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1,id);
			 e = new Employee();
			rs=ps.executeQuery();
			while(rs.next()){
				e.setEmpID(rs.getInt(id));
				e.setEmpName(rs.getString("name"));
				e.setEmpSal(rs.getDouble("sal"));
				//System.out.println(e.getEmpID()+" "+e.getEmpName()+" "+e.getEmpSal());
			}
		}
		catch(Exception r){
			
		}
		finally{
			
			try{
				
			rs.close();
			ps.close();
			con.close();
			
			}
			catch(Exception f){
				f.printStackTrace();
			}
		}
		return e;
	}

	@Override
	public Employee[] getAll() {
		
try{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,user,pass);
			String sql="select *from employee";
			ps=con.prepareStatement(sql);

			rs=ps.executeQuery();
			int i=0;
			e1=new Employee[1];
			while(rs.next()){
				
				e1[i]=new Employee();
				e1[i].setEmpID(rs.getInt("id"));
				e1[i].setEmpName(rs.getString("name"));
				e1[i].setEmpSal(rs.getDouble("sal"));
				//System.out.println(e.getEmpID()+" "+e.getEmpName()+" "+e.getEmpSal());
			}
		}
		catch(Exception r){
			
		}
		finally{
			
			try{
				
			rs.close();
			ps.close();
			con.close();
			
			}
			catch(Exception f){
				f.printStackTrace();
			}
		}
		return e1;
	}

}
