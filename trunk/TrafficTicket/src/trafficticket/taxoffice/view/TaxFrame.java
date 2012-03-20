package trafficticket.taxoffice.view;


import trafficticket.view.MasterFrame;

public class TaxFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private TaxMenuBar mainMenuBar;
	private TaxMainMenu mainNavMenu;
	

	public TaxFrame() {
		
	}

	public void initGui() {

		this.setTitle("Tax Traffic");

		this.mainMenuBar = new TaxMenuBar();
		this.setJMenuBar(this.mainMenuBar);
		this.mainMenuBar.initialize();

		this.mainNavMenu = new TaxMainMenu();
		this.addLeftNavPanelContent(this.mainNavMenu);


		this.setVisible(true);
	}
	public void run() 
	{
			this.initGui();
	}
}
