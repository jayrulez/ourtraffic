package trafficticket.view;

//import java.awt.event.ActionListener;

import trafficlayout.form.LoginForm;
import trafficticket.controller.login.BtnLoginController;

public class TrafficTicketLoginForm extends LoginForm
{
	private static final long serialVersionUID = 1L;
	private BtnLoginController btnLoginController;
	
	public TrafficTicketLoginForm() 
	{
		super("Username:","Password:","","","Login");
		super.render();
		this.initiateListners();
	}
	
	
	public void initiateListners()
	{
		this.btnLoginController = new BtnLoginController(this.lblStatus);
		this.btnLogin.addMouseListener(btnLoginController);
		this.btnLogin.addActionListener(btnLoginController);
	}
	
}