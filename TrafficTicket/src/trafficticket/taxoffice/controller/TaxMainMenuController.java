package trafficticket.taxoffice.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import trafficticket.taxoffice.view.ViewTicket;
import trafficticket.taxoffice.view.TaxFrame;
import trafficticket.taxoffice.view.TicketPayment;
import trafficticket.taxoffice.view.ViewOffense;
import trafficticket.view.ContentTab;

public class TaxMainMenuController extends MouseAdapter implements ActionListener
{
	private TaxFrame parentFrame;

	public TaxMainMenuController(TaxFrame parentFrame) 
	{
		this.parentFrame = parentFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String actionCommand = new String(arg0.getActionCommand());

		if (actionCommand.equalsIgnoreCase("View Tickets")) 
		{
			ViewTicket viewTicket = new ViewTicket();
			this.parentFrame.addTab("View Tickets",new ImageIcon(TaxMainMenuController.class.getResource("/trafficticket/resources/viewTicketIcon_16x16.png")),new ContentTab(viewTicket));
			viewTicket.initialiseListener();

		}
		else if (actionCommand.equalsIgnoreCase("Ticket Payment")) 
		{
			TicketPayment ticketPayment = new TicketPayment();
			this.parentFrame.addTab("Ticket Payment",new ImageIcon(TaxMainMenuController.class.getResource("/trafficticket/resources/ticketPaymentIcon_16x16.png")),new ContentTab(ticketPayment));
			ticketPayment.initialiseListeners();
		}
		else if (actionCommand.equalsIgnoreCase("View Offenses")) 
		{
			ViewOffense viewOffense = new ViewOffense();
			this.parentFrame.addTab("View Offenses",new ImageIcon(TaxMainMenuController.class.getResource("/trafficticket/resources/viewOffensesIcon_16x16.png")),new ContentTab(viewOffense));
			viewOffense.initialiseListeners();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{

	}

	public JFrame getParentFrame() 
	{
		return parentFrame;
	}
}