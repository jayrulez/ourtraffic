package trafficticket.controller.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class BtnLoginController extends MouseAdapter implements ActionListener
{
	
	private JLabel lblControllerStatus;
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
		//this.lblControllerStatus.add();
	}
}