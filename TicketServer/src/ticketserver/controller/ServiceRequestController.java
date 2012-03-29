package ticketserver.controller;

import java.sql.SQLException;

import ticketserver.model.SqlProvider;
import extension.model.ServiceRequest;
import extension.model.ServiceResponse;
import extension.model.Ticket;

public class ServiceRequestController
{
	private ServiceRequest serviceRequest;
	private ServiceResponse serviceResponse;
	private SqlProvider sqlProvider;
	
	public ServiceRequestController() 
	{
		this.serviceResponse = null;
	}
	
	public ServiceRequestController(ServiceRequest serviceRequest)
	{
		this.serviceRequest = serviceRequest;
		this.serviceResponse = null;
	}

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}
	
	public void processServiceRequest()
	{
		this.serviceResponse = new ServiceResponse();
		switch(this.serviceRequest.getAction())
		{
			case ServiceRequest.PING:
				System.out.println("Ping received");
				this.serviceResponse.setResponse(ServiceResponse.SUCCESS);
			break;
			
			case ServiceRequest.ISSUE_TICKET_EXISTING_OFFENDER:
			break;
			
			case ServiceRequest.ISSUE_TICKET_NEW_OFFENDER:
				Ticket ticket = null;
				if(!this.serviceRequest.getData().isEmpty())
				{
					ticket = (Ticket) this.serviceRequest.getData().firstElement();
					this.sqlProvider = new SqlProvider();
					try 
					{
						
						int result = this.sqlProvider.issueTicketNewOffender(ticket.getOffender().getTrnNumber(), ticket.getOffender().getFirstName(), ticket.getOffender().getLastName(),ticket.getOffender().getMiddleInitial(), ticket.getOffender().getDob(), ticket.getOffender().getAddress().getAddress1(), ticket.getOffender().getAddress().getAddress2(), ticket.getOffender().getAddress().getParish(), ticket.getOffender().getLicenseType(), ticket.getOffender().getPoints(),ticket.getOffender().getExpiryDate(), ticket.getPolice().getBadgeNumber(), ticket.getOffense().getOffenseCode(), ticket.getOffenseDate(), ticket.getOffensePlace().getAddress1(), ticket.getOffensePlace().getAddress2(), ticket.getOffensePlace().getParish(), ticket.getDescription(), ticket.getFine(), ticket.getPoints());
						if(result == 0)
						{
							//error adding offender ticket
						}
						else if(result == -1)
						{
							//error adding offender
						}
						else if(result == -2)
						{
							//error adding ticket
						}
					} 
					catch (ClassNotFoundException e) 
					{
						
						e.printStackTrace();
					} 
					catch (InstantiationException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					catch (IllegalAccessException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					catch (SQLException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
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

	public ServiceResponse getServiceResponse() 
	{
		return serviceResponse;
	}

	public void setServiceResponse(ServiceResponse serviceResponse) 
	{
		this.serviceResponse = serviceResponse;
	}
	
}