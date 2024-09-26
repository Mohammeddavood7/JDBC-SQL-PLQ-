package com.april17.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class RetriveData1
{
	public static void main(String[] args)
	{
		
       try 
       {
    	   
   		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","EMP","TIGER");
        Statement stmt = con.createStatement();
        ResultSet rs =   stmt.executeQuery("SELECT EMPNO ,ENAME,JOB,SAL FROM EMP WHERE JOB IN ('CLERK','MANAGER')");
    	ResultSetMetaData rm = rs.getMetaData();
    	 int cc = rm.getColumnCount();
    	 for(int i = 1 ; i <= cc ; i++)
    	 {
    		System.out.print(rm.getColumnName(i)+"\t"); 
    	 }
    	 System.out.println();
//    	 
//    	 while(rs.next())
//    	 {
//    		 for(int i = 1 ; i <= cc ; i++)
//    		 {
//    			 System.out.print(rs.getString(i)+"\t");
//    		 }
//    		 System.out.println();
//    	 }
    	 
    	 


    	 while(rs.next())
    	 {
    		 StringBuilder sb = new StringBuilder();

    		 for(int i = 1 ; i <= cc ; i++)
    		 {
    			 sb.append(rs.getString(i)+"\t");
    		 }
    		 System.out.println(sb);

    	 }
    	 
//    	 while(rs.next())
//    	 {
//    		 System.out.print(rs.getInt(1)+"\t");
//    		 System.out.print(rs.getString(2)+"\t");
//    		 System.out.print(rs.getString(3)+"\t");
//    		 System.out.println(rs.getDouble(4)+"\t");
//    	}
//    	 
    	 

	   } 
       catch (Exception e) 
       {
    	   e.printStackTrace();
	   }
       
       
	}

}
