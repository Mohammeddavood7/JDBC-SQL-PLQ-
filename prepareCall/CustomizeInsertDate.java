package com.april18.PrepareCall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;




public class CustomizeInsertDate 
{
	public static void main(String[] args) 
	{
	     try 
	     {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			PreparedStatement  pstmt = con.prepareStatement("INSERT INTO EMP VALUES(?,?)");
	
			pstmt.setInt(1, Integer.parseInt(args[0]));
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date d = sdf.parse(args[1]);
			java.sql.Date date = new java.sql.Date(d.getTime());
			
			pstmt.setDate(2, date);
			pstmt.executeUpdate();
			System.out.println("one recorded insert successfully");
			
			
			
			
			

			
		 }
	     catch (ClassNotFoundException | ParseException e)
	     {
			e.printStackTrace();
		 } 
	     catch (SQLException e)
	     {
			e.printStackTrace();
		}
		
	}

}