package Dynamic_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Switch 
{
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Scanner sc=new Scanner(System.in);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info", "root", "root");
		
		boolean flag=true;
		while(flag)
		{
		System.out.println("-----------------CHOOSE YOUR OPTION'S----------------");
		System.out.println(" 1].ADD STUDENTS\n 2].UPDATE\n 3].REMOVE\n 4].FETCH DATA\n 5].EXIT");
		System.out.println("-----------------********************----------------");
		int  opt=sc.nextInt();
		switch(opt)
		{
		case 1: //add students
		{ 
	            PreparedStatement ps=con.prepareStatement("insert into jsp values(?, ?, ?, ?)");
	            System.out.println("Enter Your id:");
	            int id=sc.nextInt();
	            System.out.println("Enter your Name:");
	            String name=sc.next();
	            System.out.println("Enter Your Number:");
	            long number=sc.nextLong();
	            System.out.println("Enter Your Address:");
	            String address=sc.next();	 
	            ps.setInt(1, id);
	            ps.setString(2, name);
	            ps.setLong(3, number);
	            ps.setString(4, address);
	            System.out.println("Data added Successfully...!");
	            ps.executeUpdate();
	    
		} 
		
		break;
		
		case 2: //update
		{
			PreparedStatement ps=con.prepareStatement("update jsp set address=? where id=?");
			System.out.println("Enter your new address:");
			String address=sc.next();	
			System.out.println("Enter the id:");
			int id=sc.nextInt();
			ps.setString(1, address);
			ps.setInt(2, id);
			System.out.println("Data Updated Successfully...!");
			ps.executeUpdate();
		}
		
		break;
		
		case 3: //remove
		{
			PreparedStatement ps=con.prepareStatement("delete from jsp where id=?");
			System.out.println("Please enter id, which one you want to delete it. enter that id.");
			int id=sc.nextInt();
			ps.setInt(1, id);
			System.out.println("Data Deleted Successfully....!");
			ps.execute();
			              
		}
		
		break;
		
		case 4:  //fetch data
		{
			PreparedStatement ps=con.prepareStatement("select * from jsp where id=?");
			System.out.println("Please enter id which one data you want. enete that id");
			int id=sc.nextInt();
			ps.setInt(1, id);
			ResultSet n=ps.executeQuery();
		    n.next();
		    System.out.println(n.getInt(1)+" "+n.getString(2)+" "+n.getLong(3)+" "+n.getString(4));
		    System.out.println("Data fetched Successfully...!");
		    	
		    
		}
		break;
		
		case 5: //exit
		{
			flag=false;
			System.out.println("Thank you....!");
		}
		break;
		
		default:
		{
			System.out.println("Invallid Option");
		}
		
	    con.close();
		} 
		
		}
	}

}
