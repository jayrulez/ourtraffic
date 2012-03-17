package trafficticket.jcf.view;

import javax.swing.JPanel;

import trafficticket.view.MasterFrame;

public class JCFFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private JCFMenuBar mainMenuBar;
	private JCFMainMenu mainNavMenu;
	private JPanel contentPanel;

	public JCFFrame() {
		
	}

	public void initialize() {

		this.setTitle("JCF Traffic");

		this.mainMenuBar = new JCFMenuBar();
		this.setJMenuBar(this.mainMenuBar);
		this.mainMenuBar.initialize();

		this.mainNavMenu = new JCFMainMenu();
		this.setLeftNavPanelContent(this.mainNavMenu);

		this.contentPanel = new JPanel();
		this.setContentPanel(this.contentPanel);

		this.mainMenuBar.setTargetContentPanel(this.contentPanel);
		this.setVisible(true);
	}

	public void run() {
		this.initialize();
	}
}
