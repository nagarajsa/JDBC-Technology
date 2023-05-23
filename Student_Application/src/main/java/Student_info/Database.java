package Student_info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database 
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
	    Statement stmt=con.createStatement();
	    boolean a=stmt.execute("create database JSPIDERS");
	    con.close();
	    System.out.println("Database Created....!");

	}

}
