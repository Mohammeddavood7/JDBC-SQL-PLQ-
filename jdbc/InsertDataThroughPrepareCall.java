package com.may6.test.jdbc;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InsertDataThroughPrepareCall 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			CallableStatement cstmt = con.prepareCall("CALL STUDENT_DATA(?,?,?,?,?,?,?,?,?)");
			cstmt.setInt(1, 555);
			cstmt.setInt(2, 5555);
			cstmt.setString(3, "KILLER");
			cstmt.setString(4, "MCA");
			cstmt.setInt(5, 400000);
			cstmt.setString(6, "GOA");
			cstmt.setInt(7, 500166);
			cstmt.setString(8,"GOA555@gmail.com");
			cstmt.setLong(9, 8879876675l);
			cstmt.executeUpdate();
			System.out.println("one record inserted successfully");
			
		} 
		catch (ClassNotFoundException |SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
