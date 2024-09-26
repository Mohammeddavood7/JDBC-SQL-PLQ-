package com.may1.csvProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RetrieveStoreInHashMap
{
	public static void main(String[] args) 
	{
		Map<String,Integer> hs = new HashMap<>();
		
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			PreparedStatement stmt = con.prepareStatement("SELECT EMPFIRSTNAME FROM EMP_INFO");
		    ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				String name = rs.getString("EMPFIRSTNAME");
				hs.put(name, name.length());
				
			}
			
			hs.forEach((s1,s2) ->{ System.out.println(s1+"   =  "+s2);});
			
			
			
		} 
		catch (ClassNotFoundException |SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
























