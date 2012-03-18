package trafficticket.jcf.view;

import javax.swing.JPanel;

import trafficticket.view.MasterFrame;

public class JCFFrame extends MasterFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private JCFMenuBar mainMenuBar;
	private JCFMainMenu mainNavMenu;
	private JPanel contentPagePanel;

	public JCFFrame() {
		
	}

	public void initGui() {

		this.setTitle("JCF Traffic");

		this.mainMenuBar = new JCFMenuBar();
		this.setJMenuBar(this.mainMenuBar);
		this.mainMenuBar.initialize();

		this.mainNavMenu = new JCFMainMenu();
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
			this.initGui();
	}
}
