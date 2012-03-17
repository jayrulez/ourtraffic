package trafficticket.jcf.view;

import trafficticket.view.MasterFrame;

public class JCFFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private JCFMenuBar mainMenuBar;
	private JCFMainMenu mainNavMenu;
	private JCFContentPanel contentPanel;

	public JCFFrame() {
		
	}

	public void initialise() {

		this.setTitle("JCF Traffic");

		this.mainMenuBar = new JCFMenuBar();
		this.setJMenuBar(this.mainMenuBar);
		this.mainMenuBar.initialize();

		this.mainNavMenu = new JCFMainMenu();
		this.setLeftNavPanelContent(this.mainNavMenu);

		this.contentPanel = new JCFContentPanel();
		this.setContentPanel(this.contentPanel);

		this.mainMenuBar.setTargetContentPanel(this.contentPanel);
		this.setVisible(true);
	}

	public void run() {
		this.initialise();
	}
}
