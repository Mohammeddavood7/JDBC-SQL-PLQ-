package com.april24.RowSetCachedRowSet;

import java.io.FileOutputStream;
import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import oracle.jdbc.rowset.OracleWebRowSet;

public class WebRowSetXML
{
	public static void main(String[] args) throws SQLException
	{
	   WebRowSet wrs = new OracleWebRowSet();
		   wrs.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		   wrs.setUsername("ADVANCEJAVATABLE");
		   wrs.setPassword("TIGER");
		   wrs.setCommand("SELECT *FROM STUDENT");
		   wrs.execute();
		try(wrs) 
		{
			
			wrs.writeXml(new FileOutputStream("D:\\advancejavaxml\\Student.txt"));
			System.out.println("copied to file");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		
		
	}

}












