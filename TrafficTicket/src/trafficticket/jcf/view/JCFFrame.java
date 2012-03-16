package trafficticket.jcf.view;


import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import trafficticket.view.MasterFrame;

public class JCFFrame extends MasterFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	private JCFMenuBar mainMenuBar;
	private JCFMainMenu mainNavMenu;
	private JCFContentPanel contentPanel;
	public JCFFrame() 
	{
		super();
		this.initiate();
	}
	public void initiate()
	{
		this.mainMenuBar = new JCFMenuBar();
		this.mainNavMenu = new JCFMainMenu();
		this.contentPanel = new JCFContentPanel();
		super.splitPane = new JSplitPane();
		super.scrollPane = new JScrollPane();
		super.contentScrollPane = new JScrollPane();
	}

	public void render() 
	{
		this.setTitle("JCF Traffic");
		
		super.leftNavPanel = this.mainNavMenu;
		
		super.scrollPane.getViewport().add(this.mainNavMenu);
		
		super.scrollPane.setMaximumSize(new Dimension(200,500));
		
		super.contentPanel = this.contentPanel;
		super.contentScrollPane.getViewport().add(this.contentPanel);
		
		this.setJMenuBar(this.mainMenuBar);
		this.mainMenuBar.setTargetContentPanel(this.contentPanel);
		this.mainMenuBar.render();
		this.mainNavMenu.render();
		super.render();
	}
	
	public void run()
	{
		this.render();
	}
}
