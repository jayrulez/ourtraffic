package trafficticket.model;

import java.io.IOException;
import java.net.Socket;

public class Connection
{
	private String serverIpAddress;
	private Integer serverPort;
	public Connection(String serverIpAddress, Integer serverPort) 
	{
		this.serverPort = serverPort;
		this.serverIpAddress = serverIpAddress;
	}
	public void setServerPort(Integer serverPort) 
	{
		this.serverPort = serverPort;
	}
	public void setServerIpAddress(String serverIpAddress) 
	{
		this.serverIpAddress = serverIpAddress;
	}
	public String getServerIpAddress() 
	{
		return serverIpAddress;
	}
	public Integer getServerPort() 
	{
		return serverPort;
	}
	public Socket getSocket() throws IOException
	{
		return new Socket(this.serverIpAddress,this.serverPort);
	}
}