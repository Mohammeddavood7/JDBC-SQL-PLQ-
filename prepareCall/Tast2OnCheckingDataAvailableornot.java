package com.april18.PrepareCall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Tast2OnCheckingDataAvailableornot 
{
	public static void main(String[] args)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
		    PreparedStatement pstmt = con.prepareStatement("SELECT * FROM USERDETAILS WHERE USERNAME=? AND PASSWORD=?");
		   
		    //ResultSetMetaData rm = rs.getMetaData();
		   // int count = rm.getColumnCount();
		    Scanner sc = new Scanner(System.in);
		    System.out.print("enter username: ");
		    String un = sc.next();
		    System.out.print("enter password: ");
		    int ps = sc.nextInt();
		  
		    pstmt.setString(1, un);
		    pstmt.setInt(2, ps);
		    
		    ResultSet rs = pstmt.executeQuery();
		    
			if(rs.next())
			{
			System.out.println("Login Successful...");
			}
			else
			{
				System.out.println("Incorrect id or PAssword");
			}
			
			
			
			sc.close();
			
			
			
		} 
		catch (ClassNotFoundException |SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}








































































































































































