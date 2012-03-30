package trafficticket.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import trafficticket.model.Connection;

import extension.model.ServiceRequest;
import extension.model.ServiceResponse;


public class ConnectionController
{
	private ServiceResponse successServiceResponse;
	private ServiceRequest serviceRequest;
	private ServiceResponse serviceResponse;
	private ConnectionProvider connectionProvider;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	private Socket socket;
	private boolean dialogueSuccess;
	private boolean dialogueTerminated;
	public ConnectionController() 
	{
		this.dialogueSuccess = false;
		this.dialogueTerminated = false;
	}
	
	public ConnectionController(ServiceRequest serviceRequest) 
	{
		this.dialogueSuccess = false;
		this.dialogueTerminated = false;
		this.serviceRequest = serviceRequest;
	}
	
	public void submitRequest() throws SAXException, IOException, ParserConfigurationException, UnknownHostException, NumberFormatException, ClassNotFoundException
	{
		this.connectionProvider = new ConnectionProvider();
		
		//attempt to connect to ticket server
		this.connectionProvider.connectTicketServer();
		Connection connection = this.connectionProvider.getConnection(); 
		socket = connection.getSocket();
		
		//connect to the server and get the output stream of that connection
		this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		this.objectInputStream = new ObjectInputStream(socket.getInputStream());
			
		//send request to the server
		this.objectOutputStream.writeObject(this.serviceRequest);
		this.objectOutputStream.flush();
		
		//remove the request since the request is already sent
		this.serviceRequest = null;
		
		while(true)
		{		
			//get response from server
			try
			{
				this.readData();
				
				//if a response is received
				if(this.serviceResponse != null)
				{
					this.writeData();
					this.serviceResponse = null;
				}
			}
			catch(IOException ex)
			{
				this.objectInputStream.close();
				this.objectOutputStream.close();
				break;
			}
		}
	}

	public void writeData() throws IOException
	{
		switch(this.serviceResponse.getResponse())
		{
			//server agreed to terminate the  connection so let's terminate
			case ServiceResponse.TERMINATE_CONNECTION:
				this.dialogueTerminated = true;
				System.out.println("Client received TERMINATE from server");
				
				//close connection
				this.socket.close();
				System.out.println("client socket closed");
			break;
			
			//server has successfully received the request
			case ServiceResponse.SUCCESS:
				this.dialogueSuccess = true;
				this.successServiceResponse.copy(this.serviceResponse);
				System.out.println("Success received from server");
				
				//prepare a request to terminate the connection
				this.serviceRequest = new ServiceRequest(ServiceRequest.TERMINATE_CONNECTION);
				
				//send the request to terminate the connection 
				this.objectOutputStream.writeObject(this.serviceRequest);
				this.objectOutputStream.flush();
				
				//delete the request to terminate the connection since we have sent it
				this.serviceRequest = null;
				System.out.println("Clients sends TERMINATE");
			break;	
		}		
	}

	public void readData() throws ClassNotFoundException, IOException
	{
		//get response from server
		this.serviceResponse = (ServiceResponse)this.objectInputStream.readObject();
	}
	
	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}
	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}

	public ServiceResponse getServiceResponse() {
		return serviceResponse;
	}

	public void setServiceResponse(ServiceResponse serviceResponse) {
		this.serviceResponse = serviceResponse;
	}

	public boolean isDialogSuccess() 
	{
		return this.dialogueSuccess;
	}
	
	public ServiceResponse getSuccessServiceResponse() 
	{
		return successServiceResponse;
	}
}