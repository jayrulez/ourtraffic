package trafficticket.jcf.view;

import trafficticket.controller.MiscController;
import trafficticket.jcf.controller.JCFFrameConnectionController;

import trafficticket.view.MasterFrame;

public class JCFFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private JCFMenuBar mainMenuBar;
	private JCFMainMenu mainNavMenu;

	public JCFFrame() 
	{
		super();
		this.initGui();
	}

	public void initGui() 
	{

		this.setTitle("JCF Traffic");

		this.mainMenuBar = new JCFMenuBar();
		this.setJMenuBar(this.mainMenuBar);
		this.mainMenuBar.initialize();

		this.mainNavMenu = new JCFMainMenu();
		this.addLeftNavPanelContent(this.mainNavMenu);
		this.mainNavMenu.initialiseLisenters();

		this.setVisible(true);
	}
	
	public void testConnection()
	{
		Thread connectionStatusThread = new Thread(new JCFFrameConnectionController(this));
		connectionStatusThread.start();
	}

	public void initClock()
	{
		Thread miscThread = new Thread(new MiscController(this, "clock"));
		miscThread.start();
	}
	
	public void run() 
	{
		this.testConnection();	
		this.initClock();
	}
}
