package trafficticket.jcf.view;


import java.awt.BorderLayout;

import javax.swing.ImageIcon;

import trafficticket.view.ContentTab;
import trafficticket.view.MasterFrame;
import trafficticket.view.ToolBar;

public class JCFFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private JCFMenuBar mainMenuBar;
	private JCFMainMenu mainNavMenu;
	private ToolBar mainToolBar;

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

		this.mainToolBar = new ToolBar();
		this.add(mainToolBar,BorderLayout.NORTH);
		
		this.mainNavMenu = new JCFMainMenu();
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
		this.addTab("Start",new ImageIcon(JCFFrame.class.getResource("/trafficticket/resources/startIcon.png")) , new ContentTab(startPage));
		startPage.startInit();		
	}
}
