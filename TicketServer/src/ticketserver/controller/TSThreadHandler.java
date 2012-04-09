package ticketserver.controller;
import java.net.*;
import java.io.*;

import ticketserver.view.TicketServerFrame;

import extension.model.ServiceRequest;
import extension.model.ServiceResponse;

class TSThreadHandler implements Runnable
{
	private Socket socket;
	private ServiceRequestController requestController;
	private TicketServerFrame parentFrame;
	TSThreadHandler(Socket socket)
	{
		this.socket = socket;
		this.requestController = new ServiceRequestController();
	}
	
	
	public void run()
	{
		try
		{
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
			ObjectInputStream objectInputStream = new ObjectInputStream(this.socket.getInputStream());
			
			ServiceRequest serviceRequest = null;
			ServiceResponse serviceResponse = null; 
			
			while(true)
			{
				try
				{
					//get a request
					serviceRequest = (ServiceRequest) objectInputStream.readObject();
					
					//if a request is received
					if(serviceRequest != null)
					{
						if(serviceRequest.getAction() == ServiceRequest.PING)
						{

							this.parentFrame.addUser(serviceRequest.getCurrentUser());
							System.out.println("Current User : "+this.parentFrame.getCurrentClients());
							
						}
						this.requestController.setServiceRequest(serviceRequest);
						
						//process service request and produce a service response
						this.requestController.processServiceRequest();
						
						serviceResponse = this.requestController.getServiceResponse();
						
						//remove service request since a response is created
						serviceRequest = null;
						
						System.out.println("Before write");
						System.out.println("Server Sent Data:"+serviceResponse.getData().size());
						//send the response to the client
						System.out.println("Stream info:"+objectOutputStream);
						objectOutputStream.writeObject(serviceResponse);
						System.out.println("Server Sent Data:"+serviceResponse.getData().size());
						System.out.println("Written");
						objectOutputStream.flush();
						//remove the response since it is sent to the client
					}
				}
				catch(IOException ex)
				{
					
					System.out.println("exception:"+ex);
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
	}


	public TicketServerFrame getParentFrame() {
		return parentFrame;
	}


	public void setParentFrame(TicketServerFrame parentFrame) {
		this.parentFrame = parentFrame;
	}
}