package com.april27.taskmackarooo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVANCEJAVATABLE",
					"TIGER");
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO EMP_INFO VALUES(?,?,?,?,?)");
			FileInputStream fis = new FileInputStream("D:\\advancejavaxml\\data.csv");
			Scanner sc = new Scanner(fis);
			sc.nextLine();
			
			int k = 0;
			while(sc.hasNext())
			{
				String[] s = sc.nextLine().split(",");
				for(int i=0;i<s.length;i++)
				{
					ps.setString(i+1 , s[i]);
				}
				k = ps.executeUpdate();
			}
			if(k > 0 ) {
				System.out.println("Data Inserted.");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
