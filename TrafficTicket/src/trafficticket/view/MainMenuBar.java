package trafficticket.view;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainMenuBar extends JMenuBar
{
	private static final long serialVersionUID = 1L;
	
	protected JMenu fileMenu;
	protected JMenu editMenu;
	protected JMenu viewMenu;
	protected JMenu helpMenu;
	protected JMenuItem exitMenuItem;
	protected JMenuItem aboutMenuItem;
	
	public MainMenuBar() 
	{
		this.initiate();
	}
	public void initiate()
	{
		this.fileMenu = new JMenu("File");
		this.editMenu = new JMenu("Edit");
		this.viewMenu = new JMenu("View");
		this.helpMenu = new JMenu("Help");
		
		this.aboutMenuItem = new JMenuItem("About Traffic Ticket");
		this.exitMenuItem = new JMenuItem("Exit");
	}
	public void render()
	{
		this.helpMenu.add(this.aboutMenuItem);
		this.fileMenu.add(this.exitMenuItem);
		
		this.add(this.fileMenu);
		this.add(this.viewMenu);
		this.add(this.editMenu);
		this.add(this.helpMenu);
	}
}