package extension.model;

import java.io.Serializable;
import java.util.Date;


public class Administrator extends User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idNumber;
	
	public Administrator() 
	{
		super();
	}
	public Administrator(Integer idNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish) 
	{
		super(firstName, lastName, middleInitial, dob, address1, address2,parish);
		this.idNumber = idNumber;
	}
	
	public Administrator(Integer idNumber, String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish, String accountPassword, Integer accountType) 
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