package ticketserver.controller;

import java.sql.SQLException;
import java.util.Vector;

import ticketserver.model.SqlProvider;
import extension.model.Offender;
import extension.model.Offense;
import extension.model.ServiceRequest;
import extension.model.ServiceResponse;
import extension.model.Ticket;
import extension.model.User;

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
				//System.out.println("Ping received");
				this.serviceResponse.setResponse(ServiceResponse.SUCCESS);
			break;
			
			case ServiceRequest.ISSUE_TICKET_EXISTING_OFFENDER:
				Ticket ticket = null;
				if(!this.serviceRequest.getData().isEmpty())
				{
					ticket = (Ticket) this.serviceRequest.getData().firstElement();
					this.sqlProvider = new SqlProvider();
					try 
					{
						System.out.println(this.serviceRequest.getData().size());
						System.out.println("Police:" + ticket.getPolice().getBadgeNumber());
						int result = 0;
						result = this.sqlProvider.issueTicketExistingOffender(ticket.getPolice().getBadgeNumber(),ticket.getOffender().getTrnNumber() , ticket.getOffense().getOffenseCode(), ticket.getOffenseDate(), ticket.getOffensePlace().getAddress1(), ticket.getOffensePlace().getAddress2(), ticket.getOffensePlace().getParish(), ticket.getDescription(), ticket.getFine(), ticket.getPoints());
						
						this.serviceResponse.setStatus(result);
						System.out.println("Result:"+result);
						if (result == 0)
						{
							this.serviceResponse.setDescription("Could not issue this ticket to offender. Please try again.");
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
					catch(NullPointerException e)
					{
						e.printStackTrace();
						System.out.println("Error " + e);
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
			
			case ServiceRequest.ISSUE_TICKET_NEW_OFFENDER:
				Ticket newOffenderTicket = null;
				if(!this.serviceRequest.getData().isEmpty())
				{
					newOffenderTicket  = (Ticket) this.serviceRequest.getData().firstElement();
					this.sqlProvider = new SqlProvider();
					try 
					{
						int result = this.sqlProvider.issueTicketNewOffender(newOffenderTicket.getOffender().getTrnNumber(), newOffenderTicket.getOffender().getFirstName(), newOffenderTicket.getOffender().getLastName(),newOffenderTicket.getOffender().getMiddleInitial(), newOffenderTicket.getOffender().getDob(), newOffenderTicket.getOffender().getAddress().getAddress1(), newOffenderTicket.getOffender().getAddress().getAddress2(), newOffenderTicket.getOffender().getAddress().getParish(), newOffenderTicket.getOffender().getLicenseType(), newOffenderTicket .getOffender().getPoints(),newOffenderTicket.getOffender().getExpiryDate(), newOffenderTicket.getPolice().getBadgeNumber(), newOffenderTicket.getOffense().getOffenseCode(), newOffenderTicket.getOffenseDate(), newOffenderTicket.getOffensePlace().getAddress1(), newOffenderTicket.getOffensePlace().getAddress2(), newOffenderTicket.getOffensePlace().getParish(), newOffenderTicket.getDescription(), newOffenderTicket.getFine(), newOffenderTicket.getPoints());
		
						this.serviceResponse.setStatus(result);
					
						if (result == 0)
						{
							this.serviceResponse.setDescription("Could not issue this ticket to offender. Please try again.");
						}
						else if(result == -1)
						{
							this.serviceResponse.setDescription("Could not save this offender's information. Please try again.");
						}
						else if(result == -2)
						{
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
			
			case ServiceRequest.GET_OFFENDER:
				this.sqlProvider = new SqlProvider();
				try 
				{
					//offender to search for
					Offender targetOffender = (Offender) this.serviceRequest.getData().firstElement();
					
					//get the offender
					Vector<Offender> offenders = this.sqlProvider.getOffender(targetOffender.getTrnNumber());
					
					System.out.println("Server Received Data:"+offenders.size());
					//pass the result to the response
					this.serviceResponse.setData(offenders);
					
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
					System.out.println("Success Sent");
				}
			break;
			
			case ServiceRequest.GET_ALL_OFFENSES:
				
				this.sqlProvider = new SqlProvider();
				try 
				{
					Vector<Offense> offenses = this.sqlProvider.getAllOffenses();
					System.out.println("Server Received Data:"+offenses.size());
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
					System.out.println("Success Sent");
				}
			break;
			
			case ServiceRequest.GET_USER_LOGIN:
				this.sqlProvider = new SqlProvider();
				try 
				{
					User targetUser = (User) this.serviceRequest.getData().firstElement();
					
					Vector<User> users = this.sqlProvider.getUserLogin(targetUser.getHandle(),targetUser.getPassword());
					
					System.out.println("Server Received Data: "+users.firstElement().getFirstName());
					
					System.out.println("Server Received Data:"+users.size());
					this.serviceResponse.setData(users);
					
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
				catch(ClassCastException e)
				{
					System.out.println("Unexpected error occured.");
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					System.out.println(e.getErrorCode());
				}
				finally
				{
					this.serviceResponse.setResponse(ServiceResponse.SUCCESS);
					System.out.println("Success Sent");
				}
			break;
			
			case ServiceRequest.GET_TICKETS:
			break;
			
			case ServiceRequest.GET_TICKET:
				try
				{
					Ticket targetTicket = (Ticket) this.serviceRequest.getData().firstElement();
					
					Vector<Ticket> tickets = this.sqlProvider.getTicket(targetTicket.getTicketNumber());
					
					System.out.println("Server Received Data: "+tickets.firstElement().getTicketNumber());
					
					System.out.println("Server Received Data:"+tickets.size());
					this.serviceResponse.setData(tickets);
					
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
				catch(ClassCastException e)
				{
					System.out.println("Unexpected error occured.");
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					System.out.println(e.getErrorCode());
				}
				finally
				{
					this.serviceResponse.setResponse(ServiceResponse.SUCCESS);
					System.out.println("Success Sent");
				}			
			break;
			
			case ServiceRequest.TERMINATE_CONNECTION:
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