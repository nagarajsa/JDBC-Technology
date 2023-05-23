package Dynamic_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Index 
{
    public static void main(String[] args) throws Exception 
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
        Statement stmt=con.createStatement();
        boolean a=stmt.execute("create database Student_info");
        con.close();
        System.out.println("Database Created...!");
		

	}

}
