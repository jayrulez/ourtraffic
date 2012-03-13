package trafficticket.jcf.view;


import javax.swing.JSplitPane;

import trafficlayout.MasterFrame;

public class JCFFrame extends MasterFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	private JCFMenuBar mainMenuBar;
	private JCFMainMenuTreePanel mainNavMenu;
	private JCFContentPanel contentPanel;
	public JCFFrame() 
	{
		super();
		this.initiate();
	}
	public void initiate()
	{
		this.mainMenuBar = new JCFMenuBar();
		this.mainNavMenu = new JCFMainMenuTreePanel();
		this.contentPanel = new JCFContentPanel();
		super.splitPane = new JSplitPane();
	}

	public void render() 
	{
		this.setTitle("JCF Traffic");
		
		super.leftNavPanel = this.mainNavMenu;
		super.contentPanel = this.contentPanel;
		
		this.setJMenuBar(this.mainMenuBar);
		
		this.mainNavMenu.render();
		super.render();
	}
	
	public void run()
	{
		this.render();
	}
}
