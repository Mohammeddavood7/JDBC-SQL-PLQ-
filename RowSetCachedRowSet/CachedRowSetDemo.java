package com.april24.RowSetCachedRowSet;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.RowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

public class CachedRowSetDemo 
{
	public static void main(String[] args) throws SQLException
	{
		RowSet crs = new OracleCachedRowSet();


		try(crs)
		{
			crs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			crs.setUsername("ADVANCEJAVATABLE");
			crs.setPassword("TIGER");
			crs.setCommand("SELECT *FROM STUDENT");
			crs.execute();
			ResultSetMetaData rs = crs.getMetaData();
			int count = rs.getColumnCount();
			while(crs.next())
			{
				for(int i = 1; i <= count; i++)
				{
					System.out.printf("%-20s",crs.getString(i));
				}
				System.out.println();
			}	
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	    
		
	}

}
















