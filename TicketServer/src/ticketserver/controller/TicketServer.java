package ticketserver.controller;
import java.net.*;
import java.io.*;


public class TicketServer implements Runnable
{
	public final static int PORT = 26001;

	public void initialize()
	{
		int requestId = 1;

		try
		{
			ServerSocket serverSocket = new ServerSocket(TicketServer.PORT);

			System.out.println("TicketServer initialized on port " + PORT);

			for(;;)
			{
				Socket socket = serverSocket.accept();
				
				System.out.println("Client Connected");

				Thread thread = new TSThreadHandler(socket, requestId);

				thread.start();

				requestId++;
			}
		}
		catch(IOException e)
		{
			System.err.println("Cannot initialize TicketServer on port " + PORT);

			e.printStackTrace();

			System.exit(-1);
		}
	}

	@Override
	public void run() 
	{
		this.initialize();
	}
}