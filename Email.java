package EmailApp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private int defaultPasswordLength = 10 ;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "company.com";

	//Constructor to receive the first and last name
	
	public Email(String firstName, String lastName) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
		System.out.println("Email created: " + this.firstName + " " + this.lastName);
		
		// Call a method asking for the department then return the department
		this.department = setDepartment();
		System.out.println("Department: " + this.department);
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength); 
		System.out.println("Your Passworrd is : " + this.password);
		
		//Combine elements to generate email
		email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + companySuffix; 
		System.out.println("Your email is : " + email);
	}
	
	//Ask for department
	
	private String setDepartment() {
		System.out.print("New Worker: " + firstName + ". Department Codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) {return "Sales";}
		else if(depChoice == 2) {return "Dev";}
		else if(depChoice == 3) {return "Accounting";}
		else {return "";}
	}
	
	//Generate a password
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDDEFGHIJKLMNOPQRSTUVWXYZ012345678!@#$%";
		char[] password = new char[length];
		for(int i=1;i<length;i++) 
		{
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set the mail capacity
	
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	//Set the alternative email
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	//Change the password
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity(){return mailboxCapacity;}
	public String getAlternateEmail() {return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + " " +
		"\nCOMPANY EMAIL: " + email + " " +
		"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}

