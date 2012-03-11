package trafficticket.jcf.view;

import javax.swing.JMenuBar;

import trafficlayout.MasterFrame;

public class JCFFrame extends MasterFrame
{
	private static final long serialVersionUID = 1L;
	private JCFMenuBar mainMenuBar;
	public JCFFrame() 
	{
		super();
		
	}
	public void initiate()
	{
		this.mainMenuBar = new JCFMenuBar();
	}
	@Override
	public void render() 
	{
		super.render();
		this.setJMenuBar(this.mainMenuBar);
	}
}
