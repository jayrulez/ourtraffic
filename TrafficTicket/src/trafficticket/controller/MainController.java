package trafficticket.controller;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import trafficticket.view.TrafficTicketLoginForm;
import trafficticket.view.TrafficTicketLoginFrame;

public class MainController
{
	public static void startLoginModule()
	{
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			TrafficTicketLoginFrame loginFrame = new TrafficTicketLoginFrame();
		
			/*Dispatch this frame as a thread to dynamically alter the frame's 
			 * components outside of the Event Thread*/
			SwingUtilities.invokeLater(loginFrame);
		}
	}
	public static void main(String[] args)
	{
		startLoginModule();
	}
}