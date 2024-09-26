package com.april23.RowSetClassesJdbcRowSet;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JdbcRowSetInterface 
{
	public static void main(String[] args) throws SQLException
	{
		JdbcRowSet jrs  = new OracleJDBCRowSet();
		
		try(jrs)
		{
		   
		   jrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		   jrs.setUsername("ADVANCEJAVATABLE");
		   jrs.setPassword("TIGER");
		   jrs.setCommand("SELECT *FROM STUDENT");
		   jrs.execute();
		   
		   while(jrs.next())
		   {
			   System.out.printf("%-20s",jrs.getInt(1)); 
			   System.out.printf("%-20s",jrs.getString(2)); 
			   System.out.printf("%-20s",jrs.getInt(3)); 
			   System.out.println();
		   }   
		   
		   
		}
		catch(Exception e)
		{
			e.printStackTrace();	
		}
		
	}

}






































