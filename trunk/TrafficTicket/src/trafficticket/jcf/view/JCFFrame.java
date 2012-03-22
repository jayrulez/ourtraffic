package trafficticket.jcf.view;

import trafficticket.controller.FrameConnectionController;
import trafficticket.controller.MiscController;

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

		this.setVisible(true);
	}
	
	public void testConnection()
	{
		Thread connectionThread = new Thread(new FrameConnectionController(this,"JCFFrame"));
		connectionThread.start();
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
