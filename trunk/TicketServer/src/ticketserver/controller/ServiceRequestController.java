package ticketserver.controller;

import extension.model.ServiceRequest;
import extension.model.ServiceResponse;

public class ServiceRequestController
{
	private ServiceRequest serviceRequest;
	private ServiceResponse serviceResponse;
	
	public ServiceRequestController() 
	{
		this.serviceResponse = null;
		this.serviceResponse = new ServiceResponse();
	}
	
	public ServiceRequestController(ServiceRequest serviceRequest)
	{
		this.serviceRequest = serviceRequest;
		this.serviceResponse = new ServiceResponse();
	}

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}
	
	public void processServiceRequest()
	{
		switch(this.serviceRequest.getAction())
		{
			case ServiceRequest.PING:
				System.out.println("Ping received");
				this.serviceResponse.setResponse(ServiceResponse.SUCCESS);
			break;
			
			case ServiceRequest.ADD_TICKET:
			break;
			
			case ServiceRequest.GET_OFFENDERS:
			break;
			
			case ServiceRequest.GET_OFFENSES:
			break;
			
			case ServiceRequest.GET_TICKETS:
			break;
			
			case ServiceRequest.TERMINATE_CONNECTION:
				System.out.println("terminate received");
				this.serviceResponse.setResponse(ServiceResponse.TERMINATE_CONNECTION);
			break;
				
			default:
				this.serviceResponse.setResponse(ServiceResponse.INVALID_REQUEST);
		}
	}

	public ServiceResponse getServiceResponse() {
		return serviceResponse;
	}

	public void setServiceResponse(ServiceResponse serviceResponse) {
		this.serviceResponse = serviceResponse;
	}
	
}