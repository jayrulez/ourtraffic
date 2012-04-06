package ticketserver.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ticketserver.view.AddOffense;
import ticketserver.view.AddUser;
import ticketserver.view.TicketServerFrame;
import ticketserver.view.ViewOffense;
import ticketserver.view.ViewUser;

public class MainMenuController extends MouseAdapter implements ActionListener 
{
	private TicketServerFrame parentFrame;

	public MainMenuController(TicketServerFrame parentFrame) 
	{
		this.parentFrame = parentFrame;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String actionCommand = new String(arg0.getActionCommand());

		if (actionCommand.compareTo("View Users") == 0) 
		{

			System.out.println(arg0.getActionCommand());
			/*
			 * this.parentFrame .addTab("View Tickets", new ImageIcon(
			 * TaxMainMenuController.class
			 * .getResource("/trafficticket/resources/viewTicketIcon_16x16.png"
			 * )), new ViewTicket());
			 */

		}
		else if (actionCommand.equalsIgnoreCase("Add User")) 
		{

			System.out.println(arg0.getActionCommand());
			System.out.println(this.parentFrame);
			 this.parentFrame .addTab("Add User", new ImageIcon(MainMenuController.class.getResource("/ticketserver/resources/addUserIcon_16x16.png")), new AddUser());
		}
		else if(actionCommand.equalsIgnoreCase("View Users")) 
		{

			System.out.println(arg0.getActionCommand());
			System.out.println(this.parentFrame);
			 this.parentFrame .addTab("View Users", new ImageIcon(MainMenuController.class.getResource("/ticketserver/resources/viewUserIcon_16x16.png")), new ViewUser());
		}
		else if(actionCommand.equalsIgnoreCase("Add Offense")) 
		{

			System.out.println(arg0.getActionCommand());
			System.out.println(this.parentFrame);
			 this.parentFrame .addTab("Add Offense", new ImageIcon(MainMenuController.class.getResource("/ticketserver/resources/viewUserIcon_16x16.png")), new AddOffense());
		}
		else if(actionCommand.equalsIgnoreCase("View Offenses")) 
		{

			System.out.println(arg0.getActionCommand());
			System.out.println(this.parentFrame);
			 this.parentFrame .addTab("View Offenses", new ImageIcon(MainMenuController.class.getResource("/ticketserver/resources/viewOffenseIcon_16x16.png")), new ViewOffense());
		}
		else if(actionCommand.equalsIgnoreCase("View Connections")) 
		{

			System.out.println(arg0.getActionCommand());
			System.out.println(this.parentFrame);
			 this.parentFrame .addTab("View Offenses", new ImageIcon(MainMenuController.class.getResource("/ticketserver/resources/connectionIcon_16x16.png")), new ViewOffense());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	public JFrame getParentFrame() {
		return parentFrame;
	}
}