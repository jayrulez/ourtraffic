package trafficticket.model;

public class Offense
{
	private Integer offenseCode;
	private String offenceName;
	
	public Offense() 
	{
		// TODO Auto-generated constructor stub
	}
	public Offense(Integer offenseCode, String offenseName) 
	{
		this.offenceName = offenseName;
		this.offenseCode = offenseCode;
	}
	
	public Offense(Integer offenseCode) 
	{
		this.offenseCode = offenseCode;
	}
	
	public void setOffenceName(String offenceName) 
	{
		this.offenceName = offenceName;
	}
	public void setOffenseCode(Integer offenseCode) 
	{
		this.offenseCode = offenseCode;
	}
	public String getOffenceName() 
	{
		return offenceName;
	}
	public Integer getOffenseCode() 
	{
		return offenseCode;
	}
}