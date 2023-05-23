package VALIDATION_PROJECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Table2 
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RESERVE_BANK",  "root",  "root");
	    Statement stmt=con.createStatement();
	    boolean s=stmt.execute("create table details2(ID integer primary key, USER_NAME varchar(50), PASSWORD varchar(40), PHO_NUMBER Bigint, EMAIL varchar(50), BALANCE Bigint, NEW_PASSWORD varchar(40))");
	    System.out.println("Details2 Table Created Successfully.....!");
	    con.close();
	    
	}

}
