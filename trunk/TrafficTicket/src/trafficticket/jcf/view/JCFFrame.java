package trafficticket.jcf.view;

import trafficticket.view.MasterFrame;

public class JCFFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private JCFMenuBar mainMenuBar;
	private JCFMainMenu mainNavMenu;



	public JCFFrame() {
		
	}

	public void initGui() {

		this.setTitle("JCF Traffic");

		this.mainMenuBar = new JCFMenuBar();
		this.setJMenuBar(this.mainMenuBar);
		this.mainMenuBar.initialize();

		this.mainNavMenu = new JCFMainMenu();
		this.addLeftNavPanelContent(this.mainNavMenu);

		this.setVisible(true);
	}

	public void run() 
	{
			this.initGui();
	}
}
