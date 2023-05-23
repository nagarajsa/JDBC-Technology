package VALIDATION_PROJECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo
{

	static Scanner sc=new Scanner(System.in);
	public void signUp(String name, String pwd, long number, String email) throws Exception   //1]SIGNUP
	{
		try {
		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reserve_bank", "root", "root");
		     PreparedStatement ps=con.prepareStatement("insert into details2 values(?, ?, ?, ?)");
		    // String USER_NAME=sc.next();
            // String PASSWORD=sc.next();
            // double PHO_NUMBER=sc.nextLong();
            // String  EMAIL=sc.next();
        
             ps.setString(2, name);
             ps.setString(3, pwd);
		     ps.setDouble(4, number);
		     ps.setString(5, email);
		     ps.executeUpdate();
	         con.close();
	         System.out.println("-----------Account has been Created-------------");
		  }
		catch(SQLException e)
		{
		 System.out.println("!------------OOP's Someting went Wrong---------------!");	
		}
		
 }
	
	
	
 public	void logIn(String name2, String upwd)   //2]LOGIN
	{
		try {
		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reserve_bank", "root", "root");
		     PreparedStatement ps=con.prepareStatement("select * from details2");
		     ResultSet r=ps.executeQuery();
		     r.next();
		     String USER_NAME=r.getString(1);
		     String PASSWORD=r.getString(2);
		     
		     if(USER_NAME.equals(name2) && PASSWORD.equals(upwd))
		    {
			  //Scanner sc=new Scanner(System.in);
			  boolean flag2=true;
			  System.out.println("------------------------------WELCOME TO HOME PAGE-----------------------------------------------");
			
			 while(flag2)
			 {
				System.out.println("==============================================================================================================");
				System.out.println("  1].CHECK BALANCE\n  2].UPDATE NUMBER\n  3].WITH DRAW\n  4].CHANGE PASSWORD\n  5].DISPLAY DETAILS\n  6].EXIT ");
				System.out.println("==============================================================================================================");
				int opt=sc.nextInt();
				switch(opt)
				{
				    case 1:
				    {
				    	System.out.println("Enter your Password");
				    	checkBalance(sc.next());
				    }
				    break;
				    
				    case 2:
				    {
				    	System.out.println("Enter your New Number");
				    	double PHO_NUMBER=sc.nextDouble();
				    	System.out.println("Enter your Password");
				    	String p=sc.next();
				    	updateNumber(PHO_NUMBER, p);
				    }
				    break;
				    
				    case 3:
				    {
				    		System.out.println("Enter the Amount");
				    		double amt=sc.nextDouble();
				    	    System.out.println("Enter your Password");
				    	    String p=sc.next();
				    	    withDraw(amt, p);
				    }
				    break;
				    
				    case 4:
				    {
				    	System.out.println("Enter your Old Password");
				    	String p=sc.next();
				    	System.out.println("Enter your New Password");
				    	String np=sc.next();
				    	changePwd(p, np);
				    }
				    break;
				    
				    case 5:
				    {
				    	System.out.println("Enter your Password");
				    	Fetchdetails(sc.next());
				    	
				    }
				    break;
				    
				    case 6:
				    {
				    	flag2=false;
				    	System.out.println("!---THANK YOU---!");
				    }
				    break;
				    
				    default:
				    	System.out.println("!--INVALLID OPTIONS---!");
				    	break;
				    
				    
				 }
			}
			
			
		}
		else
		{
			System.out.println("--Incorrect Password or Name--");
		}
	}
	
	catch(SQLException e)
	{
	 System.out.println("!------------OOP's Someting went Wrong---------------!");	
	}
}
	
	
	
	  public void checkBalance(String upwd)    // CHECK BALANCE
	 {
		  try {
			     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reserve_bank", "root", "root");
			     PreparedStatement ps7=con.prepareStatement("select PASSWORD from details2");
			     ResultSet r=ps7.executeQuery();
			     r.next();
			     String PASSWORD=r.getString(3);
			    
			     if(PASSWORD.equals(upwd))
			     {
			    	 PreparedStatement ps8=con.prepareStatement("select BALANCE from details2");
				     ResultSet r1=ps8.executeQuery();
				     r1.next();
				     System.out.println("Balance :"+r1.getDouble(5));
			     }
				 else
				 {
					System.out.println("!---Incorrect Password---!");
					System.out.println("****************************");
				  }
				     con.close();
			 }
			catch(SQLException e)
			{
			 e.printStackTrace();
			 System.out.println("!------------OOP's Someting went Wrong---------------!");
			}
	 }
				     
			
		  
	
	
	void updateNumber(double PHO_NUMBER, String upwd) //UPDATE
	{
		try {
		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reserve_bank", "root", "root");
		     PreparedStatement ps9=con.prepareStatement("select PASSWORD from details2");
		     ResultSet r=ps9.executeQuery();
		     r.next();
		     String PASSWORD=r.getString(3);
		    
		     if(PASSWORD.equals(upwd))
		    {
		    	 PreparedStatement ps10=con.prepareStatement("update details2 set PHO_NUMBER=? where id=?");
		    	 System.out.println("Enter your New Phone Number:");
		    	 double PHO_NUMBER1=sc.nextDouble();
		    	 System.out.println("Enter your ID");
		    	 int ID=sc.nextInt();
		    	 ps10.setDouble(1, PHO_NUMBER1);
		    	 ps10.executeUpdate(); 
		    }
		    else
		    {
			    System.out.println("!---Incorrect Password---!");
				System.out.println("****************************");
		     }
			    con.close();
		}	 
	    catch(SQLException e)
	    {
		   e.printStackTrace();
		   System.out.println("!------------OOP's Someting went Wrong---------------!");
		}
				     
	}
	
			     

	public void withDraw(double amount, String upwd)  //WITHDRAW
	{
		try {
		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reserve_bank", "root", "root");
		     PreparedStatement ps=con.prepareStatement("select PASSWORD from details2");
		     ResultSet r=ps.executeQuery();
		     r.next();
		     String PASSWORD=r.getString(3);
		    
		     if(PASSWORD.equals(upwd))
		    {
		    	 PreparedStatement ps1=con.prepareStatement("select BALANCE from details2");
			     ResultSet r1=ps1.executeQuery();
			     r1.next();
			     double BALANCE=r1.getDouble(1);
			     
			     if(BALANCE >= amount)
			     {
			    	 System.out.println("Take and Enjoy your self.....!");
					 double R_BALANCE=BALANCE-amount; 
					 PreparedStatement ps2=con.prepareStatement("update details2 set BALANCE=? where ID=1");
					 
					 ps2.setDouble(1, BALANCE);
					 ps2.executeUpdate();
			     }
		         else
			     {
				   System.out.println("!---InSufficient Funds---!");
			     }
		    }
		    else
		    {
			System.out.println("!---Incorrect Password---!");
			System.out.println("****************************");
		    }
		     con.close();
		}
		catch(SQLException e)
		{
			 e.printStackTrace();
			 System.out.println("!------------OOP's Someting went Wrong---------------!");
		}
		     
	}
	
	
	public void changePwd(String PASSWORD, String upwd)   //CHANGE PASSWORD
	{
	
		try {
		     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reserve_bank", "root", "root");
		     PreparedStatement ps3=con.prepareStatement("select PASSWORD from details2");
		     ResultSet r=ps3.executeQuery();
		     r.next();
		     String NEW_PASSWORD=r.getString(3);
		    
		     if(NEW_PASSWORD.equals(upwd))
		     {
		    	 PreparedStatement ps4=con.prepareStatement("update details set NEW_PASSWORD=? where PASSWORD=?");
			     ps4.setString(1, NEW_PASSWORD);
			     ps4.setString(2, PASSWORD);
			     ps4.executeUpdate();
			     System.out.println("-----------------UPDATED------------------");
		     } 
		       else
			   {
				  System.out.println("!---Incorrect Password---!");
				  System.out.println("****************************");
			      con.close();
			   }
		   }
			catch(SQLException e)
			{
				 System.out.println("!------------OOP's Someting went Wrong---------------!");
			}
			     
	}
	
	
	 public void Fetchdetails(String upwd)  //DISPLAY
	{
			try {
			        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reserve_bank", "root", "root");
			        PreparedStatement ps5=con.prepareStatement("select PASSWORD from details2");
			        ResultSet r=ps5.executeQuery();
			        r.next();
			        String NEW_PASSWORD=r.getString(7);
		 
		 
			       if(NEW_PASSWORD.equals(upwd))
		           {
				     PreparedStatement ps6=con.prepareStatement("select * from details2");
				     ResultSet r6=ps6.executeQuery();
				     r6.next();
				    System.out.println("Name :"+r6.getString(2));
			        System.out.println("Password :"+r6.getString(3));
			        System.out.println("Number :"+r6.getInt(4));
			        System.out.println("Email :"+r6.getString(5));
			        System.out.println("--------------------------");
		          }
			      else
			      {
				   System.out.println("!---Incorrect Password---!");
				   System.out.println("****************************");
			       con.close();
			      }
			  
			  }
			  catch(SQLException e)
			  {
			     System.out.println("!------------OOP's Someting went Wrong---------------!");
			 }
					     
	 }
			


public static  class Final_validation
{

	public static void main(String[] args) throws Exception 
	{
	 	Demo b=new Demo();
		Scanner sc=new Scanner(System.in);
		boolean flag=true;
		while(flag)
		{
			System.out.println("-------------------------------");
			System.out.println(" 1].SIGNUP\n 2].LOGIN\n 3].EXIT");
			System.out.println("-------------------------------");
			int opt=sc.nextInt();
			switch(opt)
			{
			   case 1:
			   {
				   System.out.println("Enter Your Name:");
				   String name=sc.next();
				   System.out.println("Enter Your Password:");
				   String pwd=sc.next();
				   System.out.println("Enter Your Number:");
				   long number=sc.nextLong();
				   System.out.println("Enter Your Email");
				   String email=sc.next();
				   b.signUp(name, pwd, number, email);
			   }
			   break;
			   
			   case 2:
			   {
				   System.out.println("Enter Your Name");
				   String name=sc.next();
				   System.out.println("Enter Your Password");
				   String pwd=sc.next();
				   b.logIn(name, pwd);
				   
			   }
			   break;
			   
			   case 3:
			   {
				   flag=false;
				   System.out.println("!---THANK YOU---!");
			   }
			   break;
			   
			   default:
				   System.out.println("!---Invallid Option---!");
				   break;
			}
			
		}
		
	}
 }

}
