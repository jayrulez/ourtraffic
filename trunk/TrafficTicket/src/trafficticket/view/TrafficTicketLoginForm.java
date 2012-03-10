package trafficticket.view;

import java.awt.event.ActionListener;

import trafficlayout.form.LoginForm;
import trafficticket.controller.LoginController;

public class TrafficTicketLoginForm extends LoginForm
{
	private static final long serialVersionUID = 1L;
	private LoginController loginController;
	
	public TrafficTicketLoginForm() 
	{
		super("Username:","Password:","","","Login");
		super.render();
		this.loginController = new LoginController();
		this.btnLoginMouseListener();
	}
	
	
	public void btnLoginMouseListener()
	{
		this.btnLogin.addMouseListener(loginController.btnLoginClicked());
	}
	
}