package com.april22.task.prepareCall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class statementVSpreparedstatement
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			Statement stmt = con.createStatement();
			long start = System.currentTimeMillis();
			stmt.executeQuery("SELECT *FROM STUDENT");
			long end = System.currentTimeMillis();
			System.out.println("Time of Statement: "+(end - start));
			
			
			 PreparedStatement pstmt = con.prepareStatement("SELECT *FROM STUDENT");
			 start = System.currentTimeMillis();
			 pstmt.executeQuery();
			 end = System.currentTimeMillis();
			 System.out.println("Time of PreparedStatement: "+(end - start));
		
			con.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}




















