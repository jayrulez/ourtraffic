package extension.model;

import java.io.Serializable;
import java.util.Date;


public class Payment implements Serializable
{
	private Date paymentDate;
	private Float amount;
	
	private Ticket ticket;
	
	public Payment() 
	{
		
	}
	public Payment(Date paymentDate, Float amount, Ticket ticket)
	{
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	public Float getAmount() 
	{
		return amount;
	}
	public Date getPaymentDate() 
	{
		return paymentDate;
	}
	public Ticket getTicket() 
	{
		return ticket;
	}
	public void setAmount(Float amount) 
	{
		this.amount = amount;
	}
	public void setPaymentDate(Date paymentDate) 
	{
		this.paymentDate = paymentDate;
	}

	public void setTicket(Ticket ticket) 
	{
		this.ticket = ticket;
	}
}