package com.april26.task;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Employee_FunctionProgromOnSQL
{
	public static void main(String[] args)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			CallableStatement cstmt = con.prepareCall("{ ? = call studentAddressObject(?) }");
			cstmt.registerOutParameter(1, Types.VARCHAR);
			cstmt.setInt(2, 101);
			cstmt.execute();
			System.out.println("Address of the student:"+ cstmt.getString(1));	
		} 
		catch (ClassNotFoundException |SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}













