package trafficticket.taxoffice.view;


import javax.swing.ImageIcon;

import extension.view.ImagePanel;
import trafficticket.jcf.view.Start;
import trafficticket.view.ContentTab;
import trafficticket.view.MasterFrame;

public class TaxFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private TaxMenuBar mainMenuBar;
	private TaxMainMenu mainNavMenu;
	

	public TaxFrame() 
	{
		
		this.initGui();
	}

	public void initGui() {

		this.setTitle("Tax Traffic");

		this.mainMenuBar = new TaxMenuBar();
		this.setJMenuBar(this.mainMenuBar);
		this.mainMenuBar.initialize();
		this.mainMenuBar.initializeListener();

		this.mainNavMenu = new TaxMainMenu();
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
