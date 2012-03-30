package ticketserver.controller;

import java.sql.SQLException;
import java.util.Vector;

import ticketserver.model.SqlProvider;
import extension.model.Offense;
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
							this.serviceResponse.setStatus(result);
							this.serviceResponse.setDescription("Could not issue this ticket to offender. Please try again.");
						}
						else if(result == -1)
						{
							this.serviceResponse.setStatus(result);
							this.serviceResponse.setDescription("Could not save this offender's information. Please try again.");
						}
						else if(result == -2)
						{
							this.serviceResponse.setStatus(result);
							this.serviceResponse.setDescription("Could not save this ticket information. Please try again.");
						}
					} 
					catch (ClassNotFoundException e) 
					{
						
						System.out.println(e.getMessage());
					} 
					catch (InstantiationException e) 
					{
						System.out.println("Unexpected error occured.");
					} 
					catch (IllegalAccessException e) 
					{
						System.out.println("Access to the Data Server denied.");
					} 
					catch (SQLException e) 
					{
						// TODO Auto-generated catch block
						System.out.println(e.getErrorCode());
					}
					finally
					{
						this.serviceResponse.setResponse(ServiceResponse.SUCCESS);
					}
				}
				else
				{
					this.serviceResponse.setResponse(ServiceResponse.SUCCESS);
				}
			break;	
			
			case ServiceRequest.ADD_TICKET:
			break;
			
			case ServiceRequest.GET_OFFENDERS:
			break;
			
			case ServiceRequest.GET_ALL_OFFENSES:
				
				this.sqlProvider = new SqlProvider();
				try 
				{
					Vector<Offense> offenses = this.sqlProvider.getAllOffenses();
					this.serviceResponse.setData(offenses);
				} 
				catch (ClassNotFoundException e) 
				{
					
					System.out.println(e.getMessage());
				} 
				catch (InstantiationException e) 
				{
					System.out.println("Unexpected error occured.");
				} 
				catch (IllegalAccessException e) 
				{
					System.out.println("Access to the Data Server denied.");
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					System.out.println(e.getErrorCode());
				}
				finally
				{
					this.serviceResponse.setResponse(ServiceResponse.SUCCESS);
				}
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