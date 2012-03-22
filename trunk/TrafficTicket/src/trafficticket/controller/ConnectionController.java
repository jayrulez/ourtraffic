package trafficticket.controller;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import trafficticket.config.Configuration;
import trafficticket.model.Connection;

public class ConnectionController
{
	private Connection connection;
	private Configuration configuration;
	
	public ConnectionController() 
	{
	}
	
	public void connectTicketServer() throws UnknownHostException, IllegalArgumentException, SAXException, IOException, ParserConfigurationException
	{

		this.configuration = new Configuration();
		this.connection = this.configuration.getConnection("Ticket Server");
	}
	
	public void setConnection(Connection connection) 
	{
		this.connection = connection;
	}
	
	public Connection getConnection() 
	{
		return connection;
	}
}