package trafficticket.controller;

import javax.swing.SwingUtilities;

import trafficlayout.LoginFrame;

import trafficticket.view.TrafficTicketLoginForm;

public class MainController
{
	public static void main(String[] args)
	{
		LoginFrame loginFrame = new LoginFrame();

		loginFrame.setContentPanel(new TrafficTicketLoginForm());
		
		SwingUtilities.invokeLater(loginFrame);		
	}
}