package ticketserver.controller;
import java.net.*;
import java.io.*;

class TSThreadHandler extends Thread
{
	public Socket socket;
	public int requestId;

	TSThreadHandler(Socket socket, int requestId)
	{
		this.socket    = socket;
		this.requestId = requestId;
	}

	public void run()
	{
		try
		{
			DataInputStream is = new DataInputStream(this.socket.getInputStream());
			PrintStream os     = new PrintStream(this.socket.getOutputStream());

			this.socket.close();
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
	}
}