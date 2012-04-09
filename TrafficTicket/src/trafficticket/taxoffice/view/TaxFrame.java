package trafficticket.taxoffice.view;


import java.awt.BorderLayout;

import javax.swing.ImageIcon;

import trafficticket.taxoffice.view.Start;
import trafficticket.view.ContentTab;
import trafficticket.view.MasterFrame;
import trafficticket.view.ToolBar;

public class TaxFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private TaxMenuBar mainMenuBar;
	private TaxMainMenu mainNavMenu;
	private ToolBar mainToolBar;
	

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

		this.mainToolBar = new ToolBar();
		this.add(mainToolBar,BorderLayout.NORTH);
		
		this.mainNavMenu = new TaxMainMenu();
		this.addLeftNavPanelContent(this.mainNavMenu);
		this.mainNavMenu.initialiseLisenters(); 


		this.setVisible(true);
	}

	
	public ToolBar getMainToolBar() {
		return mainToolBar;
	}

	public void setMainToolBar(ToolBar mainToolBar) {
		this.mainToolBar = mainToolBar;
	}

	public void run() 
	{
		this.testConnection();	
		this.initClock();
		
		Start startPage = new Start();
		this.addTab("Start",new ImageIcon(TaxFrame.class.getResource("/trafficticket/resources/startIcon.png")) , new ContentTab(startPage));
		startPage.startInit();		
	}

}
