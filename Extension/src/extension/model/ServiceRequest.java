package extension.model;

import java.io.Serializable;
import java.util.Vector;

public class ServiceRequest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//service types
	public static final int PING = 1; //Checks if the server application is online
	public static final int ADD_TICKET = 2; //Adds a new ticket to the data base
	public static final int GET_ALL_OFFENSES = 3;
	public static final int GET_TICKETS = 4;
	public static final int GET_OFFENDERS = 5; 
	public static final int TERMINATE_CONNECTION = 6;
	public static final int ISSUE_TICKET_EXISTING_OFFENDER = 7;
	public static final int ISSUE_TICKET_NEW_OFFENDER = 8;
	public static final int GET_OFFENDER = 9;
	public static final int GET_USER = 10;
	public static final int GET_USER_LOGIN = 11;
	public static final int GET_TICKET = 12;
	public static final int PAY_TICKET = 13;
	public static final int GET_OFFENSES = 14;
	
	private User currentUser;
	private Integer action;
	private Vector data;
	private String description;
	
	public ServiceRequest() 
	{
		this.setCurrentUser(null);
		this.action = 0;
		this.data = new Vector();
		this.description = "";
	}
	public ServiceRequest(Integer action) 
	{
		this.action = action;
		this.data = new Vector();
		this.description = "";
	}
	public ServiceRequest(Integer action, Vector data)
	{
		this.action = action;
		this.data = data;
	}

	public ServiceRequest(Integer action, Vector data, String description)
	{
		this.action = action;
		this.data = data;
		this.description = description;
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
	
	public void setAction(Integer action) 
	{
		this.action = action;
	}
	public void setData(Vector data) 
	{
		this.data = data;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}