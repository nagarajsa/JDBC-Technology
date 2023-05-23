package Databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Movie_db 
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
	    Statement st=con.createStatement();
	    boolean a=st.execute("create database Kannada_movies");
	    con.close();
	    System.out.println("Database Created");

	}

}
