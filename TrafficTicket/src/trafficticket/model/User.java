package trafficticket.model;

import java.util.Date;


public class User extends Person
{
	private Account account;
	
	public User() 
	{
		super();
	}
	public User(String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish) 
	{
		super(firstName, lastName, middleInitial, dob, address1,address2, parish);
	}
	public User(String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish, Account account) 
	{
		super(firstName, lastName, middleInitial, dob, address1,address2, parish);
		this.account = account;
	}
	public User(String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish, String accountPassword, Integer accountType) 
	{
		super(firstName, lastName, middleInitial, dob, address1,address2, parish);
		account = new Account(accountPassword,accountType);
		
	}
}