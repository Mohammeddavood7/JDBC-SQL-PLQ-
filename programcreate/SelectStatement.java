package com.april15.programcreate;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class SelectStatement 
{
	public static void main(String[] args)
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT *FROM STUDENT");
		    while(rs.next())
		    {
		    	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getInt(3));
		    }
		}
		catch (Exception e)
		{
		}
		
		
	}
}






















































