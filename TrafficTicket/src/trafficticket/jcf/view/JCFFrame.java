package trafficticket.jcf.view;

import javax.swing.JMenuBar;

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
	}

	public void render() 
	{
		this.setTitle("JCF Traffic");
		this.leftNavPanel = this.mainNavMenu;
		this.setJMenuBar(this.mainMenuBar);
		super.render();
	}
	
	public void run()
	{
		this.render();
	}
}
