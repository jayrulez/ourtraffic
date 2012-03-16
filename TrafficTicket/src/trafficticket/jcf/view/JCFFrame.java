package trafficticket.jcf.view;

import java.awt.Dimension;

import trafficticket.view.MasterFrame;

public class JCFFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private JCFMenuBar mainMenuBar;
	private JCFMainMenu mainNavMenu;
	private JCFContentPanel contentPanel;

	public JCFFrame() {
		this.initialise();
	}

	public void initialise() {

		this.setTitle("JCF Traffic");

		this.mainMenuBar = new JCFMenuBar();
		this.setJMenuBar(this.mainMenuBar);

		this.mainNavMenu = new JCFMainMenu();
		super.setLeftNavPanelContent(this.mainNavMenu);

		this.contentPanel = new JCFContentPanel();
		this.setContentPanel(this.contentPanel);

		this.mainMenuBar.setTargetContentPanel(this.contentPanel);
	}

	public void run() {

	}
}
