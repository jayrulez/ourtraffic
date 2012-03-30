package extension.model;

import java.io.Serializable;
import java.util.Date;


public class Ticket implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ticketNumber;
	private Date offenseDate;
	private Address offensePlace;
	private String description;
	private Float fine;
	private Integer points;
	private Integer paymentStatus;
	private Offense offense;
	private Offender offender;
	private Police police;
	
	public Ticket() 
	{

	}
	public Ticket(Integer ticketNumber, Date offenseDate, Address offensePlace, String description, Float fine, Integer points, Integer payementStatus) 
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
	public Ticket(Integer ticketNumber, Date offenseDate, Address offensePlace, String description, Float fine, Integer points, Integer payementStatus, Offense offense) 
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
	public Ticket(Integer ticketNumber, Date offenseDate, Address offensePlace, String description, Float fine, Integer points, Integer payementStatus, Integer offenseCode) 
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
	public void setFine(Float fine) 
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
	public Float getFine() 
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
	public Offender getOffender() {
		return offender;
	}
	public void setOffender(Offender offender) {
		this.offender = offender;
	}
	public Police getPolice() {
		return police;
	}
	public void setPolice(Police police) {
		this.police = police;
	}
}