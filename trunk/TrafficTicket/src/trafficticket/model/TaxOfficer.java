package trafficticket.model;

import java.util.Date;


public class TaxOfficer extends User
{
	private Integer idNumber;
	
	public TaxOfficer() 
	{
		super();
	}
	public TaxOfficer(Integer idNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish) 
	{
		super(firstName, lastName, middleInitial, dob, address1, address2,parish);
		this.idNumber = idNumber;
	}
	
	public TaxOfficer(Integer idNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish, String accountPassword, Integer accountType) 
	{
		super(firstName, lastName, middleInitial, dob, address1, address2,parish,accountPassword, accountType);
		this.idNumber = idNumber;
	}
	public void setIdeNumber(Integer idNumber) 
	{
		this.idNumber = idNumber;
	}
	
	public Integer getIdNumber() 
	{
		return idNumber;
	}
}