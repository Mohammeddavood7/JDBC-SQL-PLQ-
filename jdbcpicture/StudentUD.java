package com.may2.jdbcpicture;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentUD
{
	static Scanner sc = new Scanner(System.in);
	
	public static boolean register(PreparedStatement stmt ) throws SQLException
	{
		System.out.print("enter student id: ");
		int id = sc.nextInt();
		
	    
		System.out.print("ente student name: ");
		String name = sc.nextLine();
		name = sc.nextLine();
		
		System.out.print("enter student percentage: ");
		double per = sc.nextDouble();
		
		System.out.print("enter student's first name: ");
		String f = sc.next();
		
		System.out.print("enter student's last name: ");
		String l = sc.next();
		
		System.out.print("enter student's mail: ");
		String mail = sc.next();

		System.out.print("enter student's phone number: ");
		double  phno = sc.nextDouble();
		
		stmt.setDouble(1, id);
		stmt.setString(2, name);
		stmt.setDouble(3, per);
		stmt.setString(4, f);
		stmt.setString(5, l);
		stmt.setString(6, mail);
		stmt.setDouble(7, phno);
		
		return 1 == stmt.executeUpdate();
		
	}
	
	public static boolean percentage(java.sql.Statement stmt) throws SQLException
	{
		ResultSet rs = stmt.executeQuery("SELECT *FROM STUDENTINFO WHERE PERCENTAGE > 60.0");
		ResultSetMetaData rm = rs.getMetaData();
		int c = rm.getColumnCount();
		for(int i = 1 ; i <= c ; i++)
		{
			System.out.print(rm.getColumnName(i)+"\t");
		}
		System.out.println();
		while(rs.next())
		{
			for(int i = 1 ; i <= c ; i++)
			{
		       System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
		
		return true;
		
	}
	public static boolean updateMailAndPhno(PreparedStatement stmt) throws SQLException
	{
		
	    System.out.print("update mail id: ");
	    String mail = sc.next();
	    stmt.setString(1,mail);
	    System.out.print("update phone number: ");
	    int phno = sc.nextInt();
	    stmt.setDouble(2,phno);
	    System.out.print("enter student rollno to update mail and id: ");
		int rollno = sc.nextInt();
	    stmt.setInt(3, rollno);
	     int num = stmt.executeUpdate();
	     if(num > 0)
	     {
	    	 return true;
	    	 
	     }
		
		return false;
	}
	public static boolean deleteStudent(java.sql.Statement stmt) throws Exception
	{
		
		 stmt.executeUpdate("DELETE FROM STUDENTINFO WHERE PERCENTAGE > 30 AND PERCENTAGE < 60");
		return true;
	}
	public static boolean findStudent(java.sql.Statement stmt) throws SQLException
	{
		stmt.executeQuery("SELECT *FROM STUDENTINFO WHERE PERCENTAGE > 80");
		return true;
	}
	
		
	
	
	
	
	public static boolean login(Statement stmt) throws SQLException
	{
		boolean res = false;
		System.out.print("enter student rollno: ");
	   int rollno = sc.nextInt();
		
		System.out.print("enter student name: ");
		String name = sc.nextLine();
		name = sc.nextLine();
		
		ResultSet rs = stmt.executeQuery("SElECT *FROM STUDENTINFO WHERE NAME = "+name+" AND ROLLNO = "+rollno);
		 
		 while(rs.next())
		 {
			 System.out.println("Login successfully .... !");
			 System.out.println(rs.getDouble(1)+" : "+rs.getString(2));
			 System.out.println();
			 res =  true;
		 }
		 return res;
		
	}
	
	
	
	public static void main(String[] args)
	{
	   try 
	   {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
		
		  
		  
		  while(true)
		  {
			  System.out.println("1.register");
			  System.out.println("2.login");
			  System.out.println("3.exit");
			  System.out.print("choose option: ");
			   int op = sc.nextInt();
			  outer: switch(op)
			   {
			   case 1: boolean register = register(con.prepareStatement("INSERT INTO STUDENTINFO VALUES(?,?,?,?,?,?,?)")); 
			           System.out.println(register ? "registered sucessfully":"something went wrong");
			           break;
			          
			           
			        
			   case 2: boolean login = login(con.createStatement());
					   
			             if(login)
						 {
						    
						  char ch1,ch2; ch1 = 'y'; ch2 = 'Y'; 
						   while(ch1=='y'&&ch2=='Y')
						   {
							 System.out.println("1.show students whose percentage>60");
							 System.out.println("2.update Mailid & Phno based on rollno");
							 System.out.println("3.delete student whose percentage between 30% to 60%");
							 System.out.println("4.find how many student got more than 80%");
							 System.out.println("5.stop ABOVE Option(press any key)");
				             System.out.print("choose option : ");
							 int option = sc.nextInt();	 
							 
							inner: switch(option)
							 {
							   case 1: percentage(con.createStatement()); break;
							   case 2: updateMailAndPhno(con.prepareStatement("UPDATE STUDENTINFO SET MAILID = ?, PHNO = ? WHERE ROLLNO = ?;")); break;
							   case 3: deleteStudent(con.createStatement()); break;
							   case 4: findStudent(con.createStatement()); break;
							   case 5: ch1 = 'n';
							   default: System.out.println("invalid option..");
							 }
						   }
							 
							 
						 }
					   else {
						   System.err.println("invalid login"+"\n");
					   }
					   break;
			   case 3 : break outer;
			   default : System.err.println("\n"+"invalid option");
			   }
			  
			  
		  }
		 
		  
	   } 
	   catch (Exception e)
	   {
		 e.printStackTrace();
	   }
		
	}

}
