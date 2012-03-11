package trafficticket.view;

import javax.swing.JMenuBar;

import trafficlayout.LoginFrame;

public class TrafficTicketLoginFrame extends LoginFrame
{
	private static final long serialVersionUID = 1L;
	private LoginMenuBar loginMenuBar;
	
	public TrafficTicketLoginFrame() 
	{
		super();
		this.initiate();
	}
	public void initiate()
	{
		this.loginMenuBar = new LoginMenuBar();
	}
	
	@Override
	public void run()
	{
		super.render();
		this.render();
	}
	
	public void render()
	{
		this.loginMenuBar.render();
		this.setJMenuBar(this.loginMenuBar);
	}
	
}