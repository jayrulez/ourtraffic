package trafficticket.jcf.view;


import javax.swing.ImageIcon;

import extension.view.ImagePanel;
import trafficticket.view.ContentPage;
import trafficticket.view.ContentTab;
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
	
	public void run() 
	{
		this.testConnection();	
		this.initClock();
		
		Start startPage = new Start();
		this.addTab("Start",new ImageIcon(ImagePanel.class.getResource("/trafficticket/resources/startIcon.png")) , new ContentTab(startPage));
		startPage.startInit();		
	}
}
