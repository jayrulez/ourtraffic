package trafficlayout;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import javax.swing.BoxLayout;

public class LoginFrame extends JFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	protected JPanel contentPanel;
	protected JMenuBar mainMenuBar;
	
	public LoginFrame() 
	{
		
		//TODO Auto-generated constructor stub
	}
	
	public void run()
	{
		this.initiate();
		
	}

	public void setContentPanel(JPanel contentPanel)
	{
		this.contentPanel = contentPanel;
		this.add(this.contentPanel);
	}
	
	public void setMainMenuBar(JMenuBar mainMenuBar) 
	{
		this.mainMenuBar = mainMenuBar;
		this.setJMenuBar(this.mainMenuBar);
	}
	
	public void initiate()
	{
		this.setTitle("Traffic Ticket");
		super.setMinimumSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
	}
	
}