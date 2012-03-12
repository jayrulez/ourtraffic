package trafficticket.model;

import java.util.Date;


public class Police extends User
{
	private Integer badgeNumber;
	
	public Police() 
	{
		super();
	}
	public Police(Integer badgeNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish) 
	{
		super(firstName, lastName, middleInitial, dob, address1, address2,parish);
		this.badgeNumber = badgeNumber;
	}
	
	public void setBadgeNumber(Integer badgeNumber) 
	{
		this.badgeNumber = badgeNumber;
	}
	
	public Integer getBadgeNumber() 
	{
		return badgeNumber;
	}
}