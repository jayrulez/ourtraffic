package trafficticket.jcf.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import trafficticket.jcf.view.IssueTicket;
import trafficticket.jcf.view.JCFFrame;
import trafficticket.jcf.view.ViewOffender;
import trafficticket.jcf.view.ViewOffense;
import trafficticket.jcf.view.ViewTicket;


public class JCFMainMenuController extends MouseAdapter  implements ActionListener
{
	private JCFFrame parentFrame;
	public JCFMainMenuController(JCFFrame parentFrame) 
	{
		this.parentFrame = parentFrame;
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String actionCommand = new String(arg0.getActionCommand());
		
		if(actionCommand.compareTo("Issue a Ticket")==0 )
		{
			System.out.println(arg0.getActionCommand());
			this.parentFrame.addTab("View Tickets",new IssueTicket());
		}
		else if(actionCommand.compareTo("View Tickets")==0)
		{
			
			System.out.println(arg0.getActionCommand());
			this.parentFrame.addTab("View Tickets",new ViewTicket());	
			
		}
		else if(actionCommand.compareTo("View Offenders")==0)
		{
			System.out.println(arg0.getActionCommand());
			this.parentFrame.addTab("View Tickets",new ViewOffender());		
		}
		else if(actionCommand.compareTo("View Offenses")==0)
		{
			System.out.println(arg0.getActionCommand());
			this.parentFrame.addTab("View Tickets",new ViewOffense());		
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{

	}
	public JFrame getParentFrame() {
		return parentFrame;
	}
}