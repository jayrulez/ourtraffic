package trafficticket.jcf.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import trafficticket.jcf.view.IssueTicket;
import trafficticket.jcf.view.JCFFrame;
import trafficticket.jcf.view.ViewOffender;
import trafficticket.jcf.view.ViewOffense;
import trafficticket.jcf.view.ViewTicket;
import trafficticket.view.ContentTab;

public class JCFMainMenuController extends MouseAdapter implements
		ActionListener {
	private JCFFrame parentFrame;

	public JCFMainMenuController(JCFFrame parentFrame) {
		this.parentFrame = parentFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String actionCommand = new String(arg0.getActionCommand());

		if (actionCommand.compareTo("Issue a Ticket") == 0) 
		{
			System.out.println(arg0.getActionCommand());
			IssueTicket issueTicket = new IssueTicket();
			
			this.parentFrame.addTab("Issue Ticket",new ImageIcon(JCFMainMenuController.class.getResource("/trafficticket/resources/issueTicketIcon_16x16.png")),new ContentTab(issueTicket));
			
			issueTicket.initializeListeners();
			issueTicket.initializeWorkers();
		}
		else if (actionCommand.compareTo("View Tickets") == 0) 
		{
			System.out.println(arg0.getActionCommand());
			ViewTicket viewTicket = new ViewTicket();
			
			this.parentFrame.addTab("View Tickets",new ImageIcon(JCFMainMenuController.class.getResource("/trafficticket/resources/viewTicketIcon_16x16.png")),new ContentTab(viewTicket));
			
			viewTicket.initialiseListener();
		} 
		else if (actionCommand.compareTo("View Offenders") == 0) 
		{
			System.out.println(arg0.getActionCommand());
			
			ViewOffender viewOffenders = new ViewOffender();
			
			this.parentFrame.addTab("View Offenders",new ImageIcon(JCFMainMenuController.class.getResource("/trafficticket/resources/viewOffenderIcon_16x16.png")),new ContentTab(new ViewOffender()));
			
			viewOffenders.initialiseListeners();
		} 
		else if (actionCommand.compareTo("View Offenses") == 0) 
		{
			System.out.println(arg0.getActionCommand());
			ViewOffense viewOffense = new ViewOffense();
			
			this.parentFrame.addTab("View Offenses",new ImageIcon(JCFMainMenuController.class.getResource("/trafficticket/resources/viewOffensesIcon_16x16.png")),new ContentTab(viewOffense));
			
			viewOffense.initialiseListeners();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	public JFrame getParentFrame() {
		return parentFrame;
	}
}