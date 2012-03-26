package ticketserver.view;


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
		this.mainNavMenu.initialize();
		
		this.setVisible(true);
	}
	public void run() 
	{
			this.initGui();
	}
}
