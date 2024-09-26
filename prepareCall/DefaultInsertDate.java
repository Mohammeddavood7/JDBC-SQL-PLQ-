package com.april18.PrepareCall;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DefaultInsertDate 
{
	public static void main(String[] args)
	{
	     try 
	     {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			PreparedStatement  pstmt = con.prepareStatement("INSERT INTO EMP VALUES(?,?)");
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setDate(2, Date.valueOf(args[1]));
			pstmt.executeUpdate();
			System.out.println("one recorded insert successfully");
			
			
			
			
			

			
		 }
	     catch (ClassNotFoundException e)
	     {
			e.printStackTrace();
		 } 
	     catch (SQLException e)
	     {
			e.printStackTrace();
		}
		
	}

}






























