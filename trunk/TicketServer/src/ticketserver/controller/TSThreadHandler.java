package ticketserver.controller;
import java.net.*;
import java.io.*;

import extension.model.ServiceRequest;
import extension.model.ServiceResponse;

class TSThreadHandler extends Thread
{
	private Socket socket;
	private ServiceRequestController requestController;

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
						this.requestController.setServiceRequest(serviceRequest);
						
						//process service request and produce a service response
						this.requestController.processServiceRequest();
						serviceResponse = this.requestController.getServiceResponse();
						
						//remove service request since a response is created
						serviceRequest = null;
						
						//send the response to the client
						objectOutputStream.writeObject(serviceResponse);
						objectOutputStream.flush();
						
						//remove the response since it is sent to the client
						serviceResponse = null;
					}
				}
				catch(IOException ex)
				{
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
	}
}