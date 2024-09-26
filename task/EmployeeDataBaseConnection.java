package com.april26.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataBaseConnection 
{
	public static void main(String[] args)
	{
		List<Employees> al = new ArrayList<>();

		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
		    PreparedStatement pstmt = con.prepareStatement("SELECT *FROM Employee");	
			
		    ResultSet rs = pstmt.executeQuery();
		    Employees emp = null;
		    
		    while(rs.next())
		    {
		    	emp = new Employees();
		    	emp.setId(rs.getInt("id"));
		    	emp.setName(rs.getString("name"));
		    	emp.setAge(rs.getInt("age"));
		    	emp.setSalary(rs.getDouble("salary"));
		    	al.add(emp);
		    }
			
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		al.forEach(e -> System.out.println(e));
		System.out.println("-----------------------------------");
	    al.stream().filter(s ->s.getAge() > 25).forEach( s -> System.out.println(s));
		
	}

}























