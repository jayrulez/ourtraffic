package trafficticket.controller.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import trafficticket.jcf.view.JCFFrame;

public class BtnLoginController extends MouseAdapter implements ActionListener
{
	
	private JLabel lblControllerStatus;
	private JFrame parentFrame;
	
	public BtnLoginController() 
	{
		this.lblControllerStatus = new JLabel();
	}
	public BtnLoginController(JLabel lblControllerStatus)
	{
		this.lblControllerStatus = lblControllerStatus;
		
	}
	
	public void setLblControllerStatus(JLabel lblControllerStatus) 
	{
		this.lblControllerStatus = lblControllerStatus;
	}
	
	public void setParentFrame(JFrame loginFrame)
	{
		this.parentFrame = loginFrame;
	}
	
	public JLabel getLblControllerStatus() 
	{
		return lblControllerStatus;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		this.lblControllerStatus.setText("Logging in...");

		/*Close the login frame (frame that contains the login form)*/
		this.parentFrame.dispose();
		
		if(true/*logged in user is JCF user*/)
		{
			JCFFrame jcfFrame = new JCFFrame();
			SwingUtilities.invokeLater(jcfFrame);
		}
	}
}