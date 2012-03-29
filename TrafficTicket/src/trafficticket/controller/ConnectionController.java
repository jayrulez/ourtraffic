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
	private ServiceRequest serviceRequest;
	private ServiceResponse serviceResponse;
	private ConnectionProvider connectionProvider;
	private ObjectOutputStream objectOutputStream;
	private ObjectInputStream objectInputStream;
	
	public ConnectionController() 
	{
		this.serviceResponse = new ServiceResponse();
		this.serviceRequest = new ServiceRequest();
	}
	
	public ConnectionController(ServiceRequest serviceRequest) 
	{
		// TODO Auto-generated constructor stub
		this.serviceRequest = serviceRequest;
		this.serviceResponse = new ServiceResponse();
	}
	
	public void submitRequest() throws SAXException, IOException, ParserConfigurationException, UnknownHostException, NumberFormatException, ClassNotFoundException
	{
		this.connectionProvider = new ConnectionProvider();
		
		//attempt to connect to ticket server
		this.connectionProvider.connectTicketServer();
		Connection connection = this.connectionProvider.getConnection(); 
		Socket socket = connection.getSocket();
		
		//connect to the server and get the output stream of that connection
		this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		this.objectInputStream = new ObjectInputStream(socket.getInputStream());
		
		//send service request
		this.objectOutputStream.writeObject(this.serviceRequest);
		
		//wait for service response
		while(this.objectInputStream != null)
		{		
			try
			{
				//read server response
				//this.serviceResponse = (ServiceResponse) this.objectInputStream.readObject();
				//System.out.println("server response:"+serviceResponse.getResponse());
				//send response to terminate connection
				
				if(this.serviceResponse.getResponse() == ServiceResponse.TERMINATE_CONNECTION)
				{
					System.out.println("Client received TERMINATE from server");
					//close connection
					socket.close();
					System.out.println("client socket closed");
				}
				if(this.serviceResponse.getResponse() == ServiceResponse.SUCCESS)
				{	
					System.out.println("Success received from server");
					this.objectOutputStream.writeObject(new ServiceRequest(ServiceRequest.TERMINATE_CONNECTION));
					System.out.println("Clients sends TERMINATE");
					
					//read server response
					this.serviceResponse = (ServiceResponse) this.objectInputStream.readObject();
					System.out.println("server response:"+serviceResponse.getResponse());
					//send response to terminate connection
				}
			}
			catch(IOException ex)
			{
				
			}
		}
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
}