package com.april22.task.prepareCall;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class StudentDetailsJDBC 
{
    public static void main(String[] args)throws Exception 
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
    	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");
    	CallableStatement stmt = con.prepareCall("CALL RETRIEVESTUDENTDATA(?,?,?,?,?,?,?,?,?)");	
        try (con;stmt)
        {
            stmt.setInt(1, 444);
            stmt.registerOutParameter(1,Types.INTEGER);
            stmt.registerOutParameter(2, Types.INTEGER);
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.registerOutParameter(5, Types.INTEGER);
            stmt.registerOutParameter(6, Types.VARCHAR);
            stmt.registerOutParameter(7, Types.INTEGER);
            stmt.registerOutParameter(8, Types.VARCHAR);
            stmt.registerOutParameter(9, Types.INTEGER);
          
            
           stmt.execute();
           System.out.println("Student ID    :" + stmt.getInt(1));
           System.out.println("Name          :" + stmt.getInt(2));
           System.out.println("Roll Number   :" + stmt.getString(3));
           System.out.println("Branch        :" + stmt.getString(4));  
           System.out.println("HouseNo       :" + stmt.getInt(5));             
           System.out.println("City          :" + stmt.getString(6));             
           System.out.println("Pincode       :" + stmt.getInt(7));             
           System.out.println("Mail          :" + stmt.getString(8));             
           System.out.println("Phone No      :" + stmt.getDouble(9));             

                    
        } 
        catch(Exception e)
        {
        	e.printStackTrace();
        	
        }
    }
            

        
    
}
