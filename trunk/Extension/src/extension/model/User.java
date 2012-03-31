package extension.model;

import java.io.Serializable;
import java.util.Date;



public class User extends Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static Integer ADMINISTRATOR = 1;
	public final static Integer TAXOFFICER = 2;
	public final static Integer POLICE = 3;
	private String handle;
	private String password;
	private Integer type;
	
	 
	public User() 
	{
		super();
	}
	
	public User(String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish) 
	{
		super(firstName, lastName, middleInitial, dob, address1,address2, parish);
	}
	
	public User(String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish, String accountPassword, Integer accountType) 
	{
		super(firstName, lastName, middleInitial, dob, address1,address2, parish);
		this.password = accountPassword;
		this.type = accountType;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public void setType(Integer type) 
	{
		this.type = type;
	}
	public String getPassword() 
	{
		return password;
	}
	public Integer getType() 
	{
		return type;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}
}