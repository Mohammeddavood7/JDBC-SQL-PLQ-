package com.april25.SetSavepoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SetSavePoint
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
		    con.setAutoCommit(false);
		     
		     
		    PreparedStatement pstmt = 	con.prepareStatement("UPDATE STUDENT SET SID = ? WHERE SID = ?");
     	   // Savepoint s = con.setSavepoint();
		    pstmt.setInt(1,1004);
		    pstmt.setInt(2,1003);
		    con.commit();

		    pstmt.executeUpdate();
		   

		
		}
		catch (ClassNotFoundException |SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	

}



















