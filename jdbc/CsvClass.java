package com.may6.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CsvClass
{
	public static boolean isprime(int id)
	{
		boolean res = true;
		
		if(id <= 1)
		{
			res = false;
			
		}
		
		for(int i = 2 ; i < id/2 ; i++)
		{
			if(id%i==0)
			{
				res = false;
			}
		}
		
		return res;
		
	}
	
	
	public static void main(String[] args)
	{
		
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM EMP_INFO");
			    ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					
						int id = rs.getInt(1);
						if(isprime(id))
						System.out.printf(id+"\t");
						System.out.printf(rs.getString(2)+"\n");
						System.out.printf(rs.getString(3)+"\n");
						System.out.printf(rs.getString(4)+"\n");
						System.out.printf(rs.getString(5)+"\n");
						System.out.println();
				}
			
			}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

}





















