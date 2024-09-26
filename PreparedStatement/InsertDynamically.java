package com.april17.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDynamically 
{
	public static void main(String[] args)
	{
	      try 
	      {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
	        PreparedStatement pstmt = 	con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?)"); 
	        Scanner sc = new Scanner(System.in);
	        System.out.print("enter student id: ");
	        int sid = sc.nextInt();
	        System.out.print("enter student name: ");
	        String sname = sc.next();
	        System.out.print("enter student marks: ");
	        int smarks = sc.nextInt();
	        pstmt.setInt(1, sid);
	        pstmt.setString(2, sname);
	        pstmt.setInt(3, smarks);
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
