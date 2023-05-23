package Student_info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Table 
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JSPIDERS", "root", "root");
	    Statement stmt=con.createStatement();
	    boolean a=stmt.execute("create table Mock_Details(ID integer primary key, NAME varchar(40), JAVA_MOCK_RATE integer, SQL_MOCK_RATE integer, WEB_MOCK_RATE integer)");
	    con.close();
	    System.out.println("Table Created....!");

	}

}
