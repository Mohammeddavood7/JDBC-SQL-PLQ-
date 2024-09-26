package com.may1.csvProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CvsINSERTvalue 
{
	public static void main(String[] args) throws FileNotFoundException, SQLException
	{
		var fis = new FileInputStream("D:\\advancejavaxml\\data.csv");
		Scanner sc = new Scanner(fis);
		int n = 0;
		try (sc) 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVANCEJAVATABLE","TIGER");
			PreparedStatement stmt = con.prepareStatement("INSERT INTO EMP_INFO VALUES(?,?,?,?,?)");

			sc.nextLine();

			while (sc.hasNext()) 
			{
				String[] data = sc.nextLine().split(",");
				
				if(data[4].equalsIgnoreCase("Male"))
				{
					for (int i = 0; i < data.length; i++) 
					{
						stmt.setString(i+1, data[i]);
					}
	
					n = stmt.executeUpdate();
				}
				
			}

			if (n > 0) {
				System.out.println("csv inserted successfully");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
