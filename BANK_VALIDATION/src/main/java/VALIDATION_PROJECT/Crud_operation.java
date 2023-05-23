package VALIDATION_PROJECT;

import java.util.Scanner;

class Bank
{
	String name;
	String pwd;
	long number;
	String email;
	double balance=50000;
	
	static Scanner sc=new Scanner(System.in);
	
	void signUp(String name, String pwd, long number, String email)   //1]SIGNUP
	{
		this.name=name;
		this.pwd=pwd;
		this.number=number;
		this.email=email;
	    System.out.println("-----------Account has been Created-------------");
	}
	
	
	
	void logIn(String name2, String upwd)   //2]LOGIN
	{
		if(name.equals(name2) && this.pwd.equals(upwd))
		{
			
			boolean flag2=true;
			while(flag2)
			{
				System.out.println("------------------------------------------------------------------");
				System.out.println("  1].CHECK BALANCE\n  2].UPDATE NUMBER\n  3].WITH DRAW\n  4].CHANGE PASSWORD\n  5].DISPLAY DETAILS\n  6].EXIT ");
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
				    	System.out.println("Enter your Password");
				    	updateNumber(sc.next());
				    }
				    break;
				    
				    case 3:
				    {
				    	System.out.println("Enter your Password");
				    	withDraw(sc.next());
				    }
				    break;
				    
				    case 4:
				    {
				    	System.out.println("Enter your Password");
				    	changePwd(sc.next());
				    }
				    break;
				    
				    case 5:
				    {
				    	System.out.println("Enter your Password");
				    	details(sc.next());
				    	
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
	
	
	
	void checkBalance(String upwd)    // CHECK BALANCE
	{
		if(pwd.equals(upwd))
		{
			System.out.println("Balance :"+balance);
		}
		else
		{
			System.out.println("!---Incorrect Password---!");
		}
	}
	
	
	void updateNumber(String upwd) //UPDATE
	{
		if(pwd.equals(upwd))
		{
			System.out.println("Eneter your New Number");
			number=sc.nextLong();
			System.out.println("Data Updated...!");
		}
		else
		{
			System.out.println("!---Incorrect Password---!");
		}
	}
	
	
	void withDraw(String upwd)  //WITHDRAW
	{
		if(pwd.equals(upwd))
		{
			System.out.println("Enter the Amount");
			double  amount=sc.nextDouble();
			
			if(balance>=amount)
			{
				System.out.println("Take and Enjoy your self.....!");
				balance=balance-amount;
			}
			else
			{
				System.out.println("!---Invallid Amount---!");
			}
			
		}
		else
		{
			System.out.println("!---Incorrect Password---!");	    
		}
	}
	
	
	void changePwd(String upwd)   //CHANGE PASSWORD
	{
		if(this.pwd.equals(upwd))
		{
			System.out.println("Enter your New Password");
			String newpwd=sc.next();
			pwd=newpwd;
			System.out.println("Data Updated....!");
		}
		else
		{
			System.out.println("!---Incorrect Password---!");
		}
	}
	
	
	void details(String upwd)  //DISPLAY
	{
		if(pwd.equals(upwd))
		{
			System.out.println("Balance :"+balance);
			System.out.println("Name :"+name);
			System.out.println("Password :"+pwd);
			System.out.println("Number :"+number);
			System.out.println("Email :"+email);
			
		}
		else
		{
			System.out.println("!---Incorrect Password---!");
		}
		
	}
	
	
}


public class Crud_operation 
{

	public static void main(String[] args) 
	{
		Bank b=new Bank();
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
