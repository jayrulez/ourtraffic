package extension.model;

import java.util.Date;
import java.util.Vector;



public class TaxOfficer extends User
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idNumber;
	private Vector <Payment> payments;
	public TaxOfficer() 
	{
		super();
		this.payments = new Vector<Payment>();
	}
	public TaxOfficer(String idNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish) 
	{
		super(firstName, lastName, middleInitial, dob, address1, address2,parish);
		this.idNumber = idNumber;
		this.payments = new Vector<Payment>();
	}
	
	public TaxOfficer(String idNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish, String accountPassword, Integer accountType) 
	{
		super(firstName, lastName, middleInitial, dob, address1, address2,parish,accountPassword, accountType);
		this.idNumber = idNumber;
		this.payments = new Vector<Payment>();
	}
	public void setIdNumber(String idNumber) 
	{
		this.idNumber = idNumber;
	}
	
	public String getIdNumber() 
	{
		return idNumber;
	}
	
	public void addPayment(Payment payment) {
		this.payments.add(payment);
	}
	
	public Payment getPayment(Payment payment)
	{
		if(!this.payments.isEmpty())
		{
			for(Payment iPayment : this.payments)
			{
				if(iPayment.getTicket().getTicketNumber() ==  payment.getTicket().getTicketNumber())
				{
					return iPayment;
				}
			}
		}
		return null;
	}
	public Vector<Payment> getPayments() 
	{
		return payments;
	}
}