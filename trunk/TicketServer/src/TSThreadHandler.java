import java.net.*;
import java.io.*;

class TSThreadHandler extends Thread
{
	public Socket newSock;
	public int requestId;

	TSThreadHandler(Socket sock, int requestId)
	{
		this.newSock   = sock;
		this.requestId = requestId;
	}

	public void run()
	{
		try
		{

		}
		catch(...)
		{

		}
	}
}