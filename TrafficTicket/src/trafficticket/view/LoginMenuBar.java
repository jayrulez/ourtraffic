package trafficticket.view;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LoginMenuBar extends JMenuBar
{
	private static final long serialVersionUID = 1L;
	
	protected JMenu fileMenu;
	protected JMenu helpMenu;

	protected JMenuItem closeMenuItem;
	protected JMenuItem aboutMenuItem;
	
	public LoginMenuBar() 
	{
		this.initiate();
	}
	public void initiate()
	{
		this.fileMenu = new JMenu("File");
		this.helpMenu = new JMenu("Help");
		
		this.aboutMenuItem = new JMenuItem("About Traffic Ticket");
		this.closeMenuItem = new JMenuItem("Exit");
	}
	public void render()
	{
		this.helpMenu.add(this.aboutMenuItem);
		this.fileMenu.add(this.closeMenuItem);	
	
		this.add(this.fileMenu);
		this.add(this.helpMenu);
	}
}