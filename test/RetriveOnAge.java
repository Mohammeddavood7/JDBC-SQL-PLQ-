package com.april29.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RetriveOnAge
{
	public static void main(String[] args) 
	{
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *FROM EMP1 WHERE AGE>25");
			ResultSetMetaData rm = rs.getMetaData();
			int count = rm.getColumnCount();
			
//			for(int i = 1 ; i <= count ; i++)
//			{
//				System.out.print(rm.getColumnName(i)+"\t");
//			}
//			System.out.println();
			
			
			 
			while(rs.next())
			{
				     boolean endsWith1 = rs.getString("name").endsWith("A");
				     boolean endsWith2 = rs.getString("name").endsWith("k"); 
				     boolean endsWith3 = rs.getString("name").endsWith("E"); 
                  
				  if(endsWith1 || endsWith2 || endsWith3)
                  {
    				  System.out.print(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));

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

