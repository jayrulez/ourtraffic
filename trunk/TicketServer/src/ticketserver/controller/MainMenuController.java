package ticketserver.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ticketserver.view.AddOffense;
import ticketserver.view.AddUser;
import ticketserver.view.ContentTab;
import ticketserver.view.TicketServerFrame;
import ticketserver.view.ViewConnection;
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

		if (actionCommand.equalsIgnoreCase("Add User")) 
		{

			System.out.println(arg0.getActionCommand());
			System.out.println(this.parentFrame);
			AddUser addUser = new AddUser();
			this.parentFrame.addTab("Add User", new ImageIcon(MainMenuController.class.getResource("/ticketserver/resources/addUserIcon_16x16.png")),new ContentTab(addUser));
			addUser.initialiseListensers();
		}
		else if(actionCommand.equalsIgnoreCase("View Users")) 
		{

			System.out.println(arg0.getActionCommand());
			System.out.println(this.parentFrame);
			ViewUser viewUser = new ViewUser();
			this.parentFrame.addTab("View Users", new ImageIcon(MainMenuController.class.getResource("/ticketserver/resources/viewUserIcon_16x16.png")), new ContentTab(viewUser));
			viewUser.initialiseListener();
		}
		else if(actionCommand.equalsIgnoreCase("Add Offense")) 
		{

			System.out.println(arg0.getActionCommand());
			System.out.println(this.parentFrame);
			AddOffense addOffense = new AddOffense();
			this.parentFrame.addTab("Add Offense", new ImageIcon(MainMenuController.class.getResource("/ticketserver/resources/addOffenseIcon_16x16.png")), new ContentTab(addOffense));
			addOffense.initialiseListener();
		}
		else if(actionCommand.equalsIgnoreCase("View Offenses")) 
		{

			System.out.println(arg0.getActionCommand());
			System.out.println(this.parentFrame);
			ViewOffense viewOffense = new ViewOffense();
			this.parentFrame.addTab("View Offenses", new ImageIcon(MainMenuController.class.getResource("/ticketserver/resources/viewOffensesIcon_16x16.png")), new ContentTab(viewOffense));
			viewOffense.initialiseListeners();
		}
		else if(actionCommand.equalsIgnoreCase("View Connections")) 
		{

			System.out.println(arg0.getActionCommand());
			System.out.println(this.parentFrame);
			ViewConnection viewConnection = new ViewConnection();
			this.parentFrame.addTab("View Connections", new ImageIcon(MainMenuController.class.getResource("/ticketserver/resources/connectionIcon_16x16.png")), new ContentTab(viewConnection));
			viewConnection.initialiseListener();
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