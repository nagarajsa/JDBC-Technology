package Dynamic_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Index1 
{
    public static void main(String[] args) throws Exception 
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "root");
        Statement stmt=con.createStatement();
        boolean a=stmt.execute("create table jsp(id integer primary key, name varchar(40), number Bigint, address varchar(40) )");
        con.close();
        System.out.println("Table Created...!");
		

	}

}
