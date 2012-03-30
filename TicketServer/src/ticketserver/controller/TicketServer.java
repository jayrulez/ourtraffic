package ticketserver.controller;
import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;

import ticketserver.view.TicketServerFrame;


public class TicketServer implements Runnable
{
	public final static int PORT = 26001;
	private TicketServerFrame parentFrame;
	
	public TicketServer(TicketServerFrame parentFrame) 
	{
		this.parentFrame = parentFrame;
	}
	
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
				
				//System.out.println("Client Connected");

				Thread thread = new TSThreadHandler(socket);

				thread.start();

				requestId++;
			}
		}
		catch(IOException e)
		{
			this.parentFrame.dispose();
			JOptionPane.showMessageDialog(this.parentFrame, "Cannot initialize TicketServer on port " + PORT,"Ticket Server: startup failed",JOptionPane.ERROR_MESSAGE);
			System.exit(-1);
		}
	}

	@Override
	public void run() 
	{
		this.initialize();
	}

	public TicketServerFrame getParentFrame() {
		return parentFrame;
	}

	public void setParentFrame(TicketServerFrame parentFrame) {
		this.parentFrame = parentFrame;
	}
}