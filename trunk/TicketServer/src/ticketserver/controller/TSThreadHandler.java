package ticketserver.controller;
import java.net.*;
import java.io.*;

import extension.model.ServiceRequest;
import extension.model.ServiceResponse;

class TSThreadHandler extends Thread
{
	private Socket socket;
	private int requestId;
	private ServiceRequestController requestController;

	TSThreadHandler(Socket socket, int requestId)
	{
		this.socket    = socket;
		this.requestId = requestId;
		this.requestController = new ServiceRequestController();
	}

	public void run()
	{
		try
		{
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.socket.getOutputStream());
			ObjectInputStream objectInputStream = new ObjectInputStream(this.socket.getInputStream());
			
			ServiceRequest serviceRequest;
			ServiceResponse serviceResponse;
			
			while(objectInputStream != null)
			{
				try
				{
					serviceRequest = (ServiceRequest) objectInputStream.readObject();
					//System.out.println("available:"+objectInputStream.available());
					//System.out.println(serviceRequest.getAction());
					this.requestController.setServiceRequest(serviceRequest);
					
					this.requestController.processServiceRequest();
					serviceResponse = this.requestController.getServiceResponse();
					
					objectOutputStream.writeObject(serviceResponse);
					System.out.println("Server says:"+serviceResponse.getResponse());
					
				}
				catch(IOException ex)
				{
					
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
	}
}