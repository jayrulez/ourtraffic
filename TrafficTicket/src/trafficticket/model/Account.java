package trafficticket.model;

public class Account
{
	public final static Integer ADMINISTRATOR = 1;
	public final static Integer TAXOFFICER = 2;
	public final static Integer POLICE = 3;
	
	private String password;
	private Integer type;
	
	public Account() 
	{
	
	}
	
	public Account(String password, Integer type) 
	{
		this.password = password;
		this.type = type;
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
}