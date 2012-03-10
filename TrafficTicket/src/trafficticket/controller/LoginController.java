package trafficticket.controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class LoginController
{
	protected ActionListener loginEventListner;
	protected MouseAdapter loginMouseListener;
	
	public LoginController() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public MouseAdapter btnLoginClicked()
	{
		this.loginMouseListener = new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//connect to server
			}
		};
		return this.loginMouseListener;
	}
}