package com.april29.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertNewRecord 
{
	public static void main(String[] args) throws SQLException 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO EMP1 VALUES(?,?,?,?)");
			stmt.setInt(1, 102);
			stmt.setString(2, "ward");
			stmt.setInt(3, 27);
			stmt.setString(4, "junior developer");
			stmt.executeUpdate();
			System.out.println("one record inserted successfully");
			
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}

}
