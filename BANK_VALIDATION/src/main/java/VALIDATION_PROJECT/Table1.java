package VALIDATION_PROJECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Table1 
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RESERVE_BANK",  "root",  "root");
	    Statement stmt=con.createStatement();
	    boolean s=stmt.execute("create table login(USER_NAME varchar(50), PASSWORD integer primary key, PHO_NUMBER Bigint, EMAIL varchar(50))");
	    System.out.println("LOGIN Table Created Successfully.....!");
	    con.close();
	    
	}

}
