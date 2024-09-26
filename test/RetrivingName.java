package com.april29.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RetrivingName
{
	public static void main(String[] args) 
	{
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT *FROM EMP1");
			ResultSetMetaData rm = rs.getMetaData();
			int count = rm.getColumnCount();
			
			for(int i = 1 ; i <= count ; i++)
			{
				System.out.print(rm.getColumnName(i)+"\t");
			}
			System.out.println();
			
			
			 
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				String salary = rs.getString(4);
				char first = name.toUpperCase().charAt(0);
				char end = name.toUpperCase().charAt(name.length()-1);
				char[] ch = name.toCharArray();
				ch[0] = first;
				ch[name.length()-1] = end;
				String nm  = "";
				for(char c:ch)
				nm += c;
				System.out.println(id+"\t"+""+nm+"\t"+""+age+"\t"+""+salary);
				System.out.println();
				
				
			}
			 			 
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}

}


