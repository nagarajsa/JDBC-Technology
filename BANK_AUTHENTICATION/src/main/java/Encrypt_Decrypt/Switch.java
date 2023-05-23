package Encrypt_Decrypt;

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
		Scanner sc=new Scanner(System.in);
	    Class.forName("com.mysql.cj.jdbc.Driver");	
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/BANK", "root", "root");
	    
	    boolean flag = true;
	    while(flag) 
	    {
	        System.out.println("--------------------------------------------------------------------");
	        System.out.println("             WELCOME TO CANARA BANK APPLICATION                     ");
	        System.out.println("--------------------------------------------------------------------");
	        System.out.println("                   SELECT YOUR OPTION'S                             ");
	        System.out.println("                  ***********************                           ");
	        System.out.println("                      1].ADD PERSON'S                               ");
	        System.out.println("                      2].FETCH DETAIL'S                             ");
	        System.out.println("                      3].EXIST                                      ");
	        System.out.println("--------------------------------------------------------------------");
	   
	        int opt=sc.nextInt();
	        switch(opt)
	       {
	         case 1://add person
	        {	
	           PreparedStatement ps=con.prepareStatement("insert into CANARA_BANK values(?, ?, ?, ?)");
	           System.out.println("Enter your ID:");
	           int ID=sc.nextInt();
	           System.out.println("Enter your NAME:");
	           String NAME=sc.next();
	           System.out.println("Enter your BALANCE:");
	           int BALANCE=sc.nextInt();
	           System.out.println("Enter your PASSWORD");
	           String PASSWORD=sc.next();
	           System.out.println("Enter your secret key");
	           String key=sc.next();
	    
	           ps.setInt(1, ID);
	           ps.setString(2, NAME);
	           ps.setInt(3, BALANCE);
	           ps.setString(4, Access.encrypt(PASSWORD, key)); //password is encrypted..
	           System.out.println("data added...!");
	           ps.executeUpdate();
	       }
	       break;
	    
	    
	       case 2: //fetch
	       {
	           PreparedStatement ps1=con.prepareStatement("select * from CANARA_BANK where id=?");
	           System.out.println("Enter the ID:");
	           int ID1=sc.nextInt();
	           System.out.println("Enter your Secret key:");
	           String key=sc.next();
	           ps1.setInt(1, ID1);
	           ResultSet rs=ps1.executeQuery();
	            
	           while(rs.next())
	            {
	    	      System.out.println("ID:"+rs.getInt(1));
	    	      System.out.println("NAME:"+rs.getString(2));
	    	      System.out.println("BALANCE:"+rs.getInt(3));
	    	      System.out.println("PASSWORD:"+Access.decrypt(rs.getString(4), key)); //password is decrypted
	    	    }
	       }
	       break;
	    
	      case 3: //Exist
	      {
	    	flag=false;
	    	System.out.println("--------------------------------------------");
	    	System.out.println("Thank you for Using Canara Bank Application");
	    	System.out.println("--------------------------------------------");
	     }
	     break;
	    
	     default:
	     {
	    	System.out.println("You Entred Invallid Options.");
	    	System.out.println("Please Enter Correct options.");
	    	System.out.println("------------Thank you-----------");
	     }
	    
	    System.out.println(" ");
	    con.close();
        
        
        
	    }
      
	  }
	}

}
