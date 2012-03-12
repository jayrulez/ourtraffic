package trafficticket.model;

import java.util.ArrayList;
import java.util.Date;

public class Offender extends Person
{
	private Integer trnNumber;
	private String licenseType;
	private Integer points;
	private Date expiryDate;
	
	private ArrayList<Ticket> tickets;
	
	public Offender() 
	{
		super();
	}
	public Offender(Integer trnNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish,String licenseType,Integer points, Date expiryDate) 
	{
		super(firstName, lastName, middleInitial, dob, address1, address2,parish);
		this.trnNumber = trnNumber;
		this.licenseType = licenseType;
		this.points = points;
		this.expiryDate = expiryDate;
	}
	public void setTrnNumber(Integer trnNumber) 
	{
		this.trnNumber = trnNumber;
	}
	public void setPoints(Integer points) 
	{
		this.points = points;
	}
	public void setExpiryDate(Date expiryDate) 
	{
		this.expiryDate = expiryDate;
	}
	public void setLicenseType(String licenseType) 
	{
		this.licenseType = licenseType;
	}
	public Integer getTrnNumber() 
	{
		return trnNumber;
	}
	public String getLicenseType() 
	{
		return licenseType;
	}
	public Integer getPoints() 
	{
		return points;
	}
	public Date getExpiryDate() 
	{
		return expiryDate;
	}
	public void addTicket(Ticket ticket)
	{
		this.tickets.add(ticket);
	}
	public ArrayList<Ticket> getTickets() 
	{
		return tickets;
	}
	public Ticket getPayment(Ticket ticket)
	{
		if(!this.tickets.isEmpty())
		{
			for(Ticket iTicket : this.tickets)
			{
				if(iTicket.getTicketNumber() ==  ticket.getTicketNumber())
				{
					return iTicket;
				}
			}
		}
		return null;
	}
}