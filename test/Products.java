package com.april29.test;
import java.sql.*;

public class Products 
{
	
	
	static boolean isAnagram(int num)
	   {
		   int count = 0;
		   int original = num;
		   
		   while(num != 0)
		   {
			   num/=10;
			   count++;
		   }
		   
		   int res = 0;
		  int num2 =  original;
		  int rem= 0;
		  
		   while(original != 0)
		   { 
			   rem = original%10;
			   res += Math.pow(rem,count);
			   original/=10;
		   }
		   
	        return res == num2;
	    }
	
	
	
	
	
	
    public static void main(String[] args)
    {
        try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","ADVANCEJAVATABLE","TIGER");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCTS");
            System.out.println(Products.isAnagram(153));
            while (resultSet.next())
            {
            	int productId = resultSet.getInt("PID");
                String productName = resultSet.getString("PNAME");
                double price = resultSet.getDouble("PPRICE");
                int quantity = resultSet.getInt("PQUANTITY");

                if (Products.isAnagram(productId)) 
                {
                    if (price > 1000 && price < 5000)
                    {
                        System.out.println(productId+"\t"+productName+"\t"+price+"\t"+quantity);
                        System.out.println();
                      }
                }
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
}




















