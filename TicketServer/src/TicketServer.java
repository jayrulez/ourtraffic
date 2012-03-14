import java.net.*;
import java.io.*;

public class TicketServer
{
	public final static int PORT = 5566;

	public static void main(String[] args) throws Exception
	{
		int requestId = 1;

		try
		{
			ServerSocket serverSocket = new ServerSocket(TicketServer.PORT);

			System.out.println("TicketServer initialized on port " + PORT);

			for(;;)
			{
				Socket socket = serverSocket.accept();
				
				System.out.println("Creating thread");

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
}