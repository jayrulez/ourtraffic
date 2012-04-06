package ticketserver.view;

import ticketserver.controller.TicketServerFrameConnectionController;


public class TicketServerFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private MenuBar mainMenuBar;
	private MainMenu mainNavMenu;
	

	public TicketServerFrame() {
		
	}

	public void initGui() {

		this.setTitle("Ticket Server");

		this.mainMenuBar = new MenuBar();
		this.setJMenuBar(this.mainMenuBar);
		this.mainMenuBar.initialize();

		this.mainNavMenu = new MainMenu();
		this.addLeftNavPanelContent(this.mainNavMenu);
		this.mainNavMenu.initialiseLisenters();
		
		this.setVisible(true);
	}
	
	public void testConnection()
	{
		Thread connectionStatusThread = new Thread(new TicketServerFrameConnectionController(this));
		connectionStatusThread.start();
	}
	
	public void run() 
	{
			this.initGui();
			this.testConnection();
	}
}
