package extension.model;

import java.util.ArrayList;
import java.util.Date;




public class Police extends User
{
	private String badgeNumber;
	
	private Division division;
	
	private ArrayList<Ticket> tickets; 
	
	public Police() 
	{
		super();
	}
	public Police(String badgeNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish,Division divison) 
	{
		super(firstName, lastName, middleInitial, dob, address1, address2,parish);
		this.badgeNumber = badgeNumber;
		this.division = divison;
	}
	
	public Police(String badgeNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish, Division divison, String accountPassword, Integer accountType) 
	{
		super(firstName, lastName, middleInitial, dob, address1, address2,parish,accountPassword, accountType);
		this.badgeNumber = badgeNumber;
		this.division = divison;
	}

	public Police(String badgeNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish, String accountPassword, Integer accountType) 
	{
		super(firstName, lastName, middleInitial, dob, address1, address2,parish,accountPassword, accountType);
		this.badgeNumber = badgeNumber;
	}
	
	public void setBadgeNumber(String badgeNumber) 
	{
		this.badgeNumber = badgeNumber;
	}
	
	public void setDivision(Division division) 
	{
		this.division = division;
	}
	public Division getDivision()
	{
		return division;
	}
	public String getBadgeNumber() 
	{
		return badgeNumber;
	}
	public void addTicket(Ticket ticket)
	{
		tickets.add(ticket);
	}
}