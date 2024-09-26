package com.april15.programcreate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable
{
	public static void main(String[] args)
	{
		try 
		{
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			 Statement statement = con.createStatement();
			 statement.execute("CREATE TABLE STUDENT(SID INT , SNAME VARCHAR2(20),SMARKS INT)");
			 System.out.println("one table is created sucessfully...");
			 
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}


}






































