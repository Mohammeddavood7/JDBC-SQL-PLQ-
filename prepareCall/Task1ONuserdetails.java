package com.april18.PrepareCall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Task1ONuserdetails
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		try(sc)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO USERDETAILS VALUES(?,?,?,?,?,?)");
	
			System.out.print("enter username: ");
			String un = sc.next();
			System.out.print("enter password: ");
			int ps = sc.nextInt();
		    System.out.print("enter ufname: ");
		    String uf = sc.next();
		    System.out.print("enter ulname: ");
		    String ul = sc.next();
		    System.out.print("enter gmail: ");
		    String gl = sc.next();
		    System.out.print("enter pnumber: ");
		    int pn = sc.nextInt();
			pstmt.setString(1, un);
			pstmt.setInt(2, ps);
			pstmt.setString(3, uf);
			pstmt.setString(4, ul);
			pstmt.setString(5, gl);
			pstmt.setInt(6, pn);
			int ep = pstmt.executeUpdate();
			System.out.println(ep);
			if( ep == 1)
			{
				System.out.println("user registration successfull");
			}
			else
			{
				System.out.println("invalid process");
			}

			
		} 
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
