package trafficticket.model;

public class Division
{
	private Integer stationNumber;
	private String stationTele;
	private Address address;
	
	public Division() 
	{
		this.address = null;
	}
	
	public Division(Integer stationNumber, String stationTele, Address address) 
	{
		this.stationNumber = stationNumber;
		this.stationTele = stationTele;
		this.address = address;
	}
	
	public Division(Integer stationNumber) 
	{
		this.stationNumber = stationNumber;
	}
	
	public Division(Integer stationNumber, String stationTele, String address1, String address2, String parish) 
	{
		this.stationNumber = stationNumber;
		this.stationTele = stationTele;
		this.address = new Address(address1, address2,parish);
	}
	
	public void setAddress(Address address) 
	{
		this.address = address;
	}
	public void setStationNumber(Integer stationNumber) 
	{
		this.stationNumber = stationNumber;
	}
	public void setStationTele(String stationTele) 
	{
		this.stationTele = stationTele;
	}
	public Address getAddress() 
	{
		return address;
	}
	public Integer getStationNumber() 
	{
		return stationNumber;
	}
	public String getStationTele() 
	{
		return stationTele;
	}
}