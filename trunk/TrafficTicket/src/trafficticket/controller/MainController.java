package trafficticket.controller;

import javax.swing.SwingUtilities;

import trafficticket.view.TrafficTicketLoginForm;
import trafficticket.view.TrafficTicketLoginFrame;

public class MainController
{
	public static void startLoginModule()
	{
		TrafficTicketLoginFrame loginFrame = new TrafficTicketLoginFrame();

		loginFrame.setContentPanel(new TrafficTicketLoginForm(loginFrame));
		
		/*Dispatch this frame as a thread to dynamically alter the frame's 
		 * components outside of the Event Thread*/
		SwingUtilities.invokeLater(loginFrame);
	}
	public static void main(String[] args)
	{
		startLoginModule();
	}
}