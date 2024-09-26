package com.april15.programcreate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTable
{
	public static void main(String[] args)
	{
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO STUDENT VALUES(333,'MILLER',89)");
			System.out.println("one recored successfully inserted...");
		} 
	    catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
































