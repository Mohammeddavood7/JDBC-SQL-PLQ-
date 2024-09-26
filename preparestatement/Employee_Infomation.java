package com.april19.Task.preparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;


public class Employee_Infomation 
{
	static Scanner sc = new Scanner(System.in);

	
	public static void insertData(PreparedStatement pstmt)
	{
	   System.out.print("enter emp id: ");
	   int empId = sc.nextInt();
	   System.out.print("enter emp name: ");
	   String empName = sc.next();
	   System.out.print("enter emp salary: ");
	   int empSalary = sc.nextInt();
	   System.out.print("enter emp address: ");
	   String empAddress = sc.next();
	   System.out.print("enter emp gmail: ");
	   String empMail = sc.next();
	   System.out.print("enter emp phone number: ");
	   long empPn = sc.nextLong();
	   try
	   {
		pstmt.setInt(1, empId);
		pstmt.setString(2, empName);
		pstmt.setInt(3, empSalary);
		pstmt.setString(4, empAddress);
		pstmt.setString(5, empMail);
		pstmt.setLong(6, empPn);
		pstmt.executeUpdate();
		System.out.println();
		System.out.println("one recorde inserted successfully");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
     
	   

		
	}

	public static void retrieveAll(PreparedStatement pstmt) throws SQLException
	{
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rm = rs.getMetaData();
		int count = rm.getColumnCount();
		for(int i = 1 ; i <= count ; i++)
		{
			System.out.printf("%-20s",rm.getColumnName(i));
		}
		System.out.println();
		
		while(rs.next())
		{
			for(int i = 1 ; i <= count ; i++)
			{
				System.out.printf("%-20s",rs.getString(i));
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println();
		
	}

	public static void retrieveBasedOnCharacter(PreparedStatement pstmt) throws SQLException
	{
		System.out.print("Enter whose name start with 's': ");
		String name = sc.next();
		pstmt.setString(1,name + "%");
		
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rm = rs.getMetaData();
		int count = rm.getColumnCount();
		
		for(int i = 1 ; i <= count ; i++)
		{
			System.out.printf("%-20s",rm.getColumnName(i));
		}
		System.out.println();
		
		while(rs.next())
		{
			for(int i = 1 ; i <= count ; i++)
			{
				System.out.printf("%-20s",rs.getString(i));
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("-------------------------------------------------------------------");
		System.out.println();
		
		
		
	}

	public static void retrieveBasedSalary(PreparedStatement pstmt) throws SQLException
	{
		System.out.print("Enter inbetween first: ");
		int bFirst = sc.nextInt();
		System.out.print("Enter inbetween second: ");
		int bSecond = sc.nextInt();
		pstmt.setInt(1, bFirst);
		pstmt.setInt(2, bSecond);
		
		
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rm = rs.getMetaData();
		int count = rm.getColumnCount();
		
		for(int i = 1 ; i <= count ; i++)
		{
			System.out.printf("%-20s",rm.getColumnName(i));
		}
		System.out.println();
		
		while(rs.next())
		{
			for(int i = 1 ; i <= count ; i++)
			{
				System.out.printf("%-20s",rs.getString(i));
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("-------------------------------------------------------------------");
		System.out.println();
		
		
		
		
	}

	public static void updateBasedOnID(PreparedStatement pstmt) throws SQLException
	{
		System.out.print("Enter Employee Id: ");
		int id = sc.nextInt();
		System.out.print("Update The Employee Salary: ");
		int sal = sc.nextInt();
		pstmt.setInt(1, sal);
		pstmt.setInt(2, id);
		pstmt.executeQuery();
		
	    System.out.println("updated salary successfully");
	    System.out.println("-------------------------------------------------------");
	    System.out.println();
		
		
	}

	public static void deleteBasedOnMaximumSalary(PreparedStatement pstmt) throws SQLException
	{
		pstmt.executeUpdate();
		System.out.print("higest salary holder delete successfully ");
		System.out.println("------------------------------------------------------");
		System.out.println();
		
	}

	public static void deleteBasedOnEndCharacter(PreparedStatement pstmt) throws SQLException
	{
		System.out.print("Enter To Delete If Last Character is 'a' in name: ");
		String name = sc.next();
		pstmt.setString(1, "%"+name);
		pstmt.executeUpdate();
		System.out.println("delete successfully");
		System.out.println("--------------------------------------------------------------");
		System.out.println();
		
	}

	
	
	
	
	

	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
	        
			
			System.out.print("Proceed Forword [y/n]: ");
			char ch = sc.next().charAt(0);
			
			while(ch == 'y' || ch == 'Y')
			{
				
				System.out.println("1.Insert data into Employee Table: ");
				System.out.println("2.Retrieve all Employee data");
				System.out.println("3.Retrieve employee whose name stats with 'S'");
				System.out.println("4.Retrieve employees whose salary between 10000 to 20000");
				System.out.println("5.Update employee salary with the help of eid ");
				System.out.println("6.delete employee who is getting maximum salary");
				System.out.println("7.delete employee whose name ends with 'a'");
				System.out.println("8.Exit");
				System.out.print("Choose the Option: ");
				int option = sc.nextInt();
				System.out.println("--------------------------------------------");
				System.out.println();
				switch(option)
				{
				   case 1: Employee_Infomation.insertData(con.prepareStatement("INSERT INTO EMPLOYEE_INFO VALUES(?,?,?,?,?,?)")); break;
				   case 2: Employee_Infomation.retrieveAll(con.prepareStatement("SELECT *FROM EMPLOYEE_INFO")); break;
				   case 3: Employee_Infomation.retrieveBasedOnCharacter(con.prepareStatement("SELECT *FROM EMPLOYEE_INFO WHERE EMPNAME LIKE ?")); break;
				   case 4: Employee_Infomation.retrieveBasedSalary(con.prepareStatement("SELECT *FROM EMPLOYEE_INFO WHERE EMPSALARY BETWEEN ? AND ? ")); break;
				   case 5: Employee_Infomation.updateBasedOnID(con.prepareStatement("UPDATE EMPLOYEE_INFO SET EMPSALARY = ? WHERE EMPID = ?")); break;
				   case 6: Employee_Infomation.deleteBasedOnMaximumSalary(con.prepareStatement("DELETE FROM EMPLOYEE_INFO WHERE EMPSALARY = (SELECT MAX(EMPSALARY) FROM EMPLOYEE_INFO)")); break;
				   case 7: Employee_Infomation.deleteBasedOnEndCharacter(con.prepareStatement("DELETE FROM EMPLOYEE_INFO WHERE EMPNAME LIKE ?")); break;
				   case 8: ch = 'n'; break;
				}
			}

			
			
			
			
			
			
			
			
		} 
		catch (ClassNotFoundException |SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
	}
}
























































