package extension.model;

import java.io.Serializable;
import java.util.Date;



public class Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String middleInitial;
	private Date dob;
	private Address address;
	
	public Person() 
	{
		// TODO Auto-generated constructor stub
	}
	public Person(String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.dob = dob;
		this.address = new Address(address1, address2, parish);
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	public void setMiddleInitial(String middleInitial) 
	{
		this.middleInitial = middleInitial;
	}
	public void setDob(Date dob) 
	{
		this.dob = dob;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public String getMiddleInitial() 
	{
		return middleInitial;
	}
	public Date getDob() 
	{
		return dob;
	}
	public void setAddress(Address address) 
	{
		this.address = address;
	}
	public Address getAddress() 
	{
		return address;
	}
}