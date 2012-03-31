package trafficticket.controller.login;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import extension.model.Offense;
import extension.model.ServiceRequest;
import extension.model.User;

import trafficticket.controller.ConnectionController;
import trafficticket.jcf.view.JCFFrame;
import trafficticket.taxoffice.view.TaxFrame;
import trafficticket.view.TrafficTicketLoginForm;
import trafficticket.view.TrafficTicketLoginFrame;

public class BtnLoginController extends MouseAdapter implements ActionListener {

	private TrafficTicketLoginForm loginPage;
	private String eventSource;
	public BtnLoginController() 
	{
	
	}

	public BtnLoginController(TrafficTicketLoginForm loginPage,String eventSource) 
	{
		this.loginPage = loginPage;
		this.eventSource = eventSource;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(this.eventSource.equalsIgnoreCase("btnLogin"))
		{
			this.login();
		}
	}

	private void login() {
		
		
		ServiceRequest serviceRequest = new ServiceRequest(ServiceRequest.GET_USER);
		
		User loginUser = new User();
		
		loginUser.setHandle(this.loginPage.getTxtUsername().getText().trim());
		loginUser.setPassword(String.valueOf(this.loginPage.getTxtPassword().getPassword()));
		
		serviceRequest.getData().add(loginUser);
		
		ConnectionController connectionController = new ConnectionController(serviceRequest);

		try 
		{
			connectionController.submitRequest();
			
			if(connectionController.isDialogSuccess())
			{
				Vector<User> users;
				
				users = (Vector<User>) connectionController.getSuccessServiceResponse().getData();
				
				if(!users.isEmpty())
				{
					
					TrafficTicketLoginFrame loginFrame = (TrafficTicketLoginFrame) this.loginPage.getTopLevelAncestor();
					if(loginFrame != null)
					{
					
						User foundUser = (User) users.firstElement();
						
						if(foundUser.getType()==User.POLICE)
						{
							
							loginFrame.setVisible(false);
	
							/* distroy the login frame and all its contents */
							loginFrame.dispose();
	
							// start Tax Office program module
							// TaxFrame taxFrame = new TaxFrame();
							// SwingUtilities.invokeLater(taxFrame);
	
							// start Tax Office program module
							JCFFrame jcfFrame = new JCFFrame();
							SwingUtilities.invokeLater(jcfFrame);
						}
						else if(foundUser.getType()==User.TAXOFFICER)
						{
							loginFrame.setVisible(false);
							
							/* distroy the login frame and all its contents */
							loginFrame.dispose();
	
							// start Tax Office program module
							// TaxFrame taxFrame = new TaxFrame();
							// SwingUtilities.invokeLater(taxFrame);
	
							// start Tax Office program module
							TaxFrame taxFrame = new TaxFrame();
							SwingUtilities.invokeLater(taxFrame);
						}
					}
					else
					{
						
					}
				}
				else
				{
					this.loginPage.getLblLoginStatus().setText("Username or Password is incorrect");
					this.loginPage.getLblLoginStatus().setForeground(Color.RED);
				}
				connectionController = null;
			}
		} 
		catch (NumberFormatException | ClassNotFoundException | SAXException | IOException| ParserConfigurationException | ClassCastException e) 
		{
			this.loginPage.getLblLoginStatus().setText("An unexpected error occured.");
			this.loginPage.getLblLoginStatus().setForeground(Color.RED);
		}

	}
}