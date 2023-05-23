package Databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Movie_table 
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kannada_movies", "root", "root");
	    Statement st=con.createStatement();
	    boolean a=st.execute("create table kannada(no integer primary key, hero_name varchar(40), movie_name varchar(40), collections varchar(40))");
	    con.close();
	    System.out.println("kannada_movies database inside kannada table created...!");

	}

}
