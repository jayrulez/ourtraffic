package extension.model;

import java.io.Serializable;
import java.util.Vector;

public class ServiceResponse implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//response codes
	public static final int TERMINATE_CONNECTION = 1;
	public static final int SUCCESS = 2;
	public static final int INVALID_REQUEST = 3;
	
	private Integer response;
	private Vector data;
	private Integer status;
	private String description;
	
	public ServiceResponse() 
	{
		this.response  = 0;
		this.status = 0;
		this.data = new Vector();;
	}
	
	public Integer getResponse() 
	{
		return response;
	}
	public void setResponse(Integer response) 
	{
		this.response = response;
	}
	public Vector getData() 
	{
		return data;
	}
	public void setData(Vector data) 
	{
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public static ServiceResponse copy(ServiceResponse serviceResponse)
	{
		ServiceResponse newServiceRespose = new ServiceResponse();
		newServiceRespose.data = serviceResponse.data;
		newServiceRespose.description = serviceResponse.description;
		newServiceRespose.response = serviceResponse.response;
		newServiceRespose.status = serviceResponse.status;
		return newServiceRespose;
	}
}