package trafficticket.jcf.view;

import javax.swing.JMenuBar;

import trafficlayout.MasterFrame;

public class JCFFrame extends MasterFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	private JCFMenuBar mainMenuBar;
	public JCFFrame() 
	{
		super();
		this.initiate();
	}
	public void initiate()
	{
		this.mainMenuBar = new JCFMenuBar();
	}

	public void render() 
	{
		this.setTitle("JCF Traffic");
		super.render();
		this.setJMenuBar(this.mainMenuBar);
	}
	
	public void run()
	{
		this.render();
	}
}
