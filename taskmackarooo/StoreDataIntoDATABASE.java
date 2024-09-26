package com.april27.taskmackarooo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class StoreDataIntoDATABASE
{
	public static void main(String[] args)
	{
		int execute = 0;
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO EXCEL_DATA VALUES(?,?,?,?,?)");

			FileInputStream fis = new FileInputStream("D:\\advancejavaxml\\data.csv");
			Scanner sc = new Scanner(fis);
			sc.nextLine();
			
			while(sc.hasNext())
			{
				  String[] rdf = sc.nextLine().split(",");
				  System.out.println(rdf.length);
                  for(int i = 0 ; i < rdf.length ; i++)
                  {
                	  stmt.setString(i+1, rdf[i]);
                  }

				execute = stmt.executeUpdate();

			}
			

			if(execute > 0)
			{
				System.out.println("data insert successfully in database");
			}	
			
			
			
			
		} 
		catch (ClassNotFoundException | SQLException |FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
	}

}





















