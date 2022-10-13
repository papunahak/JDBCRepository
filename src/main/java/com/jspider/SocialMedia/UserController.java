package com.jspider.SocialMedia;

import java.util.Scanner;

public class UserController {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		UserDriver driver=new UserDriver();
		boolean b=true;
		try {
		while(b) {
			System.out.println("press 1 saveUser");
			System.out.println("press 2 updateUser");
			System.out.println("press 3 deleteUser");
			System.out.println("press 4 getAll user");
			System.out.println("press 5 to getUserById");
			System.out.println("press 6 to exit");
			int choice=sc.nextInt();
			switch(choice) 
			{
			case 1:
			{
				User user=new User();
			    //System.out.println("Enter id:");
				//user.setId(sc.nextInt());
				System.out.println("Enter the name:");
				user.setName(sc.next());
				System.out.println("enter the mail:");
				user.setEmail(sc.next());
				System.out.println("Enter the password");
				user.setPassword(sc.next());
				System.out.println("ente the mediatype:");
				user.setMediaType(sc.next());
				System.out.println("enter the phoneno:");
				user.setPhoneno(sc.next());
				driver.saveUser(user);				
			}
			break;
			case 2:
			{
				User user=new User();
				System.out.println("Enter id:");
				user.setId(sc.nextInt());
				System.out.println("Enter the name:");
				user.setName(sc.next());
				System.out.println("enter the mail:");
				user.setEmail(sc.next());
				System.out.println("Enter the password");
				user.setPassword(sc.next());
				System.out.println("ente the mediatype:");
				user.setMediaType(sc.next());
				System.out.println("enter the password:");
				user.setPhoneno(sc.next());
				driver.updateUser(user);
			}
			break;
			case 3:
			{
				System.out.println("Enter the id to delete the user:");
				int id=sc.nextInt();
				driver.deleteUser(id);
			}
			break;
			case 4:
			{
				driver.getAllUser();
			}
			break;
			case 5:
			{
				System.out.println("enter the id");
				int id=sc.nextInt();
			 	System.out.println("enter the email");
				String email=sc.next();
				System.out.println("enter the password");
				String password=sc.next();
			}
			break;
			case 6:
			{
				b=false;
			}
			default:
			{
				System.out.println("invalid choice");
			}
		  }
		}
		}
		catch(InputMismatchException e) {
			System.out.println("enter valid input");
		}
	}
}
