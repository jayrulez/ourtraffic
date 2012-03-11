package trafficticket.controller;

import javax.swing.SwingUtilities;

import trafficlayout.LoginFrame;
import trafficticket.view.TrafficTicketLoginForm;
import trafficticket.view.TrafficTicketLoginFrame;

public class MainController
{
	public static void main(String[] args)
	{
		LoginFrame loginFrame = new TrafficTicketLoginFrame();

		loginFrame.setContentPanel(new TrafficTicketLoginForm());
		
		SwingUtilities.invokeLater(loginFrame);		
	}
}