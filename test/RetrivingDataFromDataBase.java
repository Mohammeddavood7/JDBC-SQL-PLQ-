package com.april29.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RetrivingDataFromDataBase
{
	public static void main(String[] args) 
	{
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *FROM PRODUCTS");
			ResultSetMetaData rm = rs.getMetaData();
			int count = rm.getColumnCount();
			
			for(int i = 1 ; i <= count ; i++)
			{
				System.out.print(rm.getColumnName(i)+"\t");
			}
			System.out.println();
			
			
			 
			while(rs.next())
			{
				for(int i = 1 ; i <= count ; i++)
				{
				  System.out.print(rs.getString(i)+"\t");
				 
				}
				 System.out.println();
			}
			 			 
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}

}





































