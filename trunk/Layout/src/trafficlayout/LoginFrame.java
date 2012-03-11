package trafficlayout;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.BoxLayout;

public abstract class LoginFrame extends JFrame implements Runnable
{
	private static final long serialVersionUID = 1L;
	protected JPanel contentPanel;
	
	public LoginFrame() 
	{
		this.initiate();
	}

	public void setContentPanel(JPanel contentPanel)
	{
		this.contentPanel = contentPanel;
		this.add(this.contentPanel);
	}
	
	public void initiate()
	{
		
	}
	
	public void render()
	{
		this.setTitle("Traffic Ticket");
		super.setMinimumSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
	}
	
}