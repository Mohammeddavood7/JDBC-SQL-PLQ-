package com.april18.PrepareCall;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PrepareCallInsert
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			CallableStatement cstmt = con.prepareCall("CALL INSERTPRO(?,?,?)");
			cstmt.setInt(1, Integer.parseInt(args[0]));
			cstmt.setString(2, args[1]);
			cstmt.setInt(3,Integer.parseInt(args[2]));
			cstmt.executeUpdate();
			System.out.println("one recorded inserted successfully");
			
		} 
		catch (ClassNotFoundException |SQLException e)
		{
			
			e.printStackTrace();
		}
		
	}

}





































