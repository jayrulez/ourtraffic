package extension.model;

import java.io.Serializable;
import java.util.Date;



public class User extends Person implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int ADMINISTRATOR = 1;
	public final static int TAXOFFICER = 3;
	public final static int POLICE = 2;
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
	
	public User(String firstName, String lastName, String middleInitial, Date dob, String address1, String address2, String parish, String accountPassword, Integer accountType, String handle) 
	{
		super(firstName, lastName, middleInitial, dob, address1,address2, parish);
		this.password = accountPassword;
		this.type = accountType;
		this.handle = handle;
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
	
	public static User copy (User targetUser)
	{
		User newUser = new User();
		
		newUser.password = targetUser.password;
		newUser.type = targetUser.type;
		newUser.handle = targetUser.handle;
		
		newUser.setFirstName(targetUser.getFirstName());
		newUser.setLastName(targetUser.getLastName());
		newUser.setMiddleInitial(targetUser.getMiddleInitial());
		newUser.setDob(targetUser.getDob());
		
		Address newAddress = new Address();
		
		newAddress.setAddress1(targetUser.getAddress().getAddress1());
		newAddress.setAddress2(targetUser.getAddress().getAddress2());
		newAddress.setParish(targetUser.getAddress().getParish());
		
		newUser.setAddress(newAddress);
		
		return newUser;
	}
}