package com.may6.test.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CreateFunction
{
	public static void main(String[] args) throws SQLException
	{
		try 
		{
			
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
				CallableStatement cstmt = con.prepareCall("{ ? = call EMP2OBJECT(?) }");
				cstmt.registerOutParameter(1, Types.INTEGER);
				cstmt.setInt(2, 111);
				cstmt.execute();
				System.out.println("Address of the emp salary:"+ cstmt.getInt(1));	
			
			
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

}











