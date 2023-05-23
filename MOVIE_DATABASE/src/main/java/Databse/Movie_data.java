package Databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Movie_data 
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/kannada_movies", "root", "root");
	    Statement st=con.createStatement();
	    boolean a=st.execute("insert into kannada values(5, 'RISHAB SHETTY', 'KANATARA', '1000000000cr')");
	    con.close();
	    System.out.println("kannada_movies database inside kannada table 1 row inserted...!");

	}

}
