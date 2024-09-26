package com.april17.PreparedStatement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateDynamically 
{
	public static void main(String[] args)
	{
	      try 
	      {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
	        PreparedStatement pstmt = 	con.prepareStatement("UPDATE STUDENT SET SNAME = 'SCOOTER' WHERE SNAME = ?"); 
	        Scanner sc = new Scanner(System.in);
	        
	        pstmt.setString(1,"SCOTT");
	    	pstmt.executeUpdate();
	    	
	    	System.out.println("one record inserted successfully");	  
	    	sc.close();
	    	con.close();
	    	pstmt.close();
	    	
		  } 
	       catch (ClassNotFoundException | SQLException e) 
	      {
	    	   e.printStackTrace();
		  }	
	      
	}

}

