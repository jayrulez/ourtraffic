package extension.model;

import java.util.Date;


public class Ticket
{
	private Integer ticketNumber;
	private Date offenseDate;
	private Address offensePlace;
	private String description;
	private Double fine;
	private Integer points;
	private Integer paymentStatus;
	private Offense offense;
	
	public Ticket() 
	{
		// TODO Auto-generated constructor stub
	}
	public Ticket(Integer ticketNumber, Date offenseDate, Address offensePlace, String description, Double fine, Integer points, Integer payementStatus) 
	{
		this.description = description;
		this.fine = fine;
		this.offenseDate = offenseDate;
		this.offensePlace = offensePlace;
		this.paymentStatus = payementStatus;
		this.points = points;
		this.ticketNumber = ticketNumber;
		this.offense = null;
	}
	public Ticket(Integer ticketNumber, Date offenseDate, Address offensePlace, String description, Double fine, Integer points, Integer payementStatus, Offense offense) 
	{
		this.description = description;
		this.fine = fine;
		this.offenseDate = offenseDate;
		this.offensePlace = offensePlace;
		this.paymentStatus = payementStatus;
		this.points = points;
		this.ticketNumber = ticketNumber;
		this.offense = offense;
	}
	public Ticket(Integer ticketNumber, Date offenseDate, Address offensePlace, String description, Double fine, Integer points, Integer payementStatus, Integer offenseCode) 
	{
		this.description = description;
		this.fine = fine;
		this.offenseDate = offenseDate;
		this.offensePlace = offensePlace;
		this.paymentStatus = payementStatus;
		this.points = points;
		this.ticketNumber = ticketNumber;
		this.offense = new Offense(offenseCode);
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public void setOffenseDate(Date offenseDate) 
	{
		this.offenseDate = offenseDate;
	}
	public void setOffensePlace(Address offensePlace) 
	{
		this.offensePlace = offensePlace;
	}
	public void setFine(Double fine) 
	{
		this.fine = fine;
	}
	public void setTicketNumber(Integer ticketNumber) 
	{
		this.ticketNumber = ticketNumber;
	}
	public void setPaymentStatus(Integer paymentStatus) 
	{
		this.paymentStatus = paymentStatus;
	}
	public void setPoints(Integer points) 
	{
		this.points = points;
	}
	public String getDescription() 
	{
		return description;
	}
	public Date getOffenseDate() 
	{
		return offenseDate;
	}
	public Address getOffensePlace() 
	{
		return offensePlace;
	}
	public Integer getPaymentStatus() 
	{
		return paymentStatus;
	}
	public Double getFine() 
	{
		return fine;
	}
	public Integer getPoints() 
	{
		return points;
	}
	public Integer getTicketNumber() 
	{
		return ticketNumber;
	}
	public Offense getOffense() 
	{
		return offense;
	}
	public void setOffense(Offense offense) 
	{
		this.offense = offense;
	}
}