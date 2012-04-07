package ticketserver.view;

import java.awt.BorderLayout;
import java.util.Iterator;
import java.util.Vector;

import extension.model.User;


public class TicketServerFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private MenuBar mainMenuBar;
	private MainMenu mainNavMenu;
	private ToolBar mainToolBar;
	
	private Vector<User> currentClients;

	public TicketServerFrame() {
		this.currentClients = new Vector<User>();
	}

	public void initGui() {

		this.setTitle("Ticket Server");

		this.mainMenuBar = new MenuBar();
		this.setJMenuBar(this.mainMenuBar);
		this.mainMenuBar.initialize();

		this.mainToolBar = new ToolBar();
		this.add(mainToolBar,BorderLayout.NORTH);
		
		this.mainNavMenu = new MainMenu();
		this.addLeftNavPanelContent(this.mainNavMenu);
		this.mainNavMenu.initialiseLisenters();
		
		this.setVisible(true);
	}
	
	public void run() 
	{
			this.initGui();
			this.testConnection();
			this.initClock();
	}

	
	public void addUser(User newUser)
	{
		if(!this.currentClients.isEmpty())
		{
			if(!this.userExists(newUser))
			{
				this.currentClients.add(newUser);	
			}
		}
		else
		{
			this.currentClients.add(newUser);
		}
	}
	
	public void removeUser(User newUser)
	{
		Iterator itr = this.currentClients.iterator();
		int index =-1;
		while(itr.hasNext())
		{
			User user = (User)itr.next();
			index++;
			if(user.getHandle().equalsIgnoreCase(newUser.getHandle()))
			{
				this.currentClients.remove(index);
			}
		}		
	}	
	
	public boolean userExists(User newUser)
	{
		Iterator itr = this.currentClients.iterator();
		int index =-1;
		while(itr.hasNext())
		{
			User user = (User)itr.next();
			index++;
			if(user.getHandle().equalsIgnoreCase(newUser.getHandle()))
			{
				return true;
			}
		}		
		return false;
	}	
	
	public Vector<User> getCurrentClients() {
		return currentClients;
	}

	public void setCurrentClients(Vector<User> currentClients) {
		this.currentClients = currentClients;
	}
	
	public ToolBar getMainToolBar()
	{
		return this.mainToolBar;
	}
	
}
