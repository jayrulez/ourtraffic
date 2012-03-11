package trafficticket.view;

//import java.awt.event.ActionListener;

import javax.swing.JFrame;

import trafficlayout.form.LoginForm;
import trafficticket.controller.login.BtnLoginController;

public class TrafficTicketLoginForm extends LoginForm
{
	private static final long serialVersionUID = 1L;
	private BtnLoginController btnLoginController;
	private JFrame parentFrame;
	
	public TrafficTicketLoginForm() 
	{
		super("Username:","Password:","","","Login");
		super.render();
		this.initiateListners();
	}
	
	public TrafficTicketLoginForm(JFrame parentFrame) 
	{
		super("Username:","Password:","","","Login");
		super.render();
		this.parentFrame = parentFrame;
		this.initiateListners();
	}
	
	public void setParentFrame(JFrame parentFrame) 
	{
		this.parentFrame = parentFrame;
	}
	
	public void initiateListners()
	{
		this.btnLoginController = new BtnLoginController(this.lblStatus);
		this.btnLoginController.setParentFrame(parentFrame);
		this.btnLogin.addMouseListener(btnLoginController);
		this.btnLogin.addActionListener(btnLoginController);
	}
	
}