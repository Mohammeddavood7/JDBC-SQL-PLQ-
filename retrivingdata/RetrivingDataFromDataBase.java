package com.aprial16.retrivingdata;

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
			ResultSet rs = stmt.executeQuery("SELECT *FROM STUDENT");
			ResultSetMetaData rm = rs.getMetaData();
			int count = rm.getColumnCount();
			
			for(int i = 1 ; i <= count ; i++)
			{
				System.out.print(rm.getColumnName(i)+"\t");
			}
			System.out.println();
			
			/*for(int i = 1 ; i <= count ; i++)
			{
				while(rs.next())
				{
					System.out.print(rs.getInt(1)+"\t");
					System.out.print(rs.getString(2)+"\t");
					System.out.println(rs.getInt(3));
				}
				
			}*/
			
			/*for(int i = 1 ; i <= count ; i++)
			{
				while(rs.next())
				{
					System.out.print(rs.getInt("SID")+"\t");
					System.out.print(rs.getString("SNAME")+"\t");
					System.out.println(rs.getInt("SMARKS"));
				}
				
			}*/
			
			
				/*while(rs.next())
				{
					System.out.print(rs.getInt("SID")+"\t");
					System.out.print(rs.getString("SNAME")+"\t");
					System.out.println(rs.getInt("SMARKS"));
					
				}*/
			
			
//			 while (rs.next())
//			 {
//	                StringBuilder rowString = new StringBuilder();
//	                for (int i = 1; i <= count; i++)
//	                {
//	                    rowString.append(rs.getString(i)).append("\t");
//	                }
//	                
//	                System.out.println(rowString.toString());
//	            }
			
			
			
			 
			 
			 
			  /*StringBuilder[] columnData = new StringBuilder[count + 1];
	            for (int i = 1; i <= count; i++) {
	                columnData[i] = new StringBuilder();
	            }

	            // Fetch data
	            while (rs.next()) {
	                for (int i = 1; i <= count; i++) {
	                    columnData[i].append(rs.getString(i)).append("\t");
	                }
	            }

	            // Print data
	            for (int i = 1; i <= count; i++) {
	                System.out.println(columnData[i].toString());
	            }*/

			 
			 
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





































