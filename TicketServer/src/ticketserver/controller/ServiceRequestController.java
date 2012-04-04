package ticketserver.controller;

import java.sql.SQLException;
import java.util.Vector;

import ticketserver.model.SqlProvider;
import extension.model.Offender;
import extension.model.Offense;
import extension.model.Payment;
import extension.model.ServiceRequest;
import extension.model.ServiceResponse;
import extension.model.TaxOfficer;
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
			
			case ServiceRequest.GET_OFFENSES:
				try
				{
					this.sqlProvider = new SqlProvider();
					if(!this.serviceRequest.getData().isEmpty())
					{
						Offense targetOffense = (Offense) this.serviceRequest.getData().firstElement();
						
						Vector<Offense> offenses = this.sqlProvider.getOffenses(targetOffense.getOffenseCode(),targetOffense.getOffenceName());

						this.serviceResponse.setData(offenses);
					}
					else
					{
						
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
				catch(ClassCastException e)
				{
					System.out.println("Unexpected error occured.");
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
					System.out.println("Success Sent");
				}
			
			case ServiceRequest.GET_OFFENDERS:
				try
				{
					this.sqlProvider = new SqlProvider();
					if(!this.serviceRequest.getData().isEmpty())
					{
						Offender targetOffender = (Offender) this.serviceRequest.getData().firstElement();
						
						Vector<Offender> offenders = this.sqlProvider.getOffenders(targetOffender.getTrnNumber(),targetOffender.getFirstName(), targetOffender.getLastName());

						this.serviceResponse.setData(offenders);
					}
					else
					{
						
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
				catch(ClassCastException e)
				{
					System.out.println("Unexpected error occured.");
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
					System.out.println("Success Sent");
				}
			break;
			
			case ServiceRequest.GET_OFFENDER:
				try 
				{
					this.sqlProvider = new SqlProvider();
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
				try 
				{
					this.sqlProvider = new SqlProvider();
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
				try 
				{
					this.sqlProvider = new SqlProvider();
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
				try
				{
					this.sqlProvider = new SqlProvider();
					if(!this.serviceRequest.getData().isEmpty())
					{
						Ticket targetTicket = (Ticket) this.serviceRequest.getData().firstElement();
						
						Vector<Ticket> tickets = this.sqlProvider.getTickets(targetTicket.getTicketNumber(),targetTicket.getOffender().getTrnNumber(),targetTicket.getPaymentStatus());

						this.serviceResponse.setData(tickets);
					}
					else
					{
						
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
				catch(ClassCastException e)
				{
					System.out.println("Unexpected error occured.");
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
					System.out.println("Success Sent");
				}	
			break;
			
			case ServiceRequest.GET_TICKET:	
				try
				{
					this.sqlProvider = new SqlProvider();
					if(!this.serviceRequest.getData().isEmpty())
					{
						Ticket targetTicket = (Ticket) this.serviceRequest.getData().firstElement();
						
						Vector<Ticket> tickets = this.sqlProvider.getTicket(targetTicket.getTicketNumber());

						this.serviceResponse.setData(tickets);
					}
					else
					{
						
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
				catch(ClassCastException e)
				{
					System.out.println("Unexpected error occured.");
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
					System.out.println("Success Sent");
				}			
			break;
			
			case ServiceRequest.PAY_TICKET:	
				try
				{
					this.sqlProvider = new SqlProvider();
					
					TaxOfficer taxOfficer = (TaxOfficer)this.serviceRequest.getData().firstElement();
					
					Payment targetPayment = taxOfficer.getPayments().firstElement();
					
					if(targetPayment != null && targetPayment.getTicket() != null)
					{
						//System.out.println("HEEEEEEEEEEEEEEEEEEEEEHHHHHHHHHEEEE: "+targetTicket.getTicketNumber());
						int result = 0;
						
						result = this.sqlProvider.payTicket(targetPayment.getTicket().getTicketNumber(),taxOfficer.getIdNumber(),targetPayment.getAmount());
						
						System.out.println("Server Ticket Payement Result: "+result);
						
						this.serviceResponse.setStatus(result);
						
						if (result == 0)
						{
							this.serviceResponse.setDescription("Could not pay this ticket. Please try again.");
						}
						else if(result == -1)
						{
							this.serviceResponse.setDescription("Could not access this ticket record. Please try again.");
						}
						else if(result == -2)
						{
							this.serviceResponse.setDescription("Could not save the payment information. Please try again.");
						}
					}
					else
					{
						this.serviceResponse.setStatus(-3);
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
				catch(ClassCastException e)
				{
					System.out.println("Unexpected error occured.");
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