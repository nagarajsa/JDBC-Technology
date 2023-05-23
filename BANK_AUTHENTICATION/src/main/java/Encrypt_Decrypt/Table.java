package Encrypt_Decrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Table 
{

	public static void main(String[] args) throws Exception 
	{
	    Class.forName("com.mysql.cj.jdbc.Driver");	
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK", "root", "root");
        Statement stmt=con.createStatement();
        boolean a=stmt.execute("create table CANARA_BANK(ID integer primary key, NAME varchar(40), BALANCE Bigint, PASSWORD varchar(40))");
        con.close();
        System.out.println("Table Created...!");
	}

}
