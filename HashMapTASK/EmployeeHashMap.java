package com.april30.HashMapTASK;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class EmployeeHashMap
{
	public static void main(String[] args) 
	{
		String s="asdfggg";
	
		Map<String,Integer> hm = new HashMap<>();
		
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
			PreparedStatement stmt = con.prepareStatement("SELECT *FROM EMPLOYEHASHMAP");
			ResultSet rs = stmt.executeQuery();
			
			StringBuilder sb = new StringBuilder();
			
		while(rs.next())
			{
			  String name = rs.getString("name");
			  sb.append(name).append(",");
			}
		
		    
		
		   
		
		
		
		
		        
		
		
		
			
			//System.out.println(hm);
			
			
			
			
			
			
			
			
			
			
			
			
			/*System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getDouble(4)+"\n");

			String data = rs.getString("name");
			       
			if(hm.containsKey(data))
			{
				hm.put(data,hm.get(data)+1);
			}
			else
			{
			  hm.put(data, 1);
			}*/
			
			
			
			
			
			
			
			
			
			
//			hm.forEach((i1,i2) -> System.out.print(i1+"\t"+i2+"\t"));
//			System.out.println();
//			
//			
//			Set<Entry<String, Integer>> entrySet = hm.entrySet();
//			Iterator<Entry<String, Integer>> iterator = entrySet.iterator();
//			iterator.forEachRemaining(r -> System.out.println(r));
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}




















