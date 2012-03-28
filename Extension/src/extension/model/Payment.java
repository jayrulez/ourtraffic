package extension.model;

import java.util.Date;


public class Payment
{
	private Date paymentDate;
	private Double amount;
	
	private Ticket ticket;
	
	public Payment() 
	{
		// TODO Auto-generated constructor stub
	}
	public Payment(Date paymentDate, Double amount, Ticket ticket)
	{
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	public Double getAmount() 
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
	public void setAmount(Double amount) 
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