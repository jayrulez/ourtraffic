package extension.model;

import java.io.Serializable;


public class Address  implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address1;
	private String address2;
	private String parish;
	
	public Address() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public Address(String address1, String address2, String parish) 
	{
		this.address1 = address1;
		this.address2 = address2;
		this.parish = parish;
	}
	public String getAddress1() 
	{
		return address1;
	}
	public String getAddress2() 
	{
		return address2;
	}
	public String getParish()
	{
		return parish;
	}
	public void setAddress1(String address1) 
	{
		this.address1 = address1;
	}
	public void setAddress2(String address2) 
	{
		this.address2 = address2;
	}
	public void setParish(String parish) 
	{
		this.parish = parish;
	}
}