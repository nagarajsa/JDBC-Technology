package VALIDATION_PROJECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database 
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306",  "root",  "root");
	    Statement stmt=con.createStatement();
	    boolean s=stmt.execute("create database RESERVE_BANK");
	    System.out.println("Database Created Successfully.....!");
	    con.close();
	    
	    

	}

}
