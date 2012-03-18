package trafficticket.taxoffice.view;

import javax.swing.JPanel;

import trafficticket.view.MasterFrame;

public class TaxFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private TaxMenuBar mainMenuBar;
	private TaxMainMenu mainNavMenu;
	private JPanel contentPagePanel;

	public TaxFrame() {
		
	}

	public void initialize() {

		this.setTitle("Tax Traffic");

		this.mainMenuBar = new TaxMenuBar();
		this.setJMenuBar(this.mainMenuBar);
		this.mainMenuBar.initialize();

		this.mainNavMenu = new TaxMainMenu();
		this.addLeftNavPanelContent(this.mainNavMenu);

		this.contentPagePanel = new JPanel();
		this.addContentPanel(this.contentPagePanel);

		this.setVisible(true);
	}

	public void setContentPagePanel(JPanel contentPagePanel)
	{
		this.contentPagePanel = contentPagePanel;
		//this.setContentPanel(this.contentPagePanel);
	}
	public JPanel getContentPagePanel()
	{
		return contentPagePanel;
	}
	public void run() 
	{
			this.initialize();
	}
}
