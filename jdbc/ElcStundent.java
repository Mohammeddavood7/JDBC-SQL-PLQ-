package com.may6.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class ElcStundent
{
	public static void main(String[] args) 
	{
		ArrayList<Employee> al = new ArrayList<>();
		
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM  emp2");
		    ResultSet rs = stmt.executeQuery();
		    
		   while(rs.next())
		   {
				Employee em = new Employee();

			   em.setId(rs.getInt("ID"));
			   em.setName(rs.getString("NAME"));
			   em.setAddress(rs.getString("ADDRESS"));
			   em.setSalary(rs.getDouble("SALARY"));
			   em.setPhno(rs.getInt("PHNO"));
			   al.add(em);
			   
		   }
		   
		   
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		  Collections.sort(al,(r,n) -> r.getId()-n.getId());
		   
		    System.out.println(al);
		    
	}

}











