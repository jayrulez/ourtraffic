package extension.model;

import java.util.Vector;

public class ServiceRequest
{
	//service types
	public static final Integer PING = 1; //Checks if the server application is online
	public static final Integer ADD_TICKET = 2; //Adds a new ticket to the data base
	public static final Integer GET_OFFENSES = 3;
	public static final Integer GET_TICKETS = 4;
	public static final Integer GET_OFFENDERS = 5; 
	
	private Integer action;
	private Vector data;
	private String description;
	
	public ServiceRequest() 
	{
		this.action = 0;
		this.data = new Vector();
		this.description = "";
	}
	
	public Integer getAction() 
	{
		return action;
	}
	
	public Vector getData() 
	{
		return data;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setAction(Integer action) {
		this.action = action;
	}
	public void setData(Vector data) {
		this.data = data;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
}